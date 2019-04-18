package cn.ipanel.apps.xpress.edition.boss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XpressEditionBossApplication {

    public static void main(String[] args) {
        SpringApplication.run(XpressEditionBossApplication.class, args);
    }
}
