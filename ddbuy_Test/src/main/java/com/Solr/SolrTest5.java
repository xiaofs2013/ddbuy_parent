package com.Solr;

import com.Solr.pojo.Student;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SolrTest5 {

    //以JAVA对象的方式批量添加索引  集合
    public static void main(String[] args) throws IOException, SolrServerException {


        String solrUrl = "http://localhost:8080/solr/";

        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core")
                .withConnectionTimeout(10000) //连接超时
                .withSocketTimeout(60000).build();  //连接的时间

        List<Student> list = new ArrayList<>();
        list.add(new Student(108, "小明", 21, "男"));
        list.add(new Student(109, "小强", 22, "男"));
        list.add(new Student(110, "小刚", 23, "男"));


        httpSolrClient.addBeans(list);

        //提交
        httpSolrClient.commit();
        System.out.println("批量添加成功！！");
    }

}
