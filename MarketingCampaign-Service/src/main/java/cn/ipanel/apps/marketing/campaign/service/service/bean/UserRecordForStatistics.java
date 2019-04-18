package cn.ipanel.apps.marketing.campaign.service.service.bean;

import cn.ipanel.apps.marketing.campaign.service.entity.ActivityUserRecordInfo;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/25 下午5:52
 * Modified By:
 * Description: 转换用户记录info，统计数据专用
 * (info里面没有按钮相应的response字段为空，此时在统计代码里面按用户分类，用户再按响应进行分类，空字段会报错)
 */
@Data
public class UserRecordForStatistics {
    private String user;
    private String popDay;
    private String response;

    public UserRecordForStatistics(ActivityUserRecordInfo info) {
        this.user = info.getUserId();
        this.popDay = info.getPopDay();
        this.response = Globals.isEmpty(info.getResponse()) ? "notResponse" : info.getResponse();
    }
}
