package cn.ipanel.apps.marketing.campaign.service.entity;

import cn.ipanel.apps.marketing.campaign.service.global.Globals;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午5:13
 * Modified By:
 * Description: 活动类别枚举
 */
public enum  ActivityCategoryEnum {
    CUXIAO("category1", "促销")
    ,MIANFEI("category2", "免费")
    ;

    private String category;
    private String categoryName;

    ActivityCategoryEnum(String category, String categoryName) {
        this.category = category;
        this.categoryName = categoryName;
    }

    public static String categoryName(String category) {
        if (Globals.isEmpty(category)) {
            return "";
        }
        for (ActivityCategoryEnum categoryEnum : ActivityCategoryEnum.values()) {
            if (categoryEnum.category.equals(category)) {
                return categoryEnum.categoryName;
            }
        }
        return "";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
