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
public class ActivityHelpController {
    final ActivityHelpService helpService;
    final ActivityJoinService joinService;
    final Logger logger;

    public ActivityHelpController(@Autowired ActivityHelpService aService, @Autowired ActivityJoinService bService) {
        this.helpService = aService;
        this.joinService = bService;
        this.logger = LoggerFactory.getLogger(ActivityHelpService.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/helpInfo")
    @ResponseBody
    public Map<String,Object> getHelpInfo(String activityId, HttpServletRequest request) {
        logger.info("/api/getHelpInfo");
        Map<String, Object> res = new HashMap<String, Object>();
        String openid = request.getHeader("openid");
        if (openid == null || activityId == null) {
            res.put("code", "-1");
            res.put("msg", "请求失败");
            return res;
        }
       
        Optional<ActivityHelp> help = helpService.getHelpInfoWithOpenidActivityId(openid, activityId);
        res.put("data", help);
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
     /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/helpList")
    @ResponseBody
    public Map<String,Object> getHelpList(String activityId, HttpServletRequest request) {
        logger.info("/api/getHelpList");
        Map<String, Object> res = new HashMap<String, Object>();
        if (activityId == null) {
            res.put("code", "-1");
            res.put("msg", "请求失败");
            return res;
        }
        
        Optional<List<ActivityHelp>> list = helpService.getHelpList(Integer.parseInt(activityId));
        if (list != null) {
            res.put("data", list);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
    @PostMapping("/api/addHelp")
    @ResponseBody
    public Map<String,Object> addhelp(String activityId, String activityJoinid, HttpServletRequest request) {
        logger.info("/api/getHelpList");
        Map<String, Object> res = new HashMap<String, Object>();
        if (activityId == null || activityJoinid == null) {
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
        Optional<ActivityJoin> join = joinService.getJoinInfo(Integer.parseInt(activityJoinid));
        if (join == null) {
            res.put("code", "-1");
            res.put("msg", "助力失败，被助力信息不存在");
            return res;
        }
       
        ActivityHelp help = new ActivityHelp();
        help.setActivityId(Integer.parseInt(activityId));
        help.setHelpedOpenid(join.get().getOpenid());
        help.setOpenid(openid);
        helpService.insertHelp(help);
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
