package cn.ipanel.apps.marketing.campaign.service.service;

import cn.ipanel.apps.marketing.campaign.service.controller.req.GoodsReq;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.GoodsBackVO;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午3:05
 * Modified By:
 * Description:
 */
public interface IGoodsService {

    /**
     * 添加商品
     * @param req 商品信息
     * @return 结果
     * @throws Exception e
     */
    Boolean addGoods(GoodsReq req) throws Exception;

    /**
     * 修改商品
     * @param id id
     * @param req 商品信息
     * @return 结果
     * @throws Exception e
     */
    Boolean modifyGoods(Integer id, GoodsReq req) throws Exception;

    /**
     * 删除商品
     * @param id id
     * @return 结果
     * @throws Exception e
     */
    Boolean removeGoods(Integer id) throws Exception;

    List<GoodsBackVO> queryGoods();
}
