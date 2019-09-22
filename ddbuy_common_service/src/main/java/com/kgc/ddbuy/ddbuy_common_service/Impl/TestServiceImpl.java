package com.kgc.ddbuy.ddbuy_common_service.Impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.ddbuy_common_service.service.TestService;
import org.springframework.stereotype.Component;

@Component  //暴露服务
@Service(interfaceClass = TestService.class)   //使用阿里巴巴的服务来反射这个类
public class TestServiceImpl implements TestService {


    @Override
    public String getHw() {
        return "HelloWorld";
    }
}
