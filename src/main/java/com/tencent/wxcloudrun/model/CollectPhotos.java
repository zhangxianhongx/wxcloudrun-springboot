package com.tencent.wxcloudrun.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class CollectPhotos implements Serializable {
    private Integer id;
    private String name;
    private int status;
    private Integer collectId;
    private String url;
    private String videoUrl;
    private int type;
    private int sort;
}
