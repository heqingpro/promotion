package cn.ipanel.apps.xpress.edition.management.service.impl;

import cn.ipanel.apps.xpress.edition.management.dao.RoleRepository;
import cn.ipanel.apps.xpress.edition.management.entity.RoleInfo;
import cn.ipanel.apps.xpress.edition.management.global.Globals;
import cn.ipanel.apps.xpress.edition.management.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午6:24
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class RoleServiceImpl implements IRoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void initRoles() {
        Globals.ROLE_LIST.forEach(role -> {
            String[] info = role.split(":");
            Optional<RoleInfo> optionalInfo = roleRepository.findByName(info[0]);
            optionalInfo.ifPresent(roleInfo -> {
                roleInfo.setUrl(info[1]);
                roleRepository.save(roleInfo);
            });
            if (!optionalInfo.isPresent()) {
                RoleInfo roleInfo = new RoleInfo(info[0], info[1]);
                roleRepository.save(roleInfo);
            }
        });
    }

    @Override
    public List<RoleInfo> queryRoles() {
        return (List<RoleInfo>) roleRepository.findAll();
    }

}
