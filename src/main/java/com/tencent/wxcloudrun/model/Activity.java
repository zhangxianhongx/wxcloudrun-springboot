package com.tencent.wxcloudrun.model;



import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Activity implements Serializable {
    private Integer id;
    private String descs;
    private String source;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer shopId;
    private String activityExplain;
    private String activityImages;
    private String shareTitle;
    private String shareImage;
    private String shareSubTitle;
    private String activityTitle;
    private String activityDetail;
    private int activityStatus;
    private int limitCount;
}
