package cn.ipanel.apps.interactive.window.task;

import cn.ipanel.apps.interactive.window.dao.MouldRepository;
import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import cn.ipanel.apps.interactive.window.service.IMouldManageService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/31 4:00 PM
 * Modified By:
 * Description:
 */
@Component
public class SchedulingTask {

    private MouldRepository mouldRepository;
    private IMouldManageService mouldManageService;

    @Autowired
    public SchedulingTask(MouldRepository mouldRepository, IMouldManageService mouldManageService) {
        this.mouldRepository = mouldRepository;
        this.mouldManageService = mouldManageService;
    }

    @Scheduled(cron = "30 0 * * * *")
    public void updatePriorityLevel() {
        Long nowTime = Instant.now().toEpochMilli();
        List<MouldInfo> mouldInfoList = (List<MouldInfo>) mouldRepository.findAll();
        mouldInfoList.stream().filter(mouldInfo -> nowTime > mouldInfo.getExpireDate() && !mouldInfo.getPriorityLevel().equals(0)).forEach(mouldInfo -> {
            mouldInfo.setPriorityLevel(0);
            mouldRepository.save(mouldInfo);
        });
        mouldManageService.rearrangePriorityLevel();
    }
}
