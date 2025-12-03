package com.tencent.wxcloudrun.service;

import java.util.List;

import com.tencent.wxcloudrun.model.ActivityHelp;

import java.util.Optional;

public interface ActivityHelpService {
    Optional<ActivityHelp> getHelpInfo(Integer id);
    Optional<List<ActivityHelp>> getHelpInfoWithOpenid(String openid);
    Optional<List<ActivityHelp>> getHelpedList(String helpedId, String activityId);
    Optional<ActivityHelp> getHelpInfoWithOpenidActivityId(String openid, String activityId);
    Optional<List<ActivityHelp>> getHelpList(Integer activityId);
    void insertHelp(ActivityHelp help);
}
