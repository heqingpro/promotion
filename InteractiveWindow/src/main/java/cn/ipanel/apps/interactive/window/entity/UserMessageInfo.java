package cn.ipanel.apps.interactive.window.entity;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/11 上午9:03
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicUpdate
@DynamicInsert
public class UserMessageInfo implements Serializable {
    private static final long serialVersionUID = -283736396767706396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String user;

    @Column
    private String area;

    @Column
    private String message;

    @Column
    private Long createTime;

    @Column
    private Boolean hasPop;

    @Column
    private Long popTime;

    @Column
    private Boolean hasResponse;

    @Column
    private String response;

    @Column
    private Long responseTime;

    @Column
    private Long responseRecordId;

    @Column
    private Integer mouldId;

    @Column
    private String mouldName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mouldId", insertable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private MouldInfo mouldInfo;

    public UserMessageInfo() {
    }

    public UserMessageInfo(String user, String area, String message, Integer mouldId, String mouldName, Long createTime) {
        this.user = user;
        this.area = area;
        this.message = message;
        this.mouldId = mouldId;
        this.mouldName = mouldName;
        this.createTime = createTime;
        this.hasPop = false;
        this.hasResponse = false;
    }
}
