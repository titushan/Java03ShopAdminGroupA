package com.bwf.shop.admin.bean.bo;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class BrandUpdate {
    private Integer id;
    private String brand_name;
    private String brand_introduction;
    private String brand_logourl;
    private MultipartFile brand_logourl_img;  //上传图片 在temp临时文件下
    private Integer sortno;
    private Date createtime;
    private Date updatetime;
    private Integer category_id;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_introduction() {
        return brand_introduction;
    }

    public void setBrand_introduction(String brand_introduction) {
        this.brand_introduction = brand_introduction;
    }

    public String getBrand_logourl() {
        return brand_logourl;
    }

    public void setBrand_logourl(String brand_logourl) {
        this.brand_logourl = brand_logourl;
    }

    public MultipartFile getBrand_logourl_img() {
        return brand_logourl_img;
    }

    public void setBrand_logourl_img(MultipartFile brand_logourl_img) {
        this.brand_logourl_img = brand_logourl_img;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }


}
