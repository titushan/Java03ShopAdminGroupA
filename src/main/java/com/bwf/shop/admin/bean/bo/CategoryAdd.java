package com.bwf.shop.admin.bean.bo;

import java.util.Date;


public class CategoryAdd {
    private Integer id;
    private String cate_name;
    private Integer cate_sort;
    private Date createtime;
    private Date updatetime;
    private Integer parent_id;
    private Integer[] brand_id;

    public Integer[] getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer[] brand_id) {
        this.brand_id = brand_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Integer getCate_sort() {
        return cate_sort;
    }

    public void setCate_sort(Integer cate_sort) {
        this.cate_sort = cate_sort;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }


}
