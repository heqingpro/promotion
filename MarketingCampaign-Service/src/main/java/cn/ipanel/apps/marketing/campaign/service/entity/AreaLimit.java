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
 * Create: 2018/9/6 下午3:47
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicUpdate
@DynamicInsert
public class AreaLimit implements Serializable {
    private static final long serialVersionUID = 4560244496547306009L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer activityId;

    @Column
    private Integer areaId;

    @Column
    private Integer areaLimitNumber;

    @ManyToOne
    @JoinColumn(name = "areaId", insertable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private AreaInfo areaInfo;

    public AreaLimit() {
    }

    public AreaLimit(Integer activityId, Integer areaId, Integer areaLimitNumber) {
        this.activityId = activityId;
        this.areaId = areaId;
        this.areaLimitNumber = areaLimitNumber;
    }
}
