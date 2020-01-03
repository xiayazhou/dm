package org.xyz.dm;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@MapperScan("org.xyz.dm.mapper")
public class DmItemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmItemProviderApplication.class, args);
    }

}
