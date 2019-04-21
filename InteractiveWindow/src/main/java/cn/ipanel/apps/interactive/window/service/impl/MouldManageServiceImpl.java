package cn.ipanel.apps.interactive.window.service.impl;

import cn.ipanel.apps.interactive.window.controller.req.MouldReq;
import cn.ipanel.apps.interactive.window.controller.resp.back.MouldBackVO;
import cn.ipanel.apps.interactive.window.dao.MouldRepository;
import cn.ipanel.apps.interactive.window.dao.UserMessageRepository;
import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.global.MyCommonException;
import cn.ipanel.apps.interactive.window.global.RequestParamErrorException;
import cn.ipanel.apps.interactive.window.service.IMouldManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/8 上午11:14
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class MouldManageServiceImpl implements IMouldManageService {

    private static final String ADJUST_PRIORITY_OPERATION_UP = "up";
    private static final String ADJUST_PRIORITY_OPERATION_DOWN = "down";
    private List<String> ADJUST_PRIORITY_OPERATION = Arrays.asList(ADJUST_PRIORITY_OPERATION_UP, ADJUST_PRIORITY_OPERATION_DOWN);

    private MouldRepository mouldRepository;
    private UserMessageRepository userMessageRepository;

    @Autowired
    public MouldManageServiceImpl(MouldRepository mouldRepository, UserMessageRepository userMessageRepository) {
        this.mouldRepository = mouldRepository;
        this.userMessageRepository = userMessageRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addMould(MouldReq mouldReq) throws Exception {
        Globals.checkParams(mouldReq);
        final MouldReq req = checkReq(mouldReq);
        MouldInfo mouldInfo = mouldRepository.findByName(req.getName());
        if (null != mouldInfo) {
            throw new RequestParamErrorException("模板名称已存在");
        }
        mouldInfo = mouldRepository.findByCode(req.getCode());
        if (null != mouldInfo) {
            throw new RequestParamErrorException("模板编号已存在");
        }
        int max = ((List<MouldInfo>)mouldRepository.findAll())
                .stream()
                .filter(mould -> !mould.getPriorityLevel().equals(0))
                .collect(Collectors.toList())
                .size();
        mouldInfo = new MouldInfo(
                req.getName(),
                req.getContent(),
                req.getTitle(),
                req.getCode(),
                Globals.convertTime(req.getEffectiveDate()),
                Globals.convertTime(req.getExpireDate()),
                ++max,
                req.getButton1Name(),
                req.getButton1Url(),
                req.getButton2Name(),
                req.getButton2Url(),
                req.getButton3Name(),
                req.getButton3Url()
        );
        mouldRepository.save(mouldInfo);
        return true;
    }

    private MouldReq checkReq(MouldReq req) throws Exception {
        Long effectiveDate = Globals.convertTime(req.getEffectiveDate());
        Long expireDate = Globals.convertTime(req.getExpireDate());
        if (effectiveDate >= expireDate) {
            throw new RequestParamErrorException("请选择正确的生效、失效时间");
        }
        if (!Globals.isEmpty(req.getButton1Url()) && Globals.isEmpty(req.getButton1Name())) {
            throw new RequestParamErrorException("按钮1名称不能为空");
        }
        if (!Globals.isEmpty(req.getButton2Url()) && Globals.isEmpty(req.getButton2Name())) {
            throw new RequestParamErrorException("按钮2名称不能为空");
        }
        if (!Globals.isEmpty(req.getButton3Url()) && Globals.isEmpty(req.getButton3Name())) {
            throw new RequestParamErrorException("按钮3名称不能为空");
        }
        if (Globals.isEmpty(req.getButton1Name())) {
            req.setButton1Name("关闭");
        }
        return req;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean modifyMould(Integer id, MouldReq mouldReq) throws Exception {
        Globals.checkParams(mouldReq);
        final MouldReq req = checkReq(mouldReq);
        MouldInfo mouldInfo = mouldRepository.findByName(req.getName());
        if (null != mouldInfo && !id.equals(mouldInfo.getId())) {
            throw new RequestParamErrorException("模板名称已存在");
        }
        mouldInfo = mouldRepository.findByCode(req.getCode());
        if (null != mouldInfo && !id.equals(mouldInfo.getId())) {
            throw new RequestParamErrorException("模板编号已存在");
        }
        mouldInfo = mouldRepository.findById(id).orElseThrow(() -> new RequestParamErrorException("模板不存在"));
        mouldInfo = new MouldInfo(
                req.getName(),
                req.getContent(),
                req.getTitle(),
                req.getCode(),
                Globals.convertTime(req.getEffectiveDate()),
                Globals.convertTime(req.getExpireDate()),
                mouldInfo.getPriorityLevel(),
                req.getButton1Name(),
                req.getButton1Url(),
                req.getButton2Name(),
                req.getButton2Url(),
                req.getButton3Name(),
                req.getButton3Url()
        );
        mouldInfo.setId(id);
        mouldInfo = mouldRepository.save(mouldInfo);
        if (mouldInfo.getExpireDate() < Instant.now().toEpochMilli()) {
            mouldInfo.setPriorityLevel(0);
            mouldRepository.save(mouldInfo);
            rearrangePriorityLevel();
        } else if (mouldInfo.getExpireDate() > Instant.now().toEpochMilli() && mouldInfo.getPriorityLevel().equals(0)) {
            List<MouldInfo> list = ((List<MouldInfo>) mouldRepository.findAll())
                    .stream()
                    .filter(mould -> !mould.getPriorityLevel().equals(0))
                    .collect(Collectors.toList());
            list.forEach(mould -> {
                mould.setPriorityLevel(mould.getPriorityLevel() + 1);
                mouldRepository.save(mould);
            });
            mouldInfo.setPriorityLevel(1);
            mouldRepository.save(mouldInfo);
        }
        return true;
    }

    @Override
    public Boolean removeMould(Integer id) throws Exception {
        MouldInfo mouldInfo = mouldRepository.findById(id).orElseThrow(() -> new RequestParamErrorException("模板不存在"));
        if (!userMessageRepository.findByMouldIdAndHasResponse(id, false).isEmpty()) {
            throw new MyCommonException("-1", "用户还有未读的消息，无法删除模板");
        }
        mouldRepository.delete(mouldInfo);
        return true;
    }

    @Override
    public List<MouldBackVO> queryMould() {
        return ((List<MouldInfo>) mouldRepository.findAll()).stream().map(MouldBackVO::new).sorted(Comparator.comparing(MouldBackVO::getId).reversed()).collect(Collectors.toList());
    }

    @Override
    public MouldBackVO queryMould(Integer id) throws Exception {
        MouldInfo mouldInfo = mouldRepository.findById(id).orElseThrow(() -> new RequestParamErrorException("模板不存在"));
        return new MouldBackVO(mouldInfo);
    }

    @Override
    public Boolean adjustPriority(Integer mouldId, String operation) throws Exception {
        if (!ADJUST_PRIORITY_OPERATION.contains(operation)) {
            throw new RequestParamErrorException("错误的操作");
        }
        MouldInfo mouldInfo = mouldRepository.findById(mouldId).orElseThrow(() -> new RequestParamErrorException("模板无效"));
        List<MouldInfo> mouldInfoList = (List<MouldInfo>) mouldRepository.findAll();
        if (ADJUST_PRIORITY_OPERATION_UP.equals(operation)) {
            mouldInfoList = mouldInfoList.stream()
                    .filter(info -> info.getPriorityLevel() > mouldInfo.getPriorityLevel())
                    .sorted(Comparator.comparing(MouldInfo::getPriorityLevel))
                    .collect(Collectors.toList());
        } else if (ADJUST_PRIORITY_OPERATION_DOWN.equals(operation)) {
            mouldInfoList = mouldInfoList.stream()
                    .filter(info -> info.getPriorityLevel() < mouldInfo.getPriorityLevel())
                    .sorted(Comparator.comparing(MouldInfo::getPriorityLevel).reversed())
                    .collect(Collectors.toList());
        }
        if (mouldInfoList.isEmpty()) {
            return true;
        }
        MouldInfo targetMouldInfo = mouldInfoList.get(0);
        targetMouldInfo.setPriorityLevel(targetMouldInfo.getPriorityLevel() + mouldInfo.getPriorityLevel());
        mouldInfo.setPriorityLevel(targetMouldInfo.getPriorityLevel() - mouldInfo.getPriorityLevel());
        targetMouldInfo.setPriorityLevel(targetMouldInfo.getPriorityLevel() - mouldInfo.getPriorityLevel());
        mouldRepository.save(targetMouldInfo);
        mouldRepository.save(mouldInfo);
        return true;
    }

    @Override
    public List<MouldBackVO> queryMouldByPriorityLevel() {
        List<MouldInfo> list = (List<MouldInfo>) mouldRepository.findAll();
        return list.stream().filter(mouldInfo -> !mouldInfo.getPriorityLevel().equals(0)).map(MouldBackVO::new).sorted(Comparator.comparing(MouldBackVO::getPriorityLevel).reversed()).collect(Collectors.toList());
    }

    @Override
    public void rearrangePriorityLevel() {
        List<MouldInfo> mouldInfoList = ((List<MouldInfo>) mouldRepository.findAll())
                .stream()
                .filter(mouldInfo -> !mouldInfo.getPriorityLevel().equals(0))
                .sorted(Comparator.comparing(MouldInfo::getPriorityLevel).reversed())
                .collect(Collectors.toList());
        if (mouldInfoList.isEmpty()) {
            return;
        }
        Integer maxPriorityLevel = mouldInfoList.get(0).getPriorityLevel();
        if (maxPriorityLevel.equals(mouldInfoList.size())) {
            return;
        }
        Map<Integer, MouldInfo> mouldInfoMap = mouldInfoList.stream().collect(Collectors.toMap(MouldInfo::getPriorityLevel, MouldInfo::getSelf));
        List<Integer> missingNumber = new ArrayList<>();
        for (int i = 1; i <= maxPriorityLevel; i++) {
            if (!mouldInfoMap.containsKey(i)) {
                missingNumber.add(i);
            }
        }
        missingNumber.sort(Comparator.comparing(Integer::intValue).reversed());
        for (Integer i : missingNumber) {
            mouldInfoMap.forEach((priorityLevel, mouldInfo) -> {
                if (priorityLevel > i) {
                    mouldInfo.setPriorityLevel(mouldInfo.getPriorityLevel() - 1);
                    mouldInfo = mouldRepository.save(mouldInfo);
                    mouldInfoMap.put(priorityLevel, mouldInfo);
                }
            });
        }
    }
}

