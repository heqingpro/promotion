package cn.ipanel.apps.marketing.campaign.service.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/30 下午4:23
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicUpdate
@DynamicInsert
public class UserOrderInfo implements Serializable {
    private static final long serialVersionUID = 5099609191250827712L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户CA卡
     */
    @Column
    private String user;

    /**
     * 商品编号
     */
    @Column
    private String goodsCode;

    /**
     * 订购日期
     */
    @Column
    private String orderDate;

    /**
     * 结束日期
     */
    @Column
    private String endDate;

    /**
     * 弹窗记录id
     */
    @Column
    private Long recordId;

    @Column
    private Integer activityId;

    @OneToOne
    @JoinColumn(name = "recordId", insertable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "none", value = ConstraintMode.NO_CONSTRAINT))
    private ActivityUserRecordInfo recordInfo;

    public UserOrderInfo() {
    }

    public UserOrderInfo(String user, String goodsCode, String orderDate, String endDate, Long recordId, Integer activityId) {
        this.user = user;
        this.goodsCode = goodsCode;
        this.orderDate = orderDate;
        this.endDate = endDate;
        this.recordId = recordId;
        this.activityId = activityId;
    }
}
