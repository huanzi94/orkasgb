package com.orkasgb.orkasgbdatacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.orkasgb")
public class OrkasgbReleaseDatacenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrkasgbReleaseDatacenterApplication.class, args);
    }

}
