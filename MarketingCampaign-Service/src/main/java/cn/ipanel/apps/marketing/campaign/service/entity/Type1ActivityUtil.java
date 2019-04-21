package cn.ipanel.apps.marketing.campaign.service.entity;

import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.Type1Req;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.MyCommonException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/13 上午10:25
 * Modified By:
 * Description:
 */
public class Type1ActivityUtil {

    private static final String ACTIVITY_DATABASE_IDS_SEPARATOR = "]-[";
    private static final String ACTIVITY_DATABASE_IDS_SEPARATOR_S = "-";

    public static String convertMustOrderInfo(Type1Req req) {
        String mustOrderInfo = req.getMustOrderType().equals(Globals.GOODS_EN_NAME)
                ? req.getMustOrderInfo().stream().filter(info -> !info.equals(req.getGoodsId().toString())).collect(Collectors.joining(ACTIVITY_DATABASE_IDS_SEPARATOR))
                : String.join(ACTIVITY_DATABASE_IDS_SEPARATOR, req.getMustOrderInfo());
        return Globals.isEmpty(mustOrderInfo) ? "" : "[" +  mustOrderInfo + "]";
    }

    public static String convertMustNotOrderInfo(Type1Req req) {
        String mustNotOrderInfo = String.join(ACTIVITY_DATABASE_IDS_SEPARATOR, req.getMustNotOrderInfo());
        return Globals.isEmpty(mustNotOrderInfo) ? "" : "[" + mustNotOrderInfo + "]";
    }

    public static List<String> convertMustOrderInfo(Type1ActivityInfo type1ActivityInfo) {
        String[] mustOrder = !Globals.isEmpty(type1ActivityInfo.getMustOrderedInfo())
                ? type1ActivityInfo.getMustOrderedInfo().replaceAll("\\[", "").replaceAll("]", "").split(ACTIVITY_DATABASE_IDS_SEPARATOR_S)
                : new String[0];
        return Arrays.asList(mustOrder);
    }

    public static List<String> convertMustNotOrderInfo(Type1ActivityInfo type1ActivityInfo) {
        String[] mustNotOrder = !Globals.isEmpty(type1ActivityInfo.getMustNotOrderedInfo())
                ? type1ActivityInfo.getMustNotOrderedInfo().replaceAll("\\[", "").replaceAll("]", "").split(ACTIVITY_DATABASE_IDS_SEPARATOR_S)
                : new String[0];
        return Arrays.asList(mustNotOrder);
    }

    /**
     * 判断商品id或产品id是否与活动关联
     * @param type1ActivityInfo 活动信息
     * @param id 商品id 产品id
     */
    public static void containsGoodsOrProduct(Type1ActivityInfo type1ActivityInfo, Integer id, String name) throws Exception {
        List<String> mustOrder = Type1ActivityUtil.convertMustOrderInfo(type1ActivityInfo);
        if (mustOrder.contains(id.toString())) {
            throw new MyCommonException("-1",  name +"已与活动关联，请解除关联后再进行操作");
        }
        List<String> mustNotOrder = Type1ActivityUtil.convertMustNotOrderInfo(type1ActivityInfo);
        if (mustNotOrder.contains(id.toString())) {
            throw new MyCommonException("-1", name + "已与活动关联，请解除关联后再进行操作");
        }
    }
}
