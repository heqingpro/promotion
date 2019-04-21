package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.ipanel.apps.marketing.campaign.service.dao.ActivityRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.ActivityUserRecordRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.UserOrderRepository;
import cn.ipanel.apps.marketing.campaign.service.dto.CustomerVO;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityUserRecordInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.UserOrderInfo;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.RequestParamErrorException;
import cn.ipanel.apps.marketing.campaign.service.service.ITransferDataService;
import cn.ipanel.apps.marketing.campaign.service.service.feign.IBossService;
import cn.ipanel.apps.marketing.campaign.service.util.DateUtil;
import cn.ipanel.apps.marketing.campaign.service.util.SnowflakeIdWorker;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/11/13 3:24 PM
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class TransferDataServiceImpl implements ITransferDataService {

    private static final Gson gson = new Gson();
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-M月-yyhh.mm.ss.SSSSSSa");

    private final ActivityRepository activityRepository;
    private final IBossService bossService;
    private final SnowflakeIdWorker snowflakeIdWorker;
    private final ActivityUserRecordRepository activityUserRecordRepository;
    private final UserOrderRepository userOrderRepository;

    @Autowired
    public TransferDataServiceImpl(ActivityRepository activityRepository, IBossService bossService,
                                   ActivityUserRecordRepository activityUserRecordRepository,
                                   UserOrderRepository userOrderRepository) {
        this.activityRepository = activityRepository;
        this.bossService = bossService;
        this.snowflakeIdWorker = SnowflakeIdWorker.getInstance(1L, 1L);
        this.activityUserRecordRepository = activityUserRecordRepository;
        this.userOrderRepository = userOrderRepository;
    }

    @Override
    public Boolean uploadFile(Integer activityId, MultipartFile file) throws Exception {
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动不存在"));
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Map<String,Object>> readAll = reader.readAll();
        List<String> notInfoStbList = new ArrayList<>();
        List<String> errorList =  new ArrayList<>();
        readAll.forEach(map -> {
            String stb = map.get("STBID").toString();
            CustomerVO vo;
            try {
                vo = bossService.getCustomerInfo(stb).getData();
            } catch (Exception e) {
                log.error("query stb {} error {}", stb, e.getMessage());
                vo = null;
                notInfoStbList.add(stb);
            }
            if (null == vo) {
                log.info("stb {} 找不到用户信息", stb);
                return;
            }
            try {
                LocalDateTime showTime = LocalDateTime.parse(map.get("SHOW_TIME").toString().replaceAll(" ", ""), dateTimeFormatter);
                ActivityUserRecordInfo recordInfo = new ActivityUserRecordInfo(
                        snowflakeIdWorker.nextId() + "",
                        activityId,
                        activityInfo.getActivityType(),
                        activityInfo.getActivityCategory(),
                        vo.getStbCode(),
                        vo.getCompanyName(),
                        showTime.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli(),
                        Globals.COMMON_DATE_FORMATTER.format(showTime)
                );
                LocalDateTime orderTime = LocalDateTime.parse(map.get("ORDER_TIME").toString().replaceAll(" ", ""), dateTimeFormatter);
                recordInfo.setResponse(ActivityServiceImpl.RESPONSE_AGREE);
                recordInfo.setResponseTime(orderTime.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli());
                recordInfo.setResponseDay(Globals.COMMON_DATE_FORMATTER.format(orderTime));
                recordInfo.setResponseResult("");
                recordInfo.setHasResponse(true);
                recordInfo = activityUserRecordRepository.save(recordInfo);
                UserOrderInfo orderInfo = new UserOrderInfo(
                        vo.getStbCode(),
                        map.get("OFFERID").toString(),
                        Globals.COMMON_DATE_FORMATTER.format(orderTime),
                        Globals.COMMON_DATE_FORMATTER.format(DateUtil.getYesterdayOfAFewMonthsLater(orderTime.toLocalDate(), 2)),
                        recordInfo.getId(),
                        activityId
                );
                userOrderRepository.save(orderInfo);
                log.info("add record: {}", stb);
            } catch (Exception e) {
                log.error("错误了: {}, {}", gson.toJson(map), e.getMessage(), e);
                errorList.add(gson.toJson(map) + " error " + e.getMessage());
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("sleep error");
            }
        });
        log.info("error info: {}", gson.toJson(errorList));
        log.info("not info stb: {}", gson.toJson(notInfoStbList));
        return true;
    }
}
