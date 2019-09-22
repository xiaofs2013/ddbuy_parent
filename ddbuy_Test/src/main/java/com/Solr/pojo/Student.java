package com.Solr.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

//学生类
public class Student implements Serializable {

    //一个solr域对应一个属性

    //这里有一点需要注意 Solr不知道这些属性对应你域里面的那些索引 所以你必须要先指定一下
    //必须要在pojo实体类里面 用@Field注解定义一个solr一个属性
    //添加完毕注解后 只要属性名和域名相同即可匹配 如果域名和属性不一样 必须要通过@Field(value = "xh") 来指定

    //@Field(value = "xh")

    @Field(value = "xh")
    private Integer xh;
    @Field(value = "name")
    private String name;
    @Field(value = "age")
    private Integer age;
    @Field(value = "sex")
    private String sex;

    public Student() {
    }


    public Student(Integer xh, String name, Integer age, String sex) {
        this.xh = xh;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
