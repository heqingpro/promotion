package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.ProductInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/23 下午3:01
 * Modified By:
 * Description:
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductInfo, Integer> {

    ProductInfo findByProductName(String productName);

    ProductInfo findByProductCode(String productCode);
}
