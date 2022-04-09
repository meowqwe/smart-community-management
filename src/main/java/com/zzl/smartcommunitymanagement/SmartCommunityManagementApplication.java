package com.zzl.smartcommunitymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zzl.smartcommunitymanagement.dao")
public class SmartCommunityManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCommunityManagementApplication.class, args);
    }

}
