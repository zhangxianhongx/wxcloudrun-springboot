package com.tencent.wxcloudrun.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class GoodsSku implements Serializable {
    private Integer id;
    private String name;
    private int count;
    private float price;
    private int sort;
    private int status;
    private Integer goodsId;
    private String descs;
}
