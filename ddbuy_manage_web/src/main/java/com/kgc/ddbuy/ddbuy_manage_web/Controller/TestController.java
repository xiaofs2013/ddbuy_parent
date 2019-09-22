package com.kgc.ddbuy.ddbuy_manage_web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.ddbuy_common_service.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    //引用远程业务 来自接口层的接口类
    @Reference(interfaceClass = TestService.class)
    private TestService testService;

    @RequestMapping("/gethw")
    @ResponseBody
    public String gethw() {
        return testService.getHw();
    }

}
