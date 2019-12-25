package org.xyz.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
//@ComponentScan(basePackages = "org.xyz.dm")
public class DmItemConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmItemConsumerApplication.class, args);
    }

}
