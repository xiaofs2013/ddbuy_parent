package com.kgc.ddbuy.ddbuy_manage_web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubboConfiguration  //启动dubbo
//@ComponentScan 如果当你的业务文件不和启动类在同一个包下就使用该注解引用
public class DdbuyManageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdbuyManageWebApplication.class, args);
    }

}
