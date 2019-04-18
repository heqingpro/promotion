package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.Type1ActivityInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午5:22
 * Modified By:
 * Description:
 */
@Repository
public interface Type1ActivityRepository extends CrudRepository<Type1ActivityInfo, Integer> {

    List<Type1ActivityInfo> findByActivityId(Integer activityId);

    List<Type1ActivityInfo> findByMustOrderTypeEqualsOrMustNotOrderTypeEquals(String mustOrderType, String mustNotOrderType);
}
