package cn.ipanel.apps.marketing.campaign.service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/27 上午11:27
 * Modified By:
 * Description:
 */
public class DateUtil {

    public static LocalDateTime getYesterdayOfNextMonth(LocalDate localDate) {
        int yearOfNextMonth = localDate.getMonthValue() == 12 ? localDate.getYear() + 1 : localDate.getYear();
        int monthOfNextMonth = localDate.getMonthValue() == 12 ? 1 : localDate.getMonthValue() +1;
        int lengthOfNextMonth = LocalDate.of(yearOfNextMonth, monthOfNextMonth, 1).lengthOfMonth();
        int dayOfNextMonth = lengthOfNextMonth < localDate.getDayOfMonth() ? lengthOfNextMonth : localDate.getDayOfMonth() - 1;
        if (dayOfNextMonth == 0) {
            dayOfNextMonth = 1;
            return LocalDateTime.of(yearOfNextMonth, monthOfNextMonth, dayOfNextMonth, 0, 0).minusDays(1);
        }
        return LocalDateTime.of(yearOfNextMonth, monthOfNextMonth, dayOfNextMonth, 0, 0);
    }

    public static LocalDateTime getYesterdayOfAFewMonthsLater(LocalDate localDate, Integer month) {
        int yearOfFewMonthsLater = localDate.getMonthValue() + month > 12 ? localDate.getYear() + 1 : localDate.getYear();
        int monthOfFewMonthsLater = localDate.getMonthValue() + month > 12 ? localDate.getMonthValue() + month - 12 : localDate.getMonthValue() + month;
        int lengthOfFewMonthsLater = LocalDate.of(yearOfFewMonthsLater, monthOfFewMonthsLater, 1).lengthOfMonth();
        int dayOfFewMonthsLater = lengthOfFewMonthsLater < localDate.getDayOfMonth() ? lengthOfFewMonthsLater : localDate.getDayOfMonth() - 1;
        if (dayOfFewMonthsLater == 0) {
            dayOfFewMonthsLater = 1;
            return LocalDateTime.of(yearOfFewMonthsLater, monthOfFewMonthsLater, dayOfFewMonthsLater, 0, 0).minusDays(1);
        }
        return LocalDateTime.of(yearOfFewMonthsLater, monthOfFewMonthsLater, dayOfFewMonthsLater, 0, 0);
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2018, 12, 1);
        System.out.println(getYesterdayOfNextMonth(localDate));
        System.out.println(getYesterdayOfAFewMonthsLater(localDate, 1));
    }
}
