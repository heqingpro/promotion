package cn.ipanel.apps.marketing.campaign.service.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/15 下午2:07
 * Modified By:
 * Description: 用户活动参加记录表
 */
@Data
@Table
@Entity
@DynamicInsert
@DynamicUpdate
public class ActivityUserRecordInfo implements Serializable {
    private static final long serialVersionUID = 1953579376250836720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 弹窗序列号
     */
    @Column
    private String serialNumber;

    /**
     * 活动id
     */
    @Column
    private Integer activityId;

    /**
     * 活动类型
     */
    @Column
    private String activityType;

    /**
     * 活动促销类别
     */
    @Column
    private String activityCategory;

    /**
     * 用户ca卡
     */
    @Column
    private String userId;

    /**
     *
     */
    @Column
    private String userArea;

    /**
     * 弹窗时间
     */
    @Column
    private Long popTime;

    /**
     * 弹窗日期
     */
    @Column
    private String popDay;

    /**
     * 响应时间
     */
    @Column
    private Long responseTime;

    /**
     * 响应动作
     */
    @Column
    private String response;

    /**
     * 响应处理结果
     */
    @Column
    private String responseResult;

    /**
     * 响应日期
     */
    @Column
    private String responseDay;

    /**
     * 是否有响应，用来记录用户是否有点击按钮
     */
    @Column
    private Boolean hasResponse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activityId", insertable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private ActivityInfo activityInfo;

    public void setResponseResult(String responseResult) {
        this.responseResult = null != responseResult ? responseResult.length() >= 255 ? responseResult.substring(0, 254) : responseResult : "";
    }

    public ActivityUserRecordInfo() {
    }

    public ActivityUserRecordInfo(String serialNumber, Integer activityId, String activityType, String activityCategory, String userId, String userArea, Long popTime, String popDay) {
        this.serialNumber = serialNumber;
        this.activityId = activityId;
        this.activityType = activityType;
        this.activityCategory = activityCategory;
        this.userId = userId;
        this.popTime = popTime;
        this.popDay = popDay;
        this.userArea = userArea;
        this.hasResponse = false;
    }
}
