package com.bwf.shop.admin.bean.bo;

import java.util.Date;

public class SpuAttrKeySearch {

        private Integer id;
        private String key_name;
        private Date createtime;
        private Date updatetime;
        private Integer start=0;
        private Integer length=10;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getKey_name() {
            return key_name;
        }

        public void setKey_name(String key_name) {
            this.key_name = key_name;
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


}
