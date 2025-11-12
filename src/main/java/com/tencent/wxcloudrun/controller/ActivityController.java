package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ActivityRequest;
import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ActivityController {
    final ActivityService activityService;
    final Logger logger;

    public ActivityController(@Autowired ActivityService activityService) {
        this.activityService = activityService;
        this.logger = LoggerFactory.getLogger(ActivityController.class);
    }
    /**
     * 获取活动详情
     * @return API response json
     */
  
    @PostMapping("/api/activityInfo")
    @ResponseBody
    public Map<String,Object> getActivityInfo(String activityId, HttpServletRequest request) {
        logger.info("/api/getActivityInfo get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (activityId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Integer id = Integer.parseInt(activityId);
        logger.info("activityId " + id);
        Optional<Activity> activity = activityService.getActivity(id);
        if (activity != null) {
            res.put("data", activity);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
