
package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BusinessApplication {

    /**
     * TODO:启动的时候需要确保seata-server注册的命名空间是否和client注册的是同一个
     */
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
