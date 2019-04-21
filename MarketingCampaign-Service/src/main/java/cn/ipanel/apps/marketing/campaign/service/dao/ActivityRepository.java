package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午4:56
 * Modified By:
 * Description:
 */
@Repository
public interface ActivityRepository extends CrudRepository<ActivityInfo, Integer> {

    /**
     * 查找有效期内上线的活动
     * @param effectiveDate 生效时间
     * @param expireDate 失效时间
     * @param publish 是否上线
     * @return list
     */
    List<ActivityInfo> findByEffectiveDateLessThanAndExpireDateGreaterThanAndPublish(Long effectiveDate, Long expireDate, Boolean publish);

    /**
     * 查找同类型上线的活动
     * @param activityType 类型
     * @param publish 是否上线
     * @return list
     */
    List<ActivityInfo> findByActivityTypeAndPublish(String activityType, Boolean publish);

    ActivityInfo findByName(String name);

    ActivityInfo findByCode(String code);

    List<ActivityInfo> findByGoodsId(Integer goodsId);

    List<ActivityInfo> findByPublish(Boolean publish);
}
