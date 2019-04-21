package cn.ipanel.apps.xpress.edition.management.dao;

import cn.ipanel.apps.xpress.edition.management.entity.RoleInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午6:05
 * Modified By:
 * Description:
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleInfo, Integer> {

    List<RoleInfo> findByIdIn(List<Integer> ids);

    List<RoleInfo> findByNameIn(List<String> names);

    Optional<RoleInfo> findByName(String roleName);
}
