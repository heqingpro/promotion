package cn.ipanel.apps.interactive.window.service;

import cn.ipanel.apps.interactive.window.controller.req.MouldReq;
import cn.ipanel.apps.interactive.window.controller.resp.back.MouldBackVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/8 上午11:14
 * Modified By:
 * Description:
 */
public interface IMouldManageService {
    Boolean addMould(MouldReq req) throws Exception;

    Boolean modifyMould(Integer id, MouldReq req) throws Exception;

    Boolean removeMould(Integer id) throws Exception;

    List<MouldBackVO> queryMould();

    MouldBackVO queryMould(Integer id) throws Exception;

    Boolean adjustPriority(Integer mouldId, String operation) throws Exception;

    List<MouldBackVO> queryMouldByPriorityLevel();

    void rearrangePriorityLevel();
}
