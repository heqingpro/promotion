package cn.ipanel.apps.xpress.edition.management.service.impl;

import cn.ipanel.apps.xpress.edition.management.controller.request.ChangePassReq;
import cn.ipanel.apps.xpress.edition.management.controller.request.ManagerReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.ManagerVO;
import cn.ipanel.apps.xpress.edition.management.dao.ManagerRepository;
import cn.ipanel.apps.xpress.edition.management.dao.RoleRepository;
import cn.ipanel.apps.xpress.edition.management.entity.ManagerInfo;
import cn.ipanel.apps.xpress.edition.management.entity.RoleInfo;
import cn.ipanel.apps.xpress.edition.management.global.Globals;
import cn.ipanel.apps.xpress.edition.management.global.MyCommonException;
import cn.ipanel.apps.xpress.edition.management.global.RequestParamErrorException;
import cn.ipanel.apps.xpress.edition.management.service.IManagerService;
import cn.ipanel.apps.xpress.edition.management.util.MD5Util;
import jdk.nashorn.internal.objects.Global;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午5:37
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class ManagerServiceImpl implements IManagerService {

    private static final String ADMIN_USERNAME = "admin";

    private ManagerRepository managerRepository;
    private RoleRepository roleRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, RoleRepository roleRepository) {
        this.managerRepository = managerRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void initAdmin() {
        List<RoleInfo> roleInfoList = (List<RoleInfo>) roleRepository.findAll();
        ManagerInfo managerInfo = managerRepository.findByUsername(ADMIN_USERNAME);
        if (null == managerInfo) {
            managerInfo = new ManagerInfo(ADMIN_USERNAME, "超级管理员", MD5Util.EncryptionStr32("root"), roleInfoList);
        } else {
            managerInfo.setRoles(roleInfoList);
        }
        managerRepository.save(managerInfo);
    }

    @Override
    public ManagerVO queryManager(String username) {
        ManagerInfo managerInfo = managerRepository.findByUsername(username);
        if (null == managerInfo) {
            return null;
        } else {
            return new ManagerVO(managerInfo);
        }
    }

    @Override
    public ManagerVO login(String username, String password) throws Exception {
        if (Globals.isEmpty(username)) {
            throw new RequestParamErrorException("用户名不能为空");
        }
        if (Globals.isEmpty(password)) {
            throw new RequestParamErrorException("密码不能为空");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.EncryptionStr32(password));
        ManagerInfo managerInfo = managerRepository.findByUsername(token.getUsername());
        if (null == managerInfo) {
            throw new RequestParamErrorException("用户名或密码有误");
        }
        if (!new String(token.getPassword()).equals(managerInfo.getPassword())) {
            throw new RequestParamErrorException("用户名或密码有误");
        }
        SecurityUtils.getSubject().login(token);
        return new ManagerVO(managerInfo);
    }

    @Override
    public List<ManagerVO> queryManagers() {
        return ((List<ManagerInfo>)managerRepository.findAll()).stream().map(ManagerVO::new).collect(Collectors.toList());
    }

    @Override
    public Boolean addManager(ManagerReq managerReq) throws Exception {
        Globals.checkParams(managerReq);
        List<String> roleIdList = Arrays.stream(managerReq.getRoles().split(","))
                .filter(s -> !Globals.isEmpty(s) && !Globals.isBlank(s)).collect(Collectors.toList());
        List<RoleInfo> roles = roleRepository.findByNameIn(roleIdList);
        if (roles.isEmpty()) {
            throw new RequestParamErrorException("管理员权限有误");
        }
        if (null != managerRepository.findByUsername(managerReq.getUsername())) {
            throw new RequestParamErrorException("账号已存在");
        }
        this.managerRepository.save(new ManagerInfo(
                managerReq.getUsername(),
                managerReq.getName(),
                MD5Util.EncryptionStr32(managerReq.getPassword()),
                roles
        ));
        return true;
    }

    @Override
    public Boolean updateManager(Integer id, ManagerReq managerReq) throws Exception {
        managerReq.setPassword("#");
        Globals.checkParams(managerReq);
        List<String> roleIdList = Arrays.stream(managerReq.getRoles().split(","))
                .filter(s -> !Globals.isEmpty(s) && !Globals.isBlank(s)).collect(Collectors.toList());
        List<RoleInfo> roles = roleRepository.findByNameIn(roleIdList);
        if (roles.isEmpty()) {
            throw new RequestParamErrorException("管理员权限有误");
        }
        ManagerInfo managerInfo = managerRepository.findByUsername(managerReq.getUsername());
        if (null != managerInfo && !managerInfo.getId().equals(id)) {
            throw new RequestParamErrorException("账号已存在");
        }
        Optional<ManagerInfo> optionalInfo = managerRepository.findById(id);
        optionalInfo.ifPresent(info -> {
            if (info.getUsername().equals(ADMIN_USERNAME)) {
                managerReq.setUsername(ADMIN_USERNAME);
            }
            info.setId(id);
            info.setUsername(managerReq.getUsername());
            info.setName(managerReq.getName());
            info.setRoles(roles);
            managerRepository.save(info);
        });
        return true;
    }

    @Override
    public Boolean deleteManager(Integer id) {
        Optional<ManagerInfo> optionalInfo = managerRepository.findById(id);
        optionalInfo.ifPresent(info -> {
            if (info.getUsername().equals("admin")) {
                return;
            }
            managerRepository.delete(info);
        });
        return true;
    }

    @Override
    public Boolean changePass(String username, ChangePassReq req) throws Exception {
        Globals.checkParams(req);
        ManagerInfo managerInfo = managerRepository.findByUsername(username);
        if (managerInfo == null) {
            throw new MyCommonException("-1", "系统异常");
        }
        if (!managerInfo.getPassword().equals(MD5Util.EncryptionStr32(req.getOldPass()))) {
            throw new MyCommonException("-1", "原密码错误");
        }
        managerInfo.setPassword(MD5Util.EncryptionStr32(req.getNewPass()));
        managerRepository.save(managerInfo);
        return true;
    }
}
