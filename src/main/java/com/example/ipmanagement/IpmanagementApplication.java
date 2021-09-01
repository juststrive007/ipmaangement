package com.example.ipmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.ipmanagement.mapper")
@SpringBootApplication
public class IpmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpmanagementApplication.class, args);
    }

}
