package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.controller.req.ProductReq;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ProductBackVO;
import cn.ipanel.apps.marketing.campaign.service.dao.ProductRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.Type1ActivityRepository;
import cn.ipanel.apps.marketing.campaign.service.entity.ProductInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.Type1ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.Type1ActivityUtil;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.MyCommonException;
import cn.ipanel.apps.marketing.campaign.service.global.RequestParamErrorException;
import cn.ipanel.apps.marketing.campaign.service.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/23 下午3:02
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private Type1ActivityRepository type1ActivityRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, Type1ActivityRepository type1ActivityRepository) {
        this.productRepository = productRepository;
        this.type1ActivityRepository = type1ActivityRepository;
    }

    @Override
    public List<ProductBackVO> queryProduct() {
        return ((List<ProductInfo>) productRepository.findAll()).stream().map(ProductBackVO::new).collect(Collectors.toList());
    }

    @Override
    public Boolean addProduct(ProductReq req) throws Exception {
        Globals.checkParams(req);
        if (null != productRepository.findByProductName(req.getProductName()) || null != productRepository.findByProductCode(req.getProductCode())) {
            throw new RequestParamErrorException("产品名称/编号已存在");
        }
        productRepository.save(new ProductInfo(
                req.getProductName(),
                req.getProductCode()
        ));
        return true;
    }

    @Override
    public Boolean modifyProduct(Integer id, ProductReq req) throws Exception {
        Globals.checkParams(req);
        ProductInfo productInfo = productRepository.findByProductName(req.getProductName());
        if (null != productInfo && !productInfo.getId().equals(id)) {
            throw new RequestParamErrorException("产品名称已存在");
        }
        productInfo = productRepository.findByProductCode(req.getProductCode());
        if (null != productInfo && !productInfo.getId().equals(id)) {
            throw new RequestParamErrorException("产品编号已存在");
        }
        productInfo = productRepository.findById(id).orElseThrow(() -> new RequestParamErrorException("产品不存在"));
        productInfo.setProductCode(req.getProductCode());
        productInfo.setProductName(req.getProductName());
        productRepository.save(productInfo);
        return true;
    }

    @Override
    public Boolean removeProduct(Integer id) throws Exception {
        ProductInfo productInfo = productRepository.findById(id).orElseThrow(() -> new RequestParamErrorException("产品不存在"));
        List<Type1ActivityInfo> list = type1ActivityRepository.findByMustOrderTypeEqualsOrMustNotOrderTypeEquals(Globals.PRODUCT_EN_NAME, Globals.PRODUCT_EN_NAME);
        for (Type1ActivityInfo type1ActivityInfo : list) {
            Type1ActivityUtil.containsGoodsOrProduct(type1ActivityInfo, id, Globals.PRODUCT_NAME);
        }
        productRepository.delete(productInfo);
        return true;
    }
}
