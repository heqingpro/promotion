package cn.ipanel.apps.interactive.window.controller;

import cn.ipanel.apps.interactive.window.controller.resp.MessageVO;
import cn.ipanel.apps.interactive.window.controller.resp.Result;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.service.IMessageService;
import cn.ipanel.apps.interactive.window.task.AsyncTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/12 上午11:19
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_TV)
@RestController
@RequestMapping(value = "message")
public class MessageController {

    private IMessageService messageService;
    private AsyncTask task;

    @Autowired
    public MessageController(IMessageService messageService, AsyncTask asyncTask) {
        this.messageService = messageService;
        this.task = asyncTask;
    }

    @ApiOperation(value = "查询用户的弹窗消息")
    @ApiImplicitParam(name = "user", value = "用户ca卡", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<MessageVO> message(@RequestParam(value = "user") String userId) throws Exception {
        return new Result<>(messageService.queryUserMessage(userId));
    }

    @ApiOperation(value = "弹窗响应")
    @RequestMapping(value = "response", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "serialNumber", value = "弹窗序列号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "user", value = "用户CA卡", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "recordId", value = "弹窗记录id", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "popTime", value = "弹窗生成时间", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "response", value = "弹窗响应动作", required = true, dataType = "String", paramType = "query")
    })
    public Result<Boolean> response(@RequestParam(value = "serialNumber") String serialNumber,
                                    @RequestParam(value = "user") String userId,
                                    @RequestParam(value = "recordId") Long recordId,
                                    @RequestParam(value = "popTime") Long popTime,
                                    @RequestParam(value = "response") String response) {
        task.messageResponse(serialNumber, userId, recordId, popTime, response);
        return new Result<>(true);
    }
}
