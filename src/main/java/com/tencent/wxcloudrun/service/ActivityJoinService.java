package com.tencent.wxcloudrun.service;

import java.util.List;


import com.tencent.wxcloudrun.model.ActivityJoin;
import java.util.Optional;


public interface ActivityJoinService {
    Optional<ActivityJoin> getJoinInfo(Integer id);
    Optional<List<ActivityJoin>> getJoinInfoWithOpenid(String openid);
    Optional<ActivityJoin> getJoinInfoWithOpenidActivityId(String openid, String activityId);
    Optional<List<ActivityJoin>> getJoinList(Integer activityId);
    void insertJoin(ActivityJoin join);
}
