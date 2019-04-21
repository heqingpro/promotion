package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.Type2ActivityInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午5:24
 * Modified By:
 * Description:
 */
@Repository
public interface Type2ActivityRepository extends CrudRepository<Type2ActivityInfo, Integer> {

    List<Type2ActivityInfo> findByActivityId(Integer activityId);
}
