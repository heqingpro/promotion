package cn.ipanel.apps.interactive.window.entity;

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
 * Create: 2018/10/8 上午11:02
 * Modified By:
 * Description: 弹窗模板
 */
@Data
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class MouldInfo implements Serializable {
    private static final long serialVersionUID = 526460073809018789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String title;

    @Column
    private String content;

    /**
     * 优先级
     */
    @Column
    private Integer priorityLevel;

    @Column
    private Long effectiveDate;

    /**
     * 截止日期
     */
    @Column
    private Long expireDate;

    @Column
    private String button1Name;

    @Column
    private String button1Url;

    @Column
    private String button2Name;

    @Column
    private String button2Url;

    @Column
    private String button3Name;

    @Column
    private String button3Url;

    public MouldInfo() {
    }

    public MouldInfo(String name, String content, String title, String code, Long effectiveDate, Long expireDate, Integer priorityLevel,
                     String button1Name, String button1Url,
                     String button2Name, String button2Url, String button3Name, String button3Url) {
        this.name = name;
        this.content = content;
        this.code = code;
        this.effectiveDate = effectiveDate;
        this.expireDate = expireDate;
        this.button1Name = button1Name;
        this.priorityLevel = priorityLevel;
        this.button1Url = button1Url;
        this.button2Name = button2Name;
        this.button2Url = button2Url;
        this.button3Name = button3Name;
        this.button3Url = button3Url;
        this.title = title;
    }

    public MouldInfo getSelf() {
        return this;
    }
}
