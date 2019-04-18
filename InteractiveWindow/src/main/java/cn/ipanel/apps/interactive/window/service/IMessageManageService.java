package cn.ipanel.apps.interactive.window.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/10 下午2:44
 * Modified By:
 * Description:
 */
public interface IMessageManageService {
    String uploadFile(Integer mouldId, MultipartFile file) throws Exception;
}
