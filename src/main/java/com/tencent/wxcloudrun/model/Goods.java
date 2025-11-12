package com.tencent.wxcloudrun.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private float price;
    private String descs;
    private String cover;
    private int status;
    private int count;
    private int sort;
    private String images;
    private Integer shopId;
    private Integer userId;
    private String details;
}
