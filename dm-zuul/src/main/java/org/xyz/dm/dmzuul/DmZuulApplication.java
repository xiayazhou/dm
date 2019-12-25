package org.xyz.dm.dmzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
//@EnableZuulProxy
public class DmZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmZuulApplication.class, args);
    }

}
