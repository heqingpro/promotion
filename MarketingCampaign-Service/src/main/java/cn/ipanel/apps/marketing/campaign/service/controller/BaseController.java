package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/7 下午3:01
 * Modified By:
 * Description:
 */
@ApiIgnore
@RestController
@RequestMapping(value = "")
public class BaseController {

    @RequestMapping(value = "")
    public Result<String> index() {
        return new Result<>(LocalDateTime.now().toString());
    }
}
