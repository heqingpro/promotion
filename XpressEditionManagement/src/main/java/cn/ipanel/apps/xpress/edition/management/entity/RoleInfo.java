package cn.ipanel.apps.xpress.edition.management.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午5:45
 * Modified By:
 * Description:
 */
@Data
@Table
@Entity
@DynamicInsert
@DynamicUpdate
public class RoleInfo implements Serializable {
    private static final long serialVersionUID = -5902810857282764507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String url;

    public RoleInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public RoleInfo() {

    }
}
