package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.UserOrderInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/30 下午4:55
 * Modified By:
 * Description:
 */
@Repository
public interface UserOrderRepository extends CrudRepository<UserOrderInfo, Integer> {

    UserOrderInfo findByRecordId(Long recordId);

    UserOrderInfo findByUserAndActivityId(String user, Integer activityId);

    UserOrderInfo findByUserAndRecordId(String user, Long recordId);
}
