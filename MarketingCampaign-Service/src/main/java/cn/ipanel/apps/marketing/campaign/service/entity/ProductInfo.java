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
 * Create: 2018/8/23 下午2:59
 * Modified By:
 * Description:
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class ProductInfo implements Serializable {
    private static final long serialVersionUID = 6684738959776575622L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品名称
     */
    @Column
    private String productName;

    /**
     * 产品编号
     */
    @Column
    private String productCode;

    public ProductInfo() {
    }

    public ProductInfo(String productName, String productCode) {
        this.productName = productName;
        this.productCode = productCode;
    }
}
