package com.developlee.springbootsolr.domain;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author liululee
 * @desc  CH_ZN : solr 提供索引bean的功能，为了能索引bean, 需要使用@Field注解
 * EN: solr providers APIs to indexing java bean, To index a bean, need to annotate @Field annotations
 * @since 7/4/2019
 **/
public class Item implements Serializable {

    @Field
    private String id;

    @Field
    private String description;

    @Field
    private String category;

    @Field
    private float price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
