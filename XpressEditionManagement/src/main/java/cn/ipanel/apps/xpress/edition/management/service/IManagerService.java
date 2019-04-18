package cn.ipanel.apps.xpress.edition.management.service;

import cn.ipanel.apps.xpress.edition.management.controller.request.ChangePassReq;
import cn.ipanel.apps.xpress.edition.management.controller.request.ManagerReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.ManagerVO;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午5:36
 * Modified By:
 * Description:
 */
public interface IManagerService {
    void initAdmin();

    ManagerVO queryManager(String username);

    ManagerVO login(String username, String password) throws Exception;

    List<ManagerVO> queryManagers();

    Boolean addManager(ManagerReq managerReq) throws Exception;

    Boolean updateManager(Integer id, ManagerReq managerReq) throws Exception;

    Boolean deleteManager(Integer id);

    Boolean changePass(String username, ChangePassReq req) throws Exception;
}
