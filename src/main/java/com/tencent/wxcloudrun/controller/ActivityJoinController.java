package com.tencent.wxcloudrun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tencent.wxcloudrun.model.ActivityHelp;
import com.tencent.wxcloudrun.model.ActivityJoin;
import com.tencent.wxcloudrun.service.ActivityHelpService;
import com.tencent.wxcloudrun.service.ActivityJoinService;
@Controller
public class ActivityJoinController {
 final ActivityJoinService joinService;
    final Logger logger;

    public ActivityJoinController(@Autowired ActivityJoinService aService) {
        this.joinService = aService;
        this.logger = LoggerFactory.getLogger(ActivityJoinController.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/joinInfo")
    @ResponseBody
    public Map<String,Object> getHelpInfo(String activityId, HttpServletRequest request) {
        logger.info("/api/joinInfo");
        Map<String, Object> res = new HashMap<String, Object>();
        String openid = request.getHeader("openid");
        if (openid == null || activityId == null) {
            res.put("code", "-1");
            res.put("msg", "请求失败");
            return res;
        }
        Optional<ActivityJoin> help = joinService.getJoinInfoWithOpenidActivityId(openid, activityId);
        res.put("data", help);
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
     /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/activityJoinList")
    @ResponseBody
    public Map<String,Object> activityJoinList(String activityId, HttpServletRequest request) {
        logger.info("/api/getHelpList");
        Map<String, Object> res = new HashMap<String, Object>();
        if (activityId == null) {
            res.put("code", "-1");
            res.put("msg", "请求失败");
            return res;
        }
        
        Optional<List<ActivityJoin>> list = joinService.getJoinList(Integer.parseInt(activityId));
        if (list != null) {
            res.put("data", list);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
    @PostMapping("/api/addJoin")
    @ResponseBody
    public Map<String,Object> addJoin(String activityId, HttpServletRequest request) {
        logger.info("/api/getHelpList");
        Map<String, Object> res = new HashMap<String, Object>();
        if (activityId == null) {
            res.put("code", "-1");
            res.put("msg", "请求失败");
            return res;
        }

        String openid = request.getHeader("openid");
        if (openid == null) {
            res.put("code", "-1");
            res.put("msg", "请求失败");
            return res;
        }
        Optional<ActivityJoin> historyData = joinService.getJoinInfoWithOpenidActivityId(openid, activityId);
        if (historyData != null) {
            res.put("code", "0");
            res.put("msg", "请求成功");
            res.put("data", historyData);
            return res;
        }

        ActivityJoin join = new ActivityJoin();
        join.setActivityId(Integer.parseInt(activityId));
        join.setPhone("");
        join.setOpenid(openid);
        joinService.insertJoin(join);
        historyData = joinService.getJoinInfoWithOpenidActivityId(openid, activityId);
        res.put("data", historyData);
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
