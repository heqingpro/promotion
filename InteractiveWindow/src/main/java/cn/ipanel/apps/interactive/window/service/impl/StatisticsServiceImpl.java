package cn.ipanel.apps.interactive.window.service.impl;

import cn.ipanel.apps.interactive.window.controller.resp.back.MouldStatisticsItemVO;
import cn.ipanel.apps.interactive.window.controller.resp.back.MouldStatisticsVO;
import cn.ipanel.apps.interactive.window.controller.resp.back.UserMessageVO;
import cn.ipanel.apps.interactive.window.dao.MouldRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRecordRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRepository;
import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import cn.ipanel.apps.interactive.window.entity.UserMessageInfo;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.global.RequestParamErrorException;
import cn.ipanel.apps.interactive.window.service.IStatisticsService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/18 上午11:50
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class StatisticsServiceImpl implements IStatisticsService {

    private MouldRepository mouldRepository;
    private UserMessageRepository userMessageRepository;
    private UserMessageRecordRepository userMessageRecordRepository;

    @Autowired
    public StatisticsServiceImpl(MouldRepository mouldRepository, UserMessageRepository userMessageRepository,
                                 UserMessageRecordRepository userMessageRecordRepository) {
        this.mouldRepository = mouldRepository;
        this.userMessageRepository = userMessageRepository;
        this.userMessageRecordRepository = userMessageRecordRepository;
    }

    @Override
    public MouldStatisticsVO queryStatisticsInfo(Integer mouldId, String startDay, String endDay) throws Exception {
        Globals.checkRequestParam(mouldId, true, null, null, 0, "活动ID");
        final Long startTime = Globals.isEmpty(startDay) ? null : Globals.convertTime(startDay + " 00:00:00");
        final Long endTime = Globals.isEmpty(endDay) ? null : Globals.convertTime(endDay + " 23:59:59");
        MouldInfo mouldInfo = mouldRepository.findById(mouldId).orElseThrow(() -> new RequestParamErrorException("模板不存在"));
        List<UserMessageInfo> messageInfoList = userMessageRepository.findByMouldId(mouldInfo.getId()).stream()
                .filter(info -> null == startTime || info.getCreateTime() > startTime)
                .filter(info -> null == endTime || info.getCreateTime() < endTime)
                .collect(Collectors.toList());
        Map<String, List<UserMessageInfo>> areaMap = messageInfoList.stream().collect(Collectors.groupingBy(UserMessageInfo::getArea));
        List<Long> button1Number = new ArrayList<>();
        List<Long> button2Number = new ArrayList<>();
        List<Long> button3Number = new ArrayList<>();
        MouldStatisticsVO statisticsVO = new MouldStatisticsVO();
        statisticsVO.setButton1Name(Globals.isEmpty(mouldInfo.getButton1Name()) ? "按钮1" : mouldInfo.getButton1Name());
        statisticsVO.setButton2Name(Globals.isEmpty(mouldInfo.getButton2Name()) ? "按钮2" : mouldInfo.getButton2Name());
        statisticsVO.setButton3Name(Globals.isEmpty(mouldInfo.getButton3Name()) ? "按钮3" : mouldInfo.getButton3Name());
        List<MouldStatisticsItemVO> itemVOList = new ArrayList<>();
        areaMap.forEach((area, list) -> {
            MouldStatisticsItemVO itemVO = new MouldStatisticsItemVO();
            itemVO.setArea(area);
            itemVO.setUserNumber(Long.parseLong("" + list.size()));
            itemVO.setPopNumber(Long.parseLong("" + list.stream().filter(UserMessageInfo::getHasPop).count()));
            Map<String, Long> responseMap = list.stream()
                    .filter(UserMessageInfo::getHasResponse)
                    .collect(Collectors.groupingBy(UserMessageInfo::getResponse, Collectors.counting()));
            if (responseMap.containsKey("button1")) {
                itemVO.setButton1Number(responseMap.get("button1"));
                button1Number.add(itemVO.getButton1Number());
            }
            if (responseMap.containsKey("button2")) {
                itemVO.setButton2Number(responseMap.get("button2"));
                button2Number.add(itemVO.getButton2Number());
            }
            if (responseMap.containsKey("button3")) {
                itemVO.setButton3Number(responseMap.get("button3"));
                button3Number.add(itemVO.getButton3Number());
            }
            itemVOList.add(itemVO);
        });
        MouldStatisticsItemVO countVO = new MouldStatisticsItemVO();
        countVO.setArea("总计");
        countVO.setUserNumber(Long.parseLong("" + messageInfoList.size()));
        countVO.setPopNumber(Long.parseLong("" + messageInfoList.stream().filter(UserMessageInfo::getHasPop).count()));
        countVO.setButton1Number(button1Number.stream().reduce(0L, (a, b) -> a + b));
        countVO.setButton2Number(button2Number.stream().reduce(0L, (a, b) -> a + b));
        countVO.setButton3Number(button3Number.stream().reduce(0L, (a, b) -> a + b));
        itemVOList.add(countVO);
        statisticsVO.setList(itemVOList);
        return statisticsVO;
    }

    @Override
    public List<UserMessageVO> queryUserMessage(String user) {
        List<UserMessageInfo> userMessageInfo = userMessageRepository.findByUser(user);
        if (userMessageInfo.isEmpty()) {
            return null;
        }
        List<UserMessageVO> messageVOList = new ArrayList<>();
        userMessageInfo.sort(Comparator.comparing(UserMessageInfo::getCreateTime).reversed());
        userMessageInfo.forEach(messageInfo -> {
            UserMessageVO messageVO = new UserMessageVO();
            messageVO.setPopTime(Globals.formatterDateTime(messageInfo.getPopTime()));
            messageVO.setMouldName(null == messageInfo.getMouldInfo() ? messageInfo.getMouldName() : messageInfo.getMouldInfo().getName());
            messageVO.setHasPop(messageInfo.getHasPop() ? "是" : "否");
            messageVO.setHasResponse(messageInfo.getHasResponse() ? "是" : "否");
            messageVO.setResponseTime(Globals.formatterDateTime(messageInfo.getResponseTime()));
            if (messageInfo.getHasResponse() && null != messageInfo.getResponseRecordId()) {
                userMessageRecordRepository.findById(messageInfo.getResponseRecordId()).ifPresent(recordInfo -> {
                    messageVO.setResponse(recordInfo.getResponseButtonName());
                });
            }
            messageVO.setCreateTime(Globals.formatterDateTime(messageInfo.getCreateTime()));
            messageVOList.add(messageVO);
        });
        log.info("{}", new Gson().toJson(messageVOList));
        return messageVOList;
    }

}
