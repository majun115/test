package com.majun.springMVC.pojo;

import java.util.Date;

public class Items {
    private Integer id;
    private String name;
    private Float price;
    private String detail;
    private Date createtime;

    public Items() {
    }

    public Items(Integer id, String name, Float price, String detail, Date createtime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
