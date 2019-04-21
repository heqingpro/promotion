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
 * Create: 2018/9/6 下午3:45
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class AreaInfo implements Serializable {
    private static final long serialVersionUID = 856616137622408992L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String areaName;

    public AreaInfo() {
    }
}
