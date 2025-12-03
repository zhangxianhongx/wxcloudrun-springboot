package com.tencent.wxcloudrun.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ActivityHelp implements Serializable{
    private Integer id;
    private Integer activityId;
    private String helpedOpenid;
    private String openid;
    private String creatTime;
}
