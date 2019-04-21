package cn.ipanel.apps.interactive.window.dao;

import cn.ipanel.apps.interactive.window.entity.UserMessageRecordInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/12 上午11:40
 * Modified By:
 * Description:
 */
@Repository
public interface UserMessageRecordRepository extends CrudRepository<UserMessageRecordInfo, Long> {

    List<UserMessageRecordInfo> findByUserMessageId(Long messageId);

}
