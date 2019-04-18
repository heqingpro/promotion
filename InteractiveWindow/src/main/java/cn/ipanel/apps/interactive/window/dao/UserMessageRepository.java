package cn.ipanel.apps.interactive.window.dao;

import cn.ipanel.apps.interactive.window.entity.UserMessageInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/11 上午9:32
 * Modified By:
 * Description:
 */
@Repository
public interface UserMessageRepository extends CrudRepository<UserMessageInfo, Long> {

    List<UserMessageInfo> findByUserAndHasResponse(String user, Boolean hasResponse);

    List<UserMessageInfo> findByMouldId(Integer mouldId);

    List<UserMessageInfo> findByMouldIdAndUser(Integer mouldId, String user);

    List<UserMessageInfo> findByMouldIdAndHasResponse(Integer mouldId, Boolean hasResponse);

    List<UserMessageInfo> findByUser(String user);
}
