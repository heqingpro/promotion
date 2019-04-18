package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.service.ITransferDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/11/13 3:16 PM
 * Modified By:
 * Description: 从其他地方转移数据生成弹窗记录和订购记录
 */
@RestController
@RequestMapping(value = "transfer")
public class TransferDataController {

    private final ITransferDataService transferService;

    @Autowired
    public TransferDataController(ITransferDataService transferService) {
        this.transferService = transferService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Boolean uploadFile(@RequestParam(value = "activityId") Integer activityId, @RequestParam(value = "file") MultipartFile multipartFile) throws Exception {
        return transferService.uploadFile(activityId, multipartFile);
    }
}
