package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ActivityMapper;
import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.service.ActivityService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
    final ActivityMapper activityMapper;

    public ActivityServiceImpl(@Autowired ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public Optional<Activity> getActivity(Integer id) {
        return Optional.ofNullable(this.activityMapper.getActivity(id));
    }
}
