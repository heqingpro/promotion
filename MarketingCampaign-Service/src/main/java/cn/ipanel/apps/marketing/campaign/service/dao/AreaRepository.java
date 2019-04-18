package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.AreaInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/6 下午3:49
 * Modified By:
 * Description:
 */
@Repository
public interface AreaRepository extends CrudRepository<AreaInfo, Integer> {

    AreaInfo findByAreaName(String areaName);
}
