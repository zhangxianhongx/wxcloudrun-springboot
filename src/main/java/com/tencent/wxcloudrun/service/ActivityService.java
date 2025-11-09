package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Activity;

import java.util.Optional;

public interface ActivityService {
    Optional<Activity> getActivity(Integer id);
}
