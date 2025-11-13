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
    private String activityImage;
    private String shareTitle;
    private String shareImage;
    private String shareSubTitle;
    private String activityTitle;
    private String activityDetail;
    // 0未上线，1下线，2结束
    private int activityStatus;
    // -1不需要报名，0无限制，>0
    private int limitCount;
}
