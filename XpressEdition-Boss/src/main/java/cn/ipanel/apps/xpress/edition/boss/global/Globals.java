package cn.ipanel.apps.xpress.edition.boss.global;

import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * @author luzh
 */
public class Globals {

    public static final String API_TV = "TV接口";
    public static final String API_BACK = "后台接口";

    public static ZoneOffset getSystemDefaultZoneOffSet() {
        return Clock.systemDefaultZone().getZone().getRules().getOffset(Instant.now());
    }

    public static final DateTimeFormatter COMMON_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Long convertTime(String time) {
        if (isBlank(time)) {
            return 0L;
        }
        if (time.length() == 16) {
            time += ":00";
        } else if (time.length() == 10) {
            time += " 00:00:00";
        } else if (time.length() != 19) {
            return 0L;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(time, COMMON_FORMATTER);
            return dateTime.toInstant(ZonedDateTime.now().getOffset()).toEpochMilli();
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * utc时间毫秒值时间转成格式化日期
     * @param dateTime 时间
     * @return 日期
     */
    private static String longDateTimeFormatter(Long dateTime) {
        try {
            return COMMON_FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTime), getSystemDefaultZoneOffSet()));
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * utc时间毫秒值时间转成格式化日期
     * @param dateTime 时间
     * @return 日期
     */
    public static String formatterDateTime(Long dateTime) {
        return Optional.ofNullable(dateTime).map(Globals::longDateTimeFormatter).orElse("---");
    }

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Throwable getOriginException(Throwable e){
        while(e.getCause() != null){
            e = e.getCause();
        }
        return e;
    }

    public static void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查输入字段
     * @param obj 检查对象
     * @param checkIsEmpty 是否检查为空
     * @param length 长度
     * @param max 最大值
     * @param min 最小值
     * @param paramName 提示名称
     * @throws RequestParamErrorException e
     */
    public static void checkRequestParam(Object obj, Boolean checkIsEmpty, Integer length, Integer max, Integer min,
                                         String paramName) throws RequestParamErrorException {
        if (null == obj) {
            throw new RequestParamErrorException(paramName + "不能为空");
        }
        if (checkIsEmpty && StringUtils.isEmpty(obj)) {
            throw new RequestParamErrorException(paramName + "不能为空");
        }
        if (obj instanceof List<?> && checkIsEmpty) {
            if (((List<?>)obj).isEmpty()) {
                throw new RequestParamErrorException(paramName + "不能为空");
            }
            if (length != null && ((List<?>)obj).size() != length) {
                throw new RequestParamErrorException(paramName + "大小为" + length);
            }
            if (max != null && ((List<?>)obj).size() > max) {
                throw new RequestParamErrorException(paramName + "大小不能超过" + max);
            }
            if (min != null && ((List<?>)obj).size() < min) {
                throw new RequestParamErrorException(paramName + "大小不能小于" + min);
            }
        }
        if (obj instanceof String) {
            if (length != null && !StringUtils.isEmpty(obj) && obj.toString().length() != length) {
                throw new RequestParamErrorException(paramName + "长度为" + length);
            }
            if (max != null && !StringUtils.isEmpty(obj) && obj.toString().length() > max
                    && max > 0) {
                throw new RequestParamErrorException(paramName + "长度不能超过" + max);
            }
            if (min != null && !StringUtils.isEmpty(obj) && obj.toString().length() < min
                    && min > 0) {
                throw new RequestParamErrorException(paramName + "长度不能少于" + min);
            }
        }
        if (obj instanceof Long) {
            if (min != null && (Long) obj < min) {
                throw new RequestParamErrorException(paramName + "不能小于" + min);
            }
            if (max != null && (Long) obj > max) {
                throw new RequestParamErrorException(paramName + "不能大于" + max);
            }
        }
        if (obj instanceof Integer) {
            if (min != null && (Integer) obj < min) {
                throw new RequestParamErrorException(paramName + "不能小于" + min);
            }
            if (max != null && (Integer) obj > max) {
                throw new RequestParamErrorException(paramName + "不能大于" + max);
            }
        }
        if (obj instanceof Double) {
            if (min != null && (Double) obj <= min) {
                throw new RequestParamErrorException(paramName + "不能小于等于" + min);
            }
            if (max != null && ((Double) obj).intValue() > max) {
                throw new RequestParamErrorException(paramName + "不能大于" + max);
            }
        }
    }
}
