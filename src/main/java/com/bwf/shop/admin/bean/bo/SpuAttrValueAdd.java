package com.bwf.shop.admin.bean.bo;

import java.util.Date;

public class SpuAttrValueAdd {
    private Integer id;
    private String value_name;
    private Date createtime;
    private Date updatetime;
    private Integer value_attr_key_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
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

    public Integer getValue_attr_key_id() {
        return value_attr_key_id;
    }

    public void setValue_attr_key_id(Integer value_attr_key_id) {
        this.value_attr_key_id = value_attr_key_id;
    }
}
