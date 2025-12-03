package com.tencent.wxcloudrun.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class ActivityJoin implements Serializable {
    private Integer id;
    private Integer activityId;
    private String phone;
    private String openid;
    private String creatTime;
}
