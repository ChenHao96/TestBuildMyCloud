package org.example.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.business.mapper")
public class StorageProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageProviderApplication.class, args);
    }
}
