package cn.ipanel.apps.interactive.window.dao;

import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/8 上午11:11
 * Modified By:
 * Description:
 */
@Repository
public interface MouldRepository extends CrudRepository<MouldInfo, Integer> {

    MouldInfo findByName(String name);

    MouldInfo findByCode(String code);

    List<MouldInfo> findByEffectiveDateLessThanAndExpireDateGreaterThan(Long effectiveDate, Long expireDate);
}
