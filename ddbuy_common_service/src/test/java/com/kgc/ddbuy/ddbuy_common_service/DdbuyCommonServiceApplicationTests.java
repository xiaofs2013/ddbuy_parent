package com.kgc.ddbuy.ddbuy_common_service;

import com.ddbuy.ddbuy_common_service.service.SerchService;
import com.ddbuy.ddbuy_common_service.service.TbContentCategoryService;
import com.github.pagehelper.PageInfo;
import com.kgc.ddbuy.pojo.Tb_content_category;
import com.kgc.ddbuy.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyCommonServiceApplicationTests {

    @Autowired   //注入业务对象
    private TbContentCategoryService tbContentCategoryService;

    @Autowired //注入Solr业务对象以便于测试
    private SerchService serchService;

    @Test
    public void TestSolr() {

        Long start = System.currentTimeMillis();

        //调用业务
        boolean b = serchService.PropertiesImporToSolr();

        Long end = System.currentTimeMillis();

        if (b == true) {
            System.out.println("导入成功！花了" + (end - start) + "毫秒");
        } else {
            System.out.println("导入失败！！！");
        }

    }




    @Test
    public void contextLoads() {

        Page page = new Page(1, 3);
        PageInfo<Tb_content_category> list = tbContentCategoryService.GetCategoryByPage(page);
        System.out.println("总记录数：" + list.getTotal());

        for (Tb_content_category tb : list.getList()) {
            System.out.println("名称" + tb.getName());
        }

    }

}
