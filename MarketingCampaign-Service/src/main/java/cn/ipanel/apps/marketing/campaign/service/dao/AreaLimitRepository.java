package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.AreaLimit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/21 下午2:59
 * Modified By:
 * Description:
 */
@Repository
public interface AreaLimitRepository extends CrudRepository<AreaLimit, Integer> {

    AreaLimit findByAreaIdAndActivityId(Integer areaId, Integer activityId);
}
