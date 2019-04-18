package cn.ipanel.apps.xpress.edition.management.dao;

import cn.ipanel.apps.xpress.edition.management.entity.ManagerInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午5:35
 * Modified By:
 * Description:
 */
@Repository
public interface ManagerRepository extends CrudRepository<ManagerInfo, Integer> {

    ManagerInfo findByUsername(String username);
}
