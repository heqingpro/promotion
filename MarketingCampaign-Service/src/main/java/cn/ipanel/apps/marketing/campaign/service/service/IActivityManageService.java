package cn.ipanel.apps.marketing.campaign.service.service;

import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.Type1Req;
import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.Type2Req;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.Type1ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.Type2ActivityBackVO;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午3:17
 * Modified By:
 * Description:
 */
public interface IActivityManageService {

    /**
     * 查询所有活动
     * @return list
     */
    List<ActivityBackVO> queryActivity();

    Type1ActivityBackVO queryType1Activity(Integer id) throws Exception;

    /**
     * 添加类型1
     * @param req 类型1信息
     * @return 结果
     * @throws Exception e
     */
    Boolean addType1Activity(Type1Req req) throws Exception;

    /**
     * 修改类型1
     * @param id id
     * @param req 类型1信息
     * @return 结果
     * @throws Exception e
     */
    Boolean modifyType1Activity(Integer id, Type1Req req) throws Exception;

    /**
     * 删除类型1
     * @param id id
     * @return 结果
     * @throws Exception e
     */
    Boolean removeType1Activity(Integer id) throws Exception;

    Type2ActivityBackVO queryType2Activity(Integer id) throws Exception;

    /**
     * 添加类型2
     * @param req 类型2信息
     * @return 结果
     * @throws Exception e
     */
    Boolean addType2Activity(Type2Req req) throws Exception;

    /**
     * 修改类型2
     * @param id id
     * @param req 类型2信息
     * @return 结果
     * @throws Exception e
     */
    Boolean modifyType2Activity(Integer id, Type2Req req) throws Exception;

    /**
     * 删除类型2
     * @param id id
     * @return 结果
     * @throws Exception e
     */
    Boolean removeType2Activity(Integer id) throws Exception;

    /**
     * 活动上线
     * @param id id
     * @return 结果
     * @throws Exception e
     */
    Boolean online(Integer id) throws Exception;

    /**
     * 活动下线
     * @param id id
     * @return 结果
     * @throws Exception e
     */
    Boolean offline(Integer id) throws Exception;

    /**
     * 调整活动的优先级
     * @param activityId 活动id
     * @param operation 操作
     * @return result
     * @throws Exception e
     */
    Boolean adjustPriority(Integer activityId, String operation) throws Exception;

    List<ActivityBackVO> queryOnline();
}
