package com.kgc.ddbuy.ddbuy_protal_web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.ddbuy_common_service.service.TbContentService;
import com.kgc.ddbuy.pojo.Tb_content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;

    //显示首页
    @RequestMapping("/Index")
    public String GoIndex(Model model) {
        //查询广告
        List<Tb_content> list = tbContentService.AllTbContent();
        //填充数据
        model.addAttribute("list",list);

        return "Index";
    }
}
