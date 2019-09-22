package com.Solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

public class SolrTest {
    public static void main(String[] args) throws IOException, SolrServerException {

        //整个Solr就是提供一个API供我调动

        //使用solrJ操作索引库的步骤   （首先需要导入依赖）
        //1.添加操作
        //地址的解析为 前面加一段sorlr的地址 后面再加一个你要操作的核心库就行了
        //访问solr主页的地址是：http://localhost:8080/solr/index.html#/  变动只是后面的访问地点
        String solrUrl = "http://localhost:8080/solr/";


        //通过代码创建了一个Solr客户端 并输入Sorl的url与核心库的名称
        // HttpSolrClient solr = new HttpSolrClient.Builder 就代表着我们的solr服务器
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core")
                .withConnectionTimeout(10000) //连接超时
                .withSocketTimeout(60000).build();  //连接的时间


        //使用客户端对象的操作方法
        //关于添加 有三个方法  一个add  一个addBean  一个addBeans
        //add 添加单独的一行数据  手写
        //addBean可以用JAVA实体作为对象 来添加
        //addBeans 可以用集合来批量添加

        //首先需要创建SolrInputDocument对象  （也就是一行数据）
        SolrInputDocument document = new SolrInputDocument();
        // document.addField("域的名称", "域的值");
        document.addField("xh", 111);
        document.addField("name", "测试");
        document.addField("age", 22);
        document.addField("sex", "男");

        httpSolrClient.add(document);


        httpSolrClient.commit();

        System.out.println("添加成功！！！");


    }
}
