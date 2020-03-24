package org.example.business;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@EnableAutoDataSourceProxy
@MapperScan("org.example.business.dao")
public class OrderProviderApplication {

    /**
     * vm-option: -server -Xms768m -Xmx768m -XX:PermSize=128m
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }
}
