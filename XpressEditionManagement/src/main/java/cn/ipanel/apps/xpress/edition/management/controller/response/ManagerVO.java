package cn.ipanel.apps.xpress.edition.management.controller.response;

import cn.ipanel.apps.xpress.edition.management.entity.ManagerInfo;
import cn.ipanel.apps.xpress.edition.management.entity.RoleInfo;
import lombok.Data;

import static java.util.stream.Collectors.joining;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午5:39
 * Modified By:
 * Description:
 */
@Data
public class ManagerVO {
    private Integer id;
    private String username;
    private String name;
    private String roles;

    public ManagerVO(ManagerInfo managerInfo) {
        this.id = managerInfo.getId();
        this.username = managerInfo.getUsername();
        this.name = managerInfo.getName();
        this.roles = managerInfo.getRoles().stream().map(RoleInfo::getName).collect(joining("、"));

    }
}
