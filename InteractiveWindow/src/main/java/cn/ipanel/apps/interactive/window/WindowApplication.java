package cn.ipanel.apps.interactive.window;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
public class WindowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WindowApplication.class, args);
    }
}
