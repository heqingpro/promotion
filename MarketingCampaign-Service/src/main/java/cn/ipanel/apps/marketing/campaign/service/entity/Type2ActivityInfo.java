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
 * Create: 2018/8/16 下午5:15
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class Type2ActivityInfo implements Serializable {
    private static final long serialVersionUID = 5921269914172930651L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联活动id
     */
    @Column
    private Integer activityId;

    /**
     * 关联的类型1活动id
     */
    @Column
    private Integer correlationType1ActivityId;

    @ManyToOne
    @JoinColumn(name = "correlationType1ActivityId", insertable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private ActivityInfo correlationType1ActivityInfo;

    /**
     * 活动1到期提前提醒天数
     */
    @Column
    private Integer advanceRemindDay;

    public Type2ActivityInfo() {
    }

    public Type2ActivityInfo(Integer activityId, Integer correlationType1ActivityId, Integer advanceRemindDay) {
        this.activityId = activityId;
        this.correlationType1ActivityId = correlationType1ActivityId;
        this.advanceRemindDay = advanceRemindDay;
    }
}
