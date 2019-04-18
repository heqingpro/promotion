package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.controller.req.GoodsReq;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.GoodsBackVO;
import cn.ipanel.apps.marketing.campaign.service.dao.ActivityRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.GoodsRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.Type1ActivityRepository;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.GoodsInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.Type1ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.Type1ActivityUtil;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.RequestParamErrorException;
import cn.ipanel.apps.marketing.campaign.service.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午3:05
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class GoodsServiceImpl implements IGoodsService {

    private GoodsRepository goodsRepository;
    private ActivityRepository activityRepository;
    private Type1ActivityRepository type1ActivityRepository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository, ActivityRepository activityRepository,
                            Type1ActivityRepository type1ActivityRepository) {
        this.goodsRepository = goodsRepository;
        this.activityRepository = activityRepository;
        this.type1ActivityRepository = type1ActivityRepository;
    }

    @Override
    public Boolean addGoods(GoodsReq req) throws Exception {
        Globals.checkParams(req);
        if (null != goodsRepository.findByGoodsCode(req.getGoodsCode()) || null != goodsRepository.findByGoodsName(req.getGoodsName())) {
            throw new RequestParamErrorException("编号/名称已存在");
        }
        goodsRepository.save(new GoodsInfo(
                req.getGoodsName(),
                req.getGoodsCode()
        ));
        return true;
    }

    @Override
    public Boolean modifyGoods(Integer id, GoodsReq req) throws Exception {
        Globals.checkParams(req);
        GoodsInfo goodsInfo = goodsRepository.findByGoodsCode(req.getGoodsCode());
        if (null != goodsInfo && !id.equals(goodsInfo.getId())) {
            throw new RequestParamErrorException("编号已存在");
        }
        goodsInfo = goodsRepository.findByGoodsName(req.getGoodsName());
        if (null != goodsInfo && !id.equals(goodsInfo.getId())) {
            throw new RequestParamErrorException("名称已存在");
        }
        goodsInfo = goodsRepository.findById(id).orElseThrow(() -> new RequestParamErrorException("商品不存在"));
        goodsInfo.setGoodsCode(req.getGoodsCode());
        goodsInfo.setGoodsName(req.getGoodsName());
        goodsRepository.save(goodsInfo);
        return true;
    }

    @Override
    public Boolean removeGoods(Integer id) throws Exception {
        GoodsInfo goodsInfo = goodsRepository.findById(id).orElseThrow(() -> new RequestParamErrorException("商品不存在"));
        List<ActivityInfo> activityInfoList = activityRepository.findByGoodsId(goodsInfo.getId());
        if (!activityInfoList.isEmpty()) {
            throw new RequestParamErrorException("商品已关联活动，无法删除");
        }
        List<Type1ActivityInfo> list = type1ActivityRepository.findByMustOrderTypeEqualsOrMustNotOrderTypeEquals(Globals.GOODS_EN_NAME, Globals.GOODS_EN_NAME);
        for (Type1ActivityInfo type1ActivityInfo : list) {
            Type1ActivityUtil.containsGoodsOrProduct(type1ActivityInfo, id, Globals.GOODS_NAME);
        }
        goodsRepository.delete(goodsInfo);
        return true;
    }

    @Override
    public List<GoodsBackVO> queryGoods() {
        return ((List<GoodsInfo>) goodsRepository.findAll()).stream().map(GoodsBackVO::new).collect(Collectors.toList());
    }
}
