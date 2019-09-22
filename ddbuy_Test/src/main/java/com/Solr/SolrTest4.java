package com.Solr;

import com.Solr.pojo.Student;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;

public class SolrTest4 {

    public static void main(String[] args) throws IOException, SolrServerException {
        //以JAVA对象的方式来添加索引
        //1.创建solr对象

        String solrUrl = "http://localhost:8080/solr/";

        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core")
                .withConnectionTimeout(10000) //连接超时
                .withSocketTimeout(60000).build();  //连接的时间

        Student student = new Student(107, "小张", 21, "男");
        //这里有一点需要注意 Solr不知道这些属性对应你域里面的那些索引 所以你必须要先指定一下
        //必须要在pojo实体类里面 用@Field注解定义一个solr一个属性
        //添加完毕注解后 只要属性名和域名相同即可匹配 如果域名和属性不一样 必须要通过@Field(value = "xh") 来指定



        httpSolrClient.addBean(student);

        httpSolrClient.commit();
        System.out.println("添加成功！");

    }


}
