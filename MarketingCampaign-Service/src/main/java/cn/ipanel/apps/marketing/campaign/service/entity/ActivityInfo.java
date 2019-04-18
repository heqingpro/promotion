package cn.ipanel.apps.marketing.campaign.service.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午3:55
 * Modified By:
 * Description: 活动表
 */
@Data
@Table
@Entity
@DynamicUpdate
@DynamicInsert
public class ActivityInfo implements Serializable {

    private static final long serialVersionUID = 675595925774089534L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动名称
     */
    @Column
    private String name;

    /**
     * 活动编号
     */
    @Column
    private String code;

    /**
     * 活动类型
     */
    @Column
    private String activityType;

    /**
     * 活动类别
     */
    @Column
    private String activityCategory;

    /**
     * 活动商品id
     */
    @Column
    private Integer goodsId;

    /**
     * 生效时间
     */
    @Column
    private Long effectiveDate;

    /**
     * 失效时间
     */
    @Column
    private Long expireDate;

    /**
     * 是否上线
     */
    @Column
    private Boolean publish;

    /**
     * 优先级
     */
    @Column
    private Integer priorityLevel;

    /**
     * 介绍
     */
    @Column
    private String introduce;

    @ManyToOne
    @JoinColumn(name = "goodsId", insertable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private GoodsInfo goodsInfo;

    public ActivityInfo() {
    }

    public ActivityInfo getSelf() {
        return this;
    }

    public ActivityInfo(String name, String number, String activityType, String activityCategory, Integer goodsId,
                        Long effectiveDate, Long expireDate, String introduce) {
        this.name = name;
        this.code = number;
        this.activityType = activityType;
        this.activityCategory = activityCategory;
        this.goodsId = goodsId;
        this.effectiveDate = effectiveDate;
        this.expireDate = expireDate;
        this.publish = false;
        this.priorityLevel = 0;
        this.introduce = introduce;
    }

    public ActivityInfo(String name, String number, String activityType, String activityCategory, Integer goodsId,
                        Long effectiveDate, Long expireDate, String introduce, Boolean publish, Integer priorityLevel) {
        this.name = name;
        this.code = number;
        this.activityType = activityType;
        this.activityCategory = activityCategory;
        this.goodsId = goodsId;
        this.effectiveDate = effectiveDate;
        this.expireDate = expireDate;
        this.publish = publish;
        this.priorityLevel = priorityLevel;
        this.introduce = introduce;
    }
}
