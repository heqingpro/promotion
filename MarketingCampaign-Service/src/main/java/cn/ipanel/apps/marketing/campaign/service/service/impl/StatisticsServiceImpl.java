package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ActivityStatisticsItemVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ActivityStatisticsVO;
import cn.ipanel.apps.marketing.campaign.service.dao.ActivityRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.ActivityUserRecordRepository;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityUserRecordInfo;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.RequestParamErrorException;
import cn.ipanel.apps.marketing.campaign.service.service.IStatisticsService;
import cn.ipanel.apps.marketing.campaign.service.service.bean.UserRecordForStatistics;
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
 * Create: 2018/9/19 下午2:35
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class StatisticsServiceImpl implements IStatisticsService {

    private ActivityUserRecordRepository activityUserRecordRepository;
    private ActivityRepository activityRepository;

    @Autowired
    public StatisticsServiceImpl(ActivityUserRecordRepository activityUserRecordRepository, ActivityRepository activityRepository) {
        this.activityUserRecordRepository = activityUserRecordRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public ActivityStatisticsVO queryStatisticsInfo(Integer activityId, String startDay, String endDay) throws Exception {
        Globals.checkRequestParam(activityId, true, null, null, 0, "活动ID");
        Globals.checkRequestParam(startDay, true, 10, null, null, "开始时间");
        Globals.checkRequestParam(endDay, true, 10, null, null, "结束时间");
        Long startTime = Globals.convertTime(startDay + " 00:00:00");
        Long endTime = Globals.convertTime(endDay + " 23:59:59");
        if (endTime <= startTime) {
            throw new RequestParamErrorException("请选择正确的开始和结束时间");
        }
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动无效"));
        List<UserRecordForStatistics> recordForStatisticsList = activityUserRecordRepository.findByActivityIdAndPopTimeGreaterThanEqualAndPopTimeLessThanEqual(activityInfo.getId(), startTime, endTime)
                .stream()
                .map(UserRecordForStatistics::new)
                .collect(Collectors.toList());
        ActivityStatisticsVO statisticsVO = new ActivityStatisticsVO();
        // 按弹窗日期分组，每天的弹窗数据分割成map
        Map<String, List<UserRecordForStatistics>> dayMap = recordForStatisticsList.stream()
                .collect(Collectors.groupingBy(UserRecordForStatistics::getPopDay));
        List<ActivityStatisticsItemVO> itemVOList = new ArrayList<>();
        List<Long> agreeNumber = new ArrayList<>();
        List<Long> disagreeNumber = new ArrayList<>();
        dayMap.forEach((day, list) -> {
            ActivityStatisticsItemVO itemVO = new ActivityStatisticsItemVO();
            itemVO.setDay(day);
            itemVO.setPopNumber(list.size());
            // 按照用户分组，可以比较快速得出每天推送给多少个用户
            Map<String, Map<String, List<UserRecordForStatistics>>> userRecord = list.stream()
                    .collect(Collectors.groupingBy(UserRecordForStatistics::getUser, Collectors.groupingBy(UserRecordForStatistics::getResponse)));
            List<Integer> dayAgreeNumber = new ArrayList<>();
            List<Integer> dayDisagreeNumber = new ArrayList<>();
            itemVO.setUserNumber(userRecord.size());
            userRecord.forEach((user, record) -> {
                if (record.containsKey(ActivityServiceImpl.RESPONSE_AGREE)) {
                    agreeNumber.add(1L);
                    dayAgreeNumber.add(1);
                } else if (record.containsKey(ActivityServiceImpl.RESPONSE_DISAGREE)) {
                    disagreeNumber.add(1L);
                    dayDisagreeNumber.add(1);
                }
            });
            itemVO.setAgreeNumber(dayAgreeNumber.stream().reduce(0, (a, b) -> a + b));
            itemVO.setDisagreeNumber(dayDisagreeNumber.stream().reduce(0, (a, b) -> a + b));
            itemVOList.add(itemVO);
        });
        itemVOList.sort(Comparator.comparing(ActivityStatisticsItemVO::getDay).reversed());
        statisticsVO.setList(itemVOList);
        statisticsVO.setPopNumber(Long.parseLong("" + recordForStatisticsList.size()));
        statisticsVO.setAgreeNumber(agreeNumber.stream().reduce(0L, (a, b) -> a + b));
        statisticsVO.setDisagreeNumber(disagreeNumber.stream().reduce(0L, (a, b) -> a + b));
        statisticsVO.setUserNumber(Long.parseLong(recordForStatisticsList.stream().map(UserRecordForStatistics::getUser).collect(Collectors.toSet()).size() + ""));
        return statisticsVO;
    }
}
