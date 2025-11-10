package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class Shop {
    public Integer id;
    public String name;
    public String logo;
    public String descs;
    public String city;
    public String address;
    public String lat;
    public String lng;
    public String phoneNum;
    public String wxNum;
    public String photos;
    public int status;
    public int sort;
}
