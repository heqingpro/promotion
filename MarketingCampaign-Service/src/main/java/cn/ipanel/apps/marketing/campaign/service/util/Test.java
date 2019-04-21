package cn.ipanel.apps.marketing.campaign.service.util;

import cn.ipanel.apps.marketing.campaign.service.global.Globals;

import java.time.LocalDate;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/30 下午5:02
 * Modified By:
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        String time = "2018-10-20";
        LocalDate localDate = LocalDate.parse(time, Globals.COMMON_DATE_FORMATTER);
        System.out.println(localDate.toString());
        LocalDate localDate1 = LocalDate.now().plusDays(1);
        System.out.println(localDate1.isAfter(localDate) || localDate1.isEqual(localDate));
    }
}
