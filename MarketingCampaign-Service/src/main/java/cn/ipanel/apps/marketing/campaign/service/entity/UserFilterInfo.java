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
 * Create: 2018/9/20 上午10:24
 * Modified By:
 * Description: 用户过滤名单
 */
@Data
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class UserFilterInfo implements Serializable {
    private static final long serialVersionUID = 6227038700650761995L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户CA卡
     */
    @Column
    private String user;

    public UserFilterInfo() {
    }

    public UserFilterInfo(String user) {
        this.user = user;
    }
}
