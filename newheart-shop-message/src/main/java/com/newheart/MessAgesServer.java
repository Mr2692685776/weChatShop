package com.newheart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hanjie
 * @date 2019/9/29 16:35
 */

@SpringBootApplication
@EnableEurekaClient
public class MessAgesServer {
    public static void main(String[] args) {
        SpringApplication.run(MessAgesServer.class,args);
    }
}
