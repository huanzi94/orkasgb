package com.orkasgb.orkasgbweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.orkasgb")
public class OrkasgbReleaseWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrkasgbReleaseWebApplication.class, args);
    }

}
