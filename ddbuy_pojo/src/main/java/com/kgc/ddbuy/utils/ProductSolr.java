package com.kgc.ddbuy.utils;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class ProductSolr implements Serializable {

    @Field(value = "pid")
    private Long pid;

    @Field(value = "title")
    private String title;

    @Field(value = "price")
    private Long price;

    @Field(value = "image")
    private String image;


    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
