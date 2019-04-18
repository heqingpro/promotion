package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.GoodsInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午2:31
 * Modified By:
 * Description:
 */
@Repository
public interface GoodsRepository extends CrudRepository<GoodsInfo, Integer> {

    /**
     * 根据商品编号查询
     * @param goodsCode 编号
     * @return 商品
     */
    GoodsInfo findByGoodsCode(String goodsCode);

    /**
     * 根据商品名称查询
     * @param goodsName 名称
     * @return 商品
     */
    GoodsInfo findByGoodsName(String goodsName);
}
