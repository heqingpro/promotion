package cn.ipanel.apps.interactive.window.service.impl;

import cn.ipanel.apps.interactive.window.dao.MouldRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRepository;
import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import cn.ipanel.apps.interactive.window.entity.UserMessageInfo;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.global.MyCommonException;
import cn.ipanel.apps.interactive.window.global.RequestParamErrorException;
import cn.ipanel.apps.interactive.window.service.IMessageManageService;
import cn.ipanel.apps.interactive.window.service.bean.ExcelData;
import cn.ipanel.apps.interactive.window.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/10 下午2:45
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class MessageManageServiceImpl implements IMessageManageService {

    private final MouldRepository mouldRepository;
    private final UserMessageRepository userMessageRepository;

    // 互动套餐类型
    private static final String REPLACE_REP_TYPE = "rep-type";
    // 互动套餐名
    private static final String REPLACE_REP_OFFER = "rep-offer";
    // 开始日期
    private static final String REPLACE_REP_ST = "rep-st";
    // 结束日期
    private static final String REPLACE_REP_END = "rep-end";
    // 结束日期当前月第一天
    private static final String REPLACE_REP_MON_BEGINE = "rep-mon-begin";
    // 结束日期当前月最后一天
    private static final String REPLACE_REP_MON_END = "rep-mon-end";

    private static final DateTimeFormatter base_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter formatter_zh = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    @Autowired
    public MessageManageServiceImpl(MouldRepository mouldRepository, UserMessageRepository userMessageRepository) {
        this.mouldRepository = mouldRepository;
        this.userMessageRepository = userMessageRepository;
    }

    @Override
    public String uploadFile(Integer mouldId, MultipartFile file) throws Exception {
        if (null == file) {
            throw new RequestParamErrorException("文件不能为空");
        }
        List<List<String>> rowList;
        try {
            //获取excel中内容列表
            ExcelUtil eu = new ExcelUtil(file);
            rowList = eu.getData(0);

            if (rowList.size() <= 1) {
                throw new RequestParamErrorException("导入文件格式错误");
            }

            if (rowList.get(0).size() < 2) {
                throw new RequestParamErrorException("导入文件格式错误");
            }
        } catch (Exception e) {
            throw new RequestParamErrorException("导入文件错误，错误原因：" + e.getMessage());
        }
        log.info("by luzh: 总共有{}条数据.", rowList.size());
        MouldInfo mouldInfo = mouldRepository.findById(mouldId).orElseThrow(() -> new RequestParamErrorException("模板不存在"));
        List<ExcelData> dataList;
        List<CompletableFuture<ExcelData>> completableFutureList = new ArrayList<>();
        for (int i = 1; i < rowList.size(); i++) {
            final int number = i;
            completableFutureList.add(CompletableFuture.supplyAsync(() -> checkRowDataFuture(mouldInfo, rowList.get(number), number)));
        }
        dataList = completableFutureList.parallelStream().map(CompletableFuture::join).collect(Collectors.toList());
        List<String> errorList = dataList.parallelStream().filter(data -> !data.getSuccess()).map(ExcelData::getErrorMessage).collect(Collectors.toList());
        dataList = dataList.parallelStream().filter(ExcelData::getSuccess).collect(Collectors.toList());
        log.info("by luzh: 校验通过{}条数据", dataList.size());
        if (!dataList.isEmpty()) {
            // 添加到用户数据中
            Long createTime = Instant.now().toEpochMilli();
            for (ExcelData excelData : dataList) {
                UserMessageInfo message = convertMessage(excelData, mouldInfo, createTime);
                userMessageRepository.save(message);
            }
            errorList.add("成功添加了" + dataList.size() + "条数据");
        }
        return String.join("；", errorList);
    }

    private ExcelData checkRowDataFuture(MouldInfo mouldInfo, List<String> row, Integer rowNumber) {
        ExcelData excelData;
        try {
            excelData = checkRowData(mouldInfo, row, rowNumber);
            excelData.setSuccess(true);
        } catch (Exception e) {
            excelData = new ExcelData();
            excelData.setSuccess(false);
            excelData.setErrorMessage(e.getMessage());
        }
        return excelData;
    }

    private ExcelData checkRowData(MouldInfo mouldInfo, List<String> row, Integer rowNumber) throws Exception {
        StringBuilder sb = new StringBuilder();
        ExcelData data = new ExcelData();
        String user = row.get(1);
        if (Globals.isEmpty(user)) {
            sb.append("【认证标识】不能为空、");
        } else {
            data.setUser(user);
        }
        String area = row.get(2);
        if (Globals.isEmpty(area)) {
            sb.append("【地区代码】不能为空、");
        } else {
            data.setArea(area);
        }
        String hdComboType = row.get(3);
        if (mouldInfo.getContent().contains(REPLACE_REP_TYPE)) {
            if (Globals.isEmpty(hdComboType)) {
                sb.append("【互动套餐类型】不能为空、");
            } else {
                data.setHdComboType(hdComboType);
            }
        }
        String comboName = row.get(4);
        if (mouldInfo.getContent().contains(REPLACE_REP_OFFER)) {
            if (Globals.isEmpty(comboName)) {
                sb.append("【套餐名】不能为空、");
            } else {
                data.setComboName(comboName);
            }
        }
        String startDate = row.get(5);
        if (mouldInfo.getContent().contains(REPLACE_REP_ST)) {
            if (Globals.isEmpty(startDate) || !checkDateFormat(startDate)) {
                sb.append("【开始时间】不能为空/格式不正确、");
            } else {
                data.setStartDate(LocalDate.parse(startDate, base_formatter));
            }
        }
        String endDate = row.get(6);
        if (mouldInfo.getContent().contains(REPLACE_REP_END)
                || mouldInfo.getContent().contains(REPLACE_REP_MON_BEGINE)
                || mouldInfo.getContent().contains(REPLACE_REP_MON_END)) {
            if (Globals.isEmpty(endDate) || !checkDateFormat(endDate)) {
                sb.append("【开始时间】不能为空/格式不正确、");
            } else {
                data.setEndDate(LocalDate.parse(endDate, base_formatter));
                if (mouldInfo.getContent().contains(REPLACE_REP_MON_BEGINE)) {
                    data.setEndDateMonthBegin(LocalDate.of(
                            data.getEndDate().getYear(),
                            data.getEndDate().getMonthValue(),
                            1
                    ));
                }
                if (mouldInfo.getContent().contains(REPLACE_REP_MON_END)) {
                    data.setEndDateMonthEnd(LocalDate.of(
                            data.getEndDate().getYear(),
                            data.getEndDate().getMonthValue(),
                            data.getEndDate().lengthOfMonth()
                    ));
                }
            }
        }
        if (sb.toString().equals("")) {
            return data;
        }
        throw new MyCommonException("-1", "第【" + (rowNumber + 1) + "】行数据" + sb.toString().substring(0, sb.toString().length() - 1));
    }

    private UserMessageInfo convertMessage(ExcelData excelData, MouldInfo mouldInfo, Long createTime) {
        String content = mouldInfo.getContent();
        if (content.contains(REPLACE_REP_TYPE)) {
            content = content.replaceAll(REPLACE_REP_TYPE, excelData.getHdComboType());
        }
        if (content.contains(REPLACE_REP_OFFER)) {
            content = content.replaceAll(REPLACE_REP_OFFER, excelData.getComboName());
        }
        if (content.contains(REPLACE_REP_ST)) {
            content = content.replaceAll(REPLACE_REP_ST, formatter_zh.format(excelData.getStartDate()));
        }
        if (content.contains(REPLACE_REP_END)) {
            content = content.replaceAll(REPLACE_REP_END, formatter_zh.format(excelData.getEndDate()));
        }
        if (content.contains(REPLACE_REP_MON_BEGINE)) {
            content = content.replaceAll(REPLACE_REP_MON_BEGINE, formatter_zh.format(excelData.getEndDateMonthBegin()));
        }

        if (content.contains(REPLACE_REP_MON_END)) {
            content = content.replaceAll(REPLACE_REP_MON_END, formatter_zh.format(excelData.getEndDateMonthEnd()));
        }
        return new UserMessageInfo(excelData.getUser(), excelData.getArea(), content, mouldInfo.getId(), mouldInfo.getName(), createTime);
    }

    private Boolean checkDateFormat(String date) {
        try {
            LocalDate.parse(date, base_formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
