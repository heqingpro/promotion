package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestParameter;
import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestResult;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.feign.IMessageService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/16 下午2:41
 * Modified By:
 * Description:
 */
@Controller
@RequestMapping("window/message")
public class MessageManageController {

    private IMessageService messageService;

    @Autowired
    public MessageManageController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> uploadFile(@RequestParam(value = "mouldId") Integer mouldId, @RequestParam(value = "file") MultipartFile file) {
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getOriginalFilename());
        try (InputStream input = file.getInputStream(); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        return new Result<>(messageService.uploadFile(mouldId, multipartFile));
    }
}
