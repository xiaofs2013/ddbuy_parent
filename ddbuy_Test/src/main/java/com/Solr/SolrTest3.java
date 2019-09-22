package com.Solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

public class SolrTest3 {
    //修改索引
    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solr操作索引库的步骤
        //1.创建sorl服务器的对象


        String solrUrl = "http://localhost:8080/solr/";


        //通过代码创建了一个Solr客户端 并输入Sorl的url与核心库的名称
        // HttpSolrClient solr = new HttpSolrClient.Builder 就代表着我们的solr服务器
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core")
                .withConnectionTimeout(10000) //连接超时
                .withSocketTimeout(60000).build();  //连接的时间

        //2.修改索引   实际思路：其实就是先原来的索引  再添加索引

        httpSolrClient.deleteByQuery("xh:106");

        SolrInputDocument document = new SolrInputDocument();
        // document.addField("域的名称", "域的值");
        document.addField("xh", 106);
        document.addField("name", "小肖发呀！冲呀！顺风呀！");
        document.addField("age", 22);
        document.addField("sex", "男");

        httpSolrClient.add(document);


        //提交
        httpSolrClient.commit();

        System.out.println("修改成功！！！");



    }
}
