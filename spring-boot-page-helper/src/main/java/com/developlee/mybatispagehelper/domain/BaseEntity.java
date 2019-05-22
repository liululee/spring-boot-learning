package com.developlee.mybatispagehelper.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/17 13:48
 */
public abstract class BaseEntity implements Serializable {
    private final Long serialVersion = -123142L;

    //分页大小
    @JSONField(serialize = false)
    private Integer pageSize;
    //分页开始
    private Integer pageNum;

    private Integer total;

    //排序类型DESC  or  AES
    private String sort;

    private String orderBy;

    @JSONField(serialize = false)
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JSONField(serialize = false)
    public Integer getPageNum() {
        return pageNum;
    }


    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }


    public Integer getTotal() {
        return total;
    }

    @JSONField(serialize = false)
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JSONField(serialize = false)
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @JSONField(serialize = false)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}