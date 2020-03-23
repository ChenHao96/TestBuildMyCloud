package org.example.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.business.dao")
public class AccountProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountProviderApplication.class, args);
    }
}
