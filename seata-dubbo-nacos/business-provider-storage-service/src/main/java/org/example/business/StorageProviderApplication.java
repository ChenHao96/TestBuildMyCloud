package org.example.business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.business.mapper")
@EnableDubbo(scanBasePackages = "org.example.business.service")
public class StorageProviderApplication {

    /**
     * vm-option: -server -Xms768m -Xmx768m
     */
    public static void main(String[] args) {
        SpringApplication.run(StorageProviderApplication.class, args);
    }
}
