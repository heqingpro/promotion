package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.UserFilterInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 上午10:27
 * Modified By:
 * Description:
 */
@Repository
public interface UserFilterRepository extends CrudRepository<UserFilterInfo, Integer> {

    UserFilterInfo findByUser(String user);
}
