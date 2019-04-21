package cn.ipanel.apps.marketing.campaign.service.task;

import cn.ipanel.apps.marketing.campaign.service.dao.ActivityUserRecordRepository;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityUserRecordInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 上午10:16
 * Modified By:
 * Description:
 */
@Component
public class AsyncTask {

    private ActivityUserRecordRepository activityUserRecordRepository;

    @Autowired
    public AsyncTask(ActivityUserRecordRepository activityUserRecordRepository) {
        this.activityUserRecordRepository = activityUserRecordRepository;
    }

    @Async("myAsync")
    public void addActivityUserRecord(String serialNumber, String userId, String userArea, ActivityInfo activityInfo, Long popTime, String popDay) {
        activityUserRecordRepository.save(new ActivityUserRecordInfo(
                serialNumber,
                activityInfo.getId(),
                activityInfo.getActivityType(),
                activityInfo.getActivityCategory(),
                userId,
                userArea,
                popTime,
                popDay
        ));
    }
}
