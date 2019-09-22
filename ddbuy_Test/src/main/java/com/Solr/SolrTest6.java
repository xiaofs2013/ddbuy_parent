package com.Solr;

import com.Solr.pojo.Student;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.List;

public class SolrTest6 {
       //注意 本章节排序巨尼玛重要

    //实现查询功能
    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solr操作数据库的步骤
        //1.创建solr服务器对象
        String solrUrl = "http://localhost:8080/solr/";

        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core")
                .withConnectionTimeout(10000) //连接超时
                .withSocketTimeout(60000).build();  //连接的时间

        //2.执行查询
        //3.创建查询的参数对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.set("q", "name:*");   //语法有点特别  q只是页面上的标字符 *:*是查所有的key与value
        //你也可以写成这样的 query.set("q","name:*");



        //设置
        query.setStart((1 - 1) * 3);  //设置起始位置  （页码-1）*页大小   (setStart-1)*setRows
        query.setRows(3); //设置每页大小

        //4.执行查询  使用查询响应QueryResponse
        QueryResponse queryRequest = httpSolrClient.query(query);

        //排序
        query.setSort("age", SolrQuery.ORDER.desc); //设置排序 降序是desc  升序是ase


        //直接使用List加实体类来获取查询结果
        List<Student> list = queryRequest.getBeans(Student.class);

        //这里有一个地方巨尼玛的坑 在managed-schema文件里面 xh的类型是plong  一定要改成pint才行 因为实体的类型是Integer
        for (Student student : list) {
            System.out.println("学号" + student.getXh() + " " + "姓名" + student.getName() + " " + "年龄" + student.getAge()
                    + " " + "性别" + student.getSex()
            );
        }





/*

           //5.使用标准的比较笨重的方法获取查询结果
        SolrDocumentList list = queryRequest.getResults();  //使用DocumentList接收查询的结果

        //使用迭代器迭代遍历出来
        Iterator<SolrDocument> iterator = list.iterator();

        while (iterator.hasNext()) {
            SolrDocument document = iterator.next();
            System.out.println(document.get("name"));  //获取所有的name域的值
        }
*/

    }

}
