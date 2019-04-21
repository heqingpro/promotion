package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.dao.AreaRepository;
import cn.ipanel.apps.marketing.campaign.service.entity.AreaInfo;
import cn.ipanel.apps.marketing.campaign.service.service.IAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/7/4 下午3:00
 * Modified By:
 * Description:
 */
@Slf4j
@Service
public class AreaServiceImpl implements IAreaService {

    private AreaRepository areaRepository;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public List<AreaInfo> queryAll() {
        return (List<AreaInfo>) areaRepository.findAll();
    }
}
