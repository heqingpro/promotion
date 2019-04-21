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
 * Create: 2018/8/20 下午2:29
 * Modified By:
 * Description:
 */
@Data
@Entity
@Table
@DynamicUpdate
@DynamicInsert
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = 6200482004952339928L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品名称
     */
    @Column
    private String goodsName;

    /**
     * 商品编号
     */
    @Column
    private String goodsCode;

    public GoodsInfo(String goodsName, String goodsCode) {
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
    }

    public GoodsInfo() {
    }
}
