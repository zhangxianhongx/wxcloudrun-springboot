package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tencent.wxcloudrun.dao.ActivityHelpMapper;

import com.tencent.wxcloudrun.model.ActivityHelp;
import com.tencent.wxcloudrun.service.ActivityHelpService;
@Service
public class ActivityHelpServiceImpl implements ActivityHelpService {
    final ActivityHelpMapper dMapper;

    public ActivityHelpServiceImpl(@Autowired ActivityHelpMapper dMapper) {
        this.dMapper = dMapper;
    }
    @Override
    public Optional<ActivityHelp> getHelpInfo(Integer id) {

        return Optional.ofNullable(this.dMapper.getHelpInfo(id));
    }

    @Override
    public Optional<List<ActivityHelp>> getHelpList(Integer activityId) {
        return Optional.ofNullable(this.dMapper.getHelpList(activityId));
    }

    @Override
    public void insertHelp(ActivityHelp help) {
        this.dMapper.insertHelp(help);
    }
    @Override
    public Optional<List<ActivityHelp>> getHelpInfoWithOpenid(String openid) {
        return Optional.ofNullable(this.dMapper.getHelpInfoWithOpenid(openid));
    }
    @Override
    public Optional<ActivityHelp> getHelpInfoWithOpenidActivityId(String openid, String activityId) {
        return Optional.ofNullable(this.dMapper.getHelpInfoWithOpenidActivityId(openid, activityId));
    }
    @Override
    public Optional<List<ActivityHelp>> getHelpedList(String helpedId, String activityId) {
         return Optional.ofNullable(this.dMapper.getHelpedList(helpedId, activityId));
    }

}
