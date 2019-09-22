package com.kgc.ddbuy.ddbuy_manage_web.Controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.ddbuy_common_service.service.TbContentCategoryService;
import com.github.pagehelper.PageInfo;
import com.kgc.ddbuy.pojo.Tb_content_category;
import com.kgc.ddbuy.utils.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class ContentCategroyController {

    @Reference(interfaceClass = TbContentCategoryService.class)  //用在消费端，表明使用的是服务端的什么服务

    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping("/GetContentGetgroy")
    @ResponseBody
    public Map<String, Object> GetContentGetgroy(Page page) {

        PageInfo<Tb_content_category> pageInfo = tbContentCategoryService.GetCategoryByPage(page);

        //返回map对象：存放rows当前页目录  total总记录数
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }

    @RequestMapping("/GetGetgroy")
    @ResponseBody
    public List<Tb_content_category> GetContentCatgroy() {

        List<Tb_content_category> list = tbContentCategoryService.GetAllContentCategory();

        return list;

    }

}
