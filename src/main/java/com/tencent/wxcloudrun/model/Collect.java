package com.tencent.wxcloudrun.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class Collect implements Serializable {
    private Integer id;
    private String name;
    private String icon;
    private Integer shopId;
    private Integer userId;
    private int sort;
    private int status;
}
