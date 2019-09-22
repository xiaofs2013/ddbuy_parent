package com.Solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;

public class SolrTest2 {
    //删除索引

    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solr操作索引库的步骤
        //1.创建solr服务器对象
        String solrUrl = "http://localhost:8080/solr/";


        //通过代码创建了一个Solr客户端 并输入Sorl的url与核心库的名称
        // HttpSolrClient solr = new HttpSolrClient.Builder 就代表着我们的solr服务器
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core")
                .withConnectionTimeout(10000) //连接超时
                .withSocketTimeout(60000).build();  //连接的时间

        //2.删除索引   键+值
        httpSolrClient.deleteByQuery("xh:106");

        //提交
        httpSolrClient.commit();
        System.out.println("删除成功！！！");

    }

}
