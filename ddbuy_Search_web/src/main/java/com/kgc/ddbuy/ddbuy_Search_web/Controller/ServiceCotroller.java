package com.kgc.ddbuy.ddbuy_Search_web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.ddbuy_common_service.service.SerchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceCotroller {

    @Reference(interfaceClass = SerchService.class,timeout = 8000)  //设置服务时间 避免服务时间太长报错
    private SerchService serchService;

    @RequestMapping(value = "/importSolr")
    @ResponseBody
    public String importSolr() {
        boolean b = serchService.PropertiesImporToSolr();
        return b + "";
    }

}
