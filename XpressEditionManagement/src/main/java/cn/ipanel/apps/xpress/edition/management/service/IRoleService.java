package cn.ipanel.apps.xpress.edition.management.service;


import cn.ipanel.apps.xpress.edition.management.entity.RoleInfo;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午6:23
 * Modified By:
 * Description:
 */
public interface IRoleService {
    void initRoles();

    List<RoleInfo> queryRoles();
}
