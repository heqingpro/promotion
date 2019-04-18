package cn.ipanel.apps.marketing.campaign.service.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午5:14
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicUpdate
@DynamicInsert
public class Type1ActivityInfo implements Serializable {
    private static final long serialVersionUID = 6493759939952135337L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联活动id
     */
    @Column
    private Integer activityId;

    @Column
    @Deprecated
    private String checkOrderType;

    @Column
    private String mustOrderType;

    /**
     * 必须已订购产品（商品）
     */
    @Column
    private String mustOrderedInfo;

    /**
     * 校验已订购产品（商品）的方式：或（只有一个订购）or且（必须全部订购）
     */
    private String checkMustOrderMode;

    @Column
    private String mustNotOrderType;

    /**
     * 必须未订购产品（商品）
     */
    @Column
    private String mustNotOrderedInfo;

    /**
     * 校验未订购产品（商品）的方式：或（只有一个未订购）or且（必须全部未订购）
     */
    private String checkMustNotOrderMode;

    /**
     * 订购时长，月数
     */
    @Column
    private Integer orderLength;

    /**
     * 是否开启限额
     */
    @Column
    private Boolean openLimit;

    /**
     * 限购数量
     */
    @Column
    private Integer limitNumber;

    /**
     * 是否按区域开启限额
     */
    @Column
    private Boolean limitByArea;

    /**
     * 是否开启用户过滤名单
     */
    @Column
    private Boolean openFilter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<AreaLimit> areaLimits;

    /**
     * 同类型最大参加次数
     */
    @Column
    private Integer maxType1JoinTimes;

    public Type1ActivityInfo(Integer activityId, String mustOrderType, String mustOrderedInfo, String checkMustOrderedMode,
                             String mustNotOrderType, String mustNotOrderedInfo, String checkMustNotOrderedMode,
                             Integer maxType1JoinTimes, Boolean openLimit, Integer limitNumber, Boolean limitByArea,
                             List<AreaLimit> areaLimits, Boolean openFilter, Integer orderLength) {
        this.activityId = activityId;
        this.mustOrderType = mustOrderType;
        this.mustOrderedInfo = mustOrderedInfo;
        this.checkMustOrderMode = checkMustOrderedMode;
        this.mustNotOrderType = mustNotOrderType;
        this.mustNotOrderedInfo = mustNotOrderedInfo;
        this.checkMustNotOrderMode = checkMustNotOrderedMode;
        this.maxType1JoinTimes = maxType1JoinTimes;
        this.openLimit = openLimit;
        this.limitNumber = limitNumber;
        this.limitByArea = limitByArea;
        this.areaLimits = areaLimits;
        this.openFilter = openFilter;
        this.orderLength = orderLength;
    }

    public Type1ActivityInfo() {
    }
}
