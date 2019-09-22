package com.kgc.ddbuy.ddbuy_Search_web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DdbuySearchWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdbuySearchWebApplication.class, args);
    }

}
