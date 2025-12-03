package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.ActivityJoin;
@Mapper
public interface ActivityJoinMapper {
    ActivityJoin getJoinInfo(@Param("id") Integer id);
    List<ActivityJoin> getJoinInfoWithOpenid(@Param("openid") String openid);
    ActivityJoin getJoinInfoWithOpenidActivityId(@Param("openid") String openid, @Param("activityId") String activityId);

    List<ActivityJoin> getJoinList(@Param("activityId") Integer activityId);
    void insertJoin(ActivityJoin join);
}
