package org.example.business;

import io.seata.config.springcloud.EnableSeataSpringConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@EnableSeataSpringConfig
@MapperScan("org.example.business.mapper")
public class StorageProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageProviderApplication.class, args);
    }
}
