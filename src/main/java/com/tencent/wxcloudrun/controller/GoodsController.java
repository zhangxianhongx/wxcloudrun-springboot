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

import com.tencent.wxcloudrun.model.Goods;
import com.tencent.wxcloudrun.service.GoodsService;

@Controller
public class GoodsController {
    final GoodsService goodsService;
    final Logger logger;
    public GoodsController(@Autowired GoodsService goodsService) {
        this.goodsService = goodsService;
        this.logger = LoggerFactory.getLogger(GoodsController.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/goods")
    @ResponseBody
    public Map<String,Object> getGoods(String shopId, HttpServletRequest request) {
        logger.info("/api/getGoods get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (shopId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Optional<List<Goods>> goods = goodsService.getGoods(Integer.parseInt(shopId));
        if (goods != null) {
            res.put("data", goods);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/userGoods")
    @ResponseBody
    public Map<String,Object> getUserGoods(String userId, HttpServletRequest request) {
        logger.info("/api/getUserGoods get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (userId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Optional<List<Goods>> goods = goodsService.getUserGoods(Integer.parseInt(userId));
        if (goods != null) {
            res.put("data", goods);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/goodsInfo")
    @ResponseBody
    public Map<String,Object> getGoodsInfo(String id, HttpServletRequest request) {
        logger.info("/api/getGoodsInfo get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (id == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Optional<Goods> goods = goodsService.getGoodsInfo(Integer.parseInt(id));
        if (goods != null) {
            res.put("data", goods);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
