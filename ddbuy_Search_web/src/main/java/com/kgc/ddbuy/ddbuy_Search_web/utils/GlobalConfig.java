package com.kgc.ddbuy.ddbuy_Search_web.utils;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class GlobalConfig {
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> {
            factory.addContextCustomizers((context) -> {
                        //模块中webapp相对路径
                        String relativePath = "ddbuy_Search_web/src/main/webapp";
                        File docBaseFile = new File(relativePath);
                        // 路径是否存在
                        if (docBaseFile.exists()) {
                            context.setDocBase(docBaseFile.getAbsolutePath());
                        }
                    }
            );
        };
    }
}

