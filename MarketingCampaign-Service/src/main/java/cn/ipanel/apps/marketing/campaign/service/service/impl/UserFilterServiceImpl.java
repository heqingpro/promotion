package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.UserFilterVO;
import cn.ipanel.apps.marketing.campaign.service.dao.UserFilterRepository;
import cn.ipanel.apps.marketing.campaign.service.dto.CustomerVO;
import cn.ipanel.apps.marketing.campaign.service.entity.UserFilterInfo;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.RequestParamErrorException;
import cn.ipanel.apps.marketing.campaign.service.service.IUserFilterService;
import cn.ipanel.apps.marketing.campaign.service.service.feign.IBossService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 上午10:29
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class UserFilterServiceImpl implements IUserFilterService {

    private UserFilterRepository userFilterRepository;
    private IBossService bossService;

    @Autowired
    public UserFilterServiceImpl(UserFilterRepository userFilterRepository, IBossService bossService) {
        this.userFilterRepository = userFilterRepository;
        this.bossService = bossService;
    }

    @Override
    public Boolean addUser(String user) throws Exception {
        Globals.checkRequestParam(user, true, null, null, null, "用户CA卡");
        CustomerVO customerInfo = bossService.getCustomerInfo(user).getData();
        if (null == customerInfo) {
            throw new RequestParamErrorException("ca卡无效");
        }
        UserFilterInfo userFilterInfo = userFilterRepository.findByUser(user);
        if (null != userFilterInfo) {
            return true;
        }
        UserFilterInfo info = new UserFilterInfo(user);
        userFilterRepository.save(info);
        return true;
    }

    @Override
    public Boolean modifyUser(Integer id, String user) throws Exception {
        Globals.checkRequestParam(user, true, null, null, null, "用户CA卡");
        CustomerVO customerInfo = bossService.getCustomerInfo(user).getData();
        if (null == customerInfo) {
            throw new RequestParamErrorException("ca卡无效");
        }
        UserFilterInfo userFilterInfo = userFilterRepository.findByUser(user);
        if (null != userFilterInfo && !userFilterInfo.getId().equals(id)) {
            return true;
        }
        Optional<UserFilterInfo> optionalUserFilterInfo = userFilterRepository.findById(id);
        optionalUserFilterInfo.ifPresent(info -> {
            info.setId(id);
            info.setUser(user);
            userFilterRepository.save(info);
        });
        return true;
    }

    @Override
    public Boolean removeUser(Integer id) {
        Optional<UserFilterInfo> optionalUserFilterInfo = userFilterRepository.findById(id);
        optionalUserFilterInfo.ifPresent(info -> userFilterRepository.delete(info));
        return true;
    }

    @Override
    public List<UserFilterVO> queryFilterList() {
        return ((List<UserFilterInfo>) userFilterRepository.findAll()).stream().map(UserFilterVO::new).collect(Collectors.toList());
    }
}
