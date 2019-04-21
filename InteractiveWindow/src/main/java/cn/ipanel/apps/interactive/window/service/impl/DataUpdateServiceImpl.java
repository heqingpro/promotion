package cn.ipanel.apps.interactive.window.service.impl;

import cn.ipanel.apps.interactive.window.dao.MouldRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRecordRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRepository;
import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import cn.ipanel.apps.interactive.window.entity.UserMessageInfo;
import cn.ipanel.apps.interactive.window.entity.UserMessageRecordInfo;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.service.IDataUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/26 下午4:51
 * Modified By:
 * Description:
 */
@Service
public class DataUpdateServiceImpl implements IDataUpdateService {

    private MouldRepository mouldRepository;
    private UserMessageRepository userMessageRepository;
    private UserMessageRecordRepository userMessageRecordRepository;

    @Autowired
    public DataUpdateServiceImpl(MouldRepository mouldRepository, UserMessageRepository userMessageRepository,
                                 UserMessageRecordRepository userMessageRecordRepository) {
        this.mouldRepository = mouldRepository;
        this.userMessageRecordRepository = userMessageRecordRepository;
        this.userMessageRepository = userMessageRepository;
    }

    @Override
    public void updateEffectiveDateAndPriority() {
        List<MouldInfo> list = (List<MouldInfo>) mouldRepository.findAll();
        Integer maxLevel = list.stream().filter(info -> null != info.getPriorityLevel()).map(MouldInfo::getPriorityLevel).max(Comparator.comparing(Integer::intValue)).orElse(0);
        for (MouldInfo mouldInfo : list) {
            if (null == mouldInfo.getPriorityLevel()) {
                mouldInfo.setPriorityLevel(++maxLevel);
            }
            if (null == mouldInfo.getEffectiveDate()) {
                mouldInfo.setEffectiveDate(LocalDateTime.of(2018, 10, 1, 0, 0).toInstant(Globals.getSystemDefaultZoneOffSet()).toEpochMilli());
            }
            mouldRepository.save(mouldInfo);
        }
    }

    @Override
    public void updateUserMessage() {
        List<UserMessageInfo> list = (List<UserMessageInfo>) userMessageRepository.findAll();
        list.forEach(message -> {
            if (Globals.isEmpty(message.getMouldName()) && null != message.getMouldInfo()) {
                message.setMouldName(message.getMouldInfo().getName());
            }
            if (message.getHasPop() && null == message.getPopTime()) {
                List<UserMessageRecordInfo> recordInfoList = userMessageRecordRepository.findByUserMessageId(message.getId());
                if (recordInfoList.isEmpty()) {
                    return;
                }
                recordInfoList.sort(Comparator.comparing(UserMessageRecordInfo::getPopTime).reversed());
                message.setPopTime(recordInfoList.get(0).getPopTime());
            }
            userMessageRepository.save(message);
        });
    }

    @Override
    public void updateUserRecordMessage() {
        Iterable<UserMessageRecordInfo> list = userMessageRecordRepository.findAll();
        list.forEach(recordInfo -> {
            if (recordInfo.getHasResponse()) {
                userMessageRepository.findById(recordInfo.getUserMessageId()).ifPresent(messageInfo -> {
                    if (null != messageInfo.getMouldInfo()) {
                        recordInfo.setResponseButtonName(Globals.getMouldButtonName(messageInfo.getMouldInfo(), recordInfo.getResponse()));
                        userMessageRecordRepository.save(recordInfo);
                    }
                });

            }
        });
    }

    @Override
    public void updateMouldTitle() {
        Iterable<MouldInfo> list = mouldRepository.findAll();
        list.forEach(mouldInfo -> {
            if (Globals.isEmpty(mouldInfo.getTitle())) {
                mouldInfo.setTitle("温馨提示");
                mouldRepository.save(mouldInfo);
            }
        });
    }
}
