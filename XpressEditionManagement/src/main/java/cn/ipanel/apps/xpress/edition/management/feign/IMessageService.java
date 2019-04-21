package cn.ipanel.apps.xpress.edition.management.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/16 下午2:41
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "InteractiveWindowService", fallbackFactory = IMessageService.MessageServiceFallback.class, configuration = FeignConfiguration.class)
public interface IMessageService {

    @RequestMapping(value = "/manage/message/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FeignResult<String> uploadFile(@RequestParam(value = "mould") Integer mouldId, @RequestPart(value = "file") MultipartFile multipartFile);

    @Component
    class MessageServiceFallback implements FallbackFactory<IMessageService> {

        @Override
        public IMessageService create(Throwable cause) {
            return (mouldId, multipartFile) -> new FeignResult<>(cause);
        }
    }
}
