package cn.ipanel.apps.interactive.window.service.impl;

import cn.ipanel.apps.interactive.window.controller.resp.MessageVO;
import cn.ipanel.apps.interactive.window.dao.MouldRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRecordRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRepository;
import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import cn.ipanel.apps.interactive.window.entity.UserMessageInfo;
import cn.ipanel.apps.interactive.window.entity.UserMessageRecordInfo;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.global.RequestParamErrorException;
import cn.ipanel.apps.interactive.window.service.IMessageService;
import cn.ipanel.apps.interactive.window.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/12 上午11:11
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class MessageServiceImpl implements IMessageService {

    private UserMessageRepository userMessageRepository;
    private UserMessageRecordRepository userMessageRecordRepository;
    private MouldRepository mouldRepository;

    // 生成唯一序列号
    private SnowflakeIdWorker snowflakeIdWorker = SnowflakeIdWorker.getInstance(1L, 1L);

    // 三个弹窗按钮
    private static final String RESPONSE_BUTTON1 = "button1";
    private static final String RESPONSE_BUTTON2 = "button2";
    private static final String RESPONSE_BUTTON3 = "button3";
    private static final List<String> messageResponse = Arrays.asList(RESPONSE_BUTTON1, RESPONSE_BUTTON2, RESPONSE_BUTTON3);

    @Autowired
    public MessageServiceImpl(UserMessageRepository userMessageRepository, UserMessageRecordRepository userMessageRecordRepository,
                              MouldRepository mouldRepository) {
        this.userMessageRepository = userMessageRepository;
        this.userMessageRecordRepository = userMessageRecordRepository;
        this.mouldRepository = mouldRepository;
    }

    @Override
    public MessageVO queryUserMessage(String userId) throws Exception {
        log.info("by luzh: 用户 {} 查找未读or未响应的弹窗消息.", userId);
        Long nowDate = Instant.now().toEpochMilli();
        List<MouldInfo> mouldInfoList = mouldRepository.findByEffectiveDateLessThanAndExpireDateGreaterThan(nowDate, nowDate)
                .stream()
                .sorted(Comparator.comparing(MouldInfo::getPriorityLevel).reversed())
                .collect(Collectors.toList());
        for (MouldInfo mouldInfo : mouldInfoList) {
            List<UserMessageInfo> messageList = userMessageRepository.findByMouldIdAndUser(mouldInfo.getId(), userId)
                    .stream()
                    .filter(info -> !info.getHasResponse())
                    .sorted(Comparator.comparing(UserMessageInfo::getCreateTime).reversed())
                    .collect(Collectors.toList());
            if (!messageList.isEmpty()) {
                UserMessageInfo messageInfo = messageList.get(0);
                UserMessageRecordInfo recordInfo = new UserMessageRecordInfo(
                        snowflakeIdWorker.nextId() + "",
                        messageInfo.getId(),
                        userId,
                        Instant.now().toEpochMilli()
                );
                recordInfo = userMessageRecordRepository.save(recordInfo);
                messageInfo.setHasPop(true);
                messageInfo.setPopTime(nowDate);
                userMessageRepository.save(messageInfo);
                return new MessageVO(recordInfo, messageInfo);
            }
        }
        return null;
    }

    @Override
    public Boolean messageResponse(String serialNumber, String userId, Long recordId, Long popTime, String response) throws Exception {
        Long responseTime = Instant.now().toEpochMilli();
        UserMessageRecordInfo recordInfo = userMessageRecordRepository.findById(recordId).orElseThrow(() -> new RequestParamErrorException("弹窗记录不存在"));
        if (!serialNumber.equals(recordInfo.getSerialNumber()) || !userId.equals(recordInfo.getUserId()) || !popTime.equals(recordInfo.getPopTime())) {
            throw new RequestParamErrorException("非法请求");
        }
        if (!messageResponse.contains(response)) {
            throw new RequestParamErrorException("响应无效");
        }
        if (recordInfo.getHasResponse()) {
            return true;
        }
        userMessageRepository.findById(recordInfo.getUserMessageId()).ifPresent(messageInfo -> {
            MouldInfo mouldInfo = mouldRepository.findById(messageInfo.getMouldId()).orElse(null);
            recordInfo.setHasResponse(true);
            recordInfo.setResponse(response);
            recordInfo.setResponseTime(responseTime);
            recordInfo.setResponseButtonName(Globals.getMouldButtonName(mouldInfo, response));
            userMessageRecordRepository.save(recordInfo);
            messageInfo.setHasResponse(true);
            messageInfo.setResponseRecordId(recordInfo.getId());
            messageInfo.setResponseTime(responseTime);
            messageInfo.setResponse(response);
            userMessageRepository.save(messageInfo);
        });
        return true;
    }

}
