package cn.ipanel.apps.marketing.campaign.service.service;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.UserFilterVO;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 上午10:28
 * Modified By:
 * Description:
 */
public interface IUserFilterService {
    Boolean addUser(String user) throws Exception;

    Boolean modifyUser(Integer id, String user) throws Exception;

    Boolean removeUser(Integer id);

    List<UserFilterVO> queryFilterList();
}
