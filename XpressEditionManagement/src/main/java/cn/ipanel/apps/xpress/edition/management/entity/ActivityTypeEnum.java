package cn.ipanel.apps.xpress.edition.management.entity;


import cn.ipanel.apps.xpress.edition.management.global.Globals;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午3:58
 * Modified By:
 * Description: 活动类型枚举
 */
public enum ActivityTypeEnum {
    TIYAN("type1", "体验活动"),
    TIYAN_XD("type2", "体验活动到期续订活动");

    ActivityTypeEnum(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public static String typeName(String type) {
        if (Globals.isEmpty(type)) {
            return "";
        }
        for (ActivityTypeEnum typeEnum : ActivityTypeEnum.values()) {
            if (typeEnum.getType().equals(type)) {
                return typeEnum.getTypeName();
            }
        }
        return "";
    }

    private String type;
    private String typeName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
