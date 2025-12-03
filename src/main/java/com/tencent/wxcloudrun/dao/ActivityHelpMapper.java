package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.ActivityHelp;

@Mapper
public interface ActivityHelpMapper {
    ActivityHelp getHelpInfo(@Param("id") Integer id);
    List<ActivityHelp> getHelpInfoWithOpenid(@Param("openid") String openid);
    ActivityHelp getHelpInfoWithOpenidActivityId(@Param("openid") String openid, @Param("activityId") String activityId);
    List<ActivityHelp> getHelpList(@Param("activityId") Integer activityId);
    void insertHelp(ActivityHelp help);
}
