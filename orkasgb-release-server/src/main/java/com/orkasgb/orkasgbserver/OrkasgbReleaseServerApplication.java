package com.orkasgb.orkasgbserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.orkasgb")
@MapperScan("com.orkasgb.orkasgbserver.dao")
public class OrkasgbReleaseServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrkasgbReleaseServerApplication.class, args);
    }

}
