package org.example.business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.business.dao")
@EnableDubbo(scanBasePackages = "org.example.business.service")
public class AccountProviderApplication {

    /**
     * vm-option: -server -Xms768m -Xmx768m -XX:PermSize=128m
     */
    public static void main(String[] args) {
        SpringApplication.run(AccountProviderApplication.class, args);
    }
}
