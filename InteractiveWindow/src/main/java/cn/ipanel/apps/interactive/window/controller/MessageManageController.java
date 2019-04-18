package cn.ipanel.apps.interactive.window.controller;

import cn.ipanel.apps.interactive.window.controller.resp.Result;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.service.IMessageManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/10 下午2:58
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_BACK)
@RestController
@RequestMapping(value = "manage/message")
public class MessageManageController {

    private IMessageManageService messageService;

    @Autowired
    public MessageManageController(IMessageManageService messageService) {
        this.messageService = messageService;
    }

    @ApiOperation(value = "选择模板导入文件")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Result<String> uploadFile(@RequestParam(value = "mould") Integer mouldId, @RequestParam(value = "file") MultipartFile multipartFile) throws Exception {
        return new Result<>(messageService.uploadFile(mouldId, multipartFile));
    }
}
