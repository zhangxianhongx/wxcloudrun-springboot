package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ActivityRequest;
import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ActivityController {
    final ActivityService activityService;
    final Logger logger;

    public ActivityController(@Autowired ActivityService activityService) {
        this.activityService = activityService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }
    /**
     * 获取当前计数
     * @return API response json
     */
    @GetMapping(value = "/api/activity")
    ApiResponse get(@RequestBody ActivityRequest request) {
        logger.info("/api/count get request");
        Optional<Activity> activity = activityService.getActivity(Math.toIntExact(request.getActivityId()));

        return ApiResponse.ok(activity);
    }
}
