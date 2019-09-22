package com.kgc.ddbuy.ddbuy_common_service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.ddbuy_common_service.service.SerchService;
import com.kgc.ddbuy.mapper.Tb_itemMapper;
import com.kgc.ddbuy.utils.ProductSolr;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component  //暴露服务
@Service(interfaceClass = SerchService.class)
public class SerchServiceImol implements SerchService {

    @Autowired
    private SolrClient solrClient;   //注入solr客户端

    @Autowired(required = false)
    private Tb_itemMapper tb_itemMapper;

    @Override
    public boolean PropertiesImporToSolr() {

        try {

            //1.获取数据库记录

            List<ProductSolr> list = tb_itemMapper.GetAllProductSolr();

            //2.导入到索引库
            //为了实现这个方法 我们做了很多事情
            //SpringBoot整合Solr
            //2.1导入Solr的依赖 spring-boot-start-data-solr
            //2.2 #添加了solr的配置
            //2.3注入Solr客户端对象操作Solr
            this.solrClient.addBeans(list);
            this.solrClient.commit();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }
}
