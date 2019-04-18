package cn.ipanel.apps.xpress.edition.management.entity;

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
 * @author luzhihao
 * Create: 2018-05-23 下午5:11
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicUpdate
@DynamicInsert
public class ManagerInfo implements Serializable {
    private static final long serialVersionUID = 6936961671506654718L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 16)
    private String username;

    @Column(length = 32)
    private String name;

    @Column(length = 32)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(foreignKeyDefinition = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private List<RoleInfo> roles;

    public ManagerInfo(String username, String name, String password, List<RoleInfo> roles) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public ManagerInfo() {
    }
}
