package cn.ipanel.apps.interactive.window.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/15 下午2:07
 * Modified By:
 * Description: 用户活动参加记录表
 */
@Data
@Table
@Entity
@DynamicInsert
@DynamicUpdate
public class UserMessageRecordInfo implements Serializable {
    private static final long serialVersionUID = 1953579376250836720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 弹窗序列号
     */
    @Column
    private String serialNumber;

    /**
     * 消息id
     */
    @Column
    private Long userMessageId;

    /**
     * 用户ca卡
     */
    @Column
    private String userId;

    /**
     * 弹窗时间
     */
    @Column
    private Long popTime;

    /**
     * 响应时间
     */
    @Column
    private Long responseTime;

    /**
     * 响应动作
     */
    @Column
    private String response;

    @Column
    private String responseButtonName;

    /**
     * 是否有响应，用来记录用户是否有点击按钮
     */
    @Column
    private Boolean hasResponse;

    public UserMessageRecordInfo() {
    }

    public UserMessageRecordInfo(String serialNumber, Long userMessageId, String userId, Long popTime) {
        this.serialNumber = serialNumber;
        this.userMessageId = userMessageId;
        this.userId = userId;
        this.popTime = popTime;
        this.hasResponse = false;
    }
}
