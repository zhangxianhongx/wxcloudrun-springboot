package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tencent.wxcloudrun.dao.ActivityJoinMapper;
import com.tencent.wxcloudrun.model.ActivityJoin;
import com.tencent.wxcloudrun.service.ActivityJoinService;
@Service
public class ActivityJoinServiceImpl implements ActivityJoinService {
    final ActivityJoinMapper dMapper;

    public ActivityJoinServiceImpl(@Autowired ActivityJoinMapper dMapper) {
        this.dMapper = dMapper;
    }
    @Override
    public Optional<ActivityJoin> getJoinInfo(Integer id) {
        return Optional.ofNullable(this.dMapper.getJoinInfo(id));
    }

    @Override
    public Optional<List<ActivityJoin>> getJoinList(Integer activityId) {
        return Optional.ofNullable(this.dMapper.getJoinList(activityId));
    }

    @Override
    public void insertJoin(ActivityJoin join) {
        this.dMapper.insertJoin(join);
    }
    @Override
    public Optional<List<ActivityJoin>> getJoinInfoWithOpenid(String openid) {
        return Optional.ofNullable(this.dMapper.getHelpInfoWithOpenid(openid));
    }
    @Override
    public Optional<ActivityJoin> getJoinInfoWithOpenidActivityId(String openid, String activityId) {
        return Optional.ofNullable(this.dMapper.getHelpInfoWithOpenidActivityId(openid, activityId));
    }

}
