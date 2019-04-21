package cn.ipanel.apps.marketing.campaign.service.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/11/13 3:23 PM
 * Modified By:
 * Description:
 */
public interface ITransferDataService {
    Boolean uploadFile(Integer activityId, MultipartFile file) throws Exception;
}
