package com.tencent.wxcloudrun.controller;

import java.util.Collection;
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

import com.tencent.wxcloudrun.model.Collect;
import com.tencent.wxcloudrun.service.CollectService;

@Controller
public class CollectController {
    final CollectService collectService;
    final Logger logger;
    public CollectController(@Autowired CollectService collectService) {
        this.collectService = collectService;
        this.logger = LoggerFactory.getLogger(CollectController.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/shopCollectList")
    @ResponseBody
    public Map<String,Object> getShopCollectList(String shopId, HttpServletRequest request) {
        logger.info("/api/getShopCollectList get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (shopId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Optional<List<Collect>> collects = collectService.getShopCollect(Integer.parseInt(shopId));
        if (collects != null) {
            res.put("data", collects);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/userCollectList")
    @ResponseBody
    public Map<String,Object> getUserCollectList(String userId, HttpServletRequest request) {
        logger.info("/api/getShopCollectList get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (userId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Optional<List<Collect>> collects = collectService.getUserCollect(Integer.parseInt(userId));
        if (collects != null) {
            res.put("data", collects);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
