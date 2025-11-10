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

import com.tencent.wxcloudrun.model.Shop;
import com.tencent.wxcloudrun.service.ShopService;

@Controller
public class ShopController {
    final ShopService shopService;
    final Logger logger;

    public ShopController(@Autowired ShopService shopService) {
        this.shopService = shopService;
        this.logger = LoggerFactory.getLogger(ShopController.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/shopInfo")
    @ResponseBody
    public Map<String,Object> getShopInfo(String shopId, HttpServletRequest request) {
        logger.info("/api/getShopInfo get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (shopId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Integer id = Integer.parseInt(shopId);
        logger.info("shopId " + id);
        Optional<Shop> shop = shopService.getShop(id);
        if (shop != null) {
            res.put("data", shop);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
     /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/shopList")
    @ResponseBody
    public Map<String,Object> getShopList( HttpServletRequest request) {
        logger.info("/api/getShopList get request");
        Map<String, Object> res = new HashMap<String, Object>();
        Optional<List<Shop>> shops = shopService.getShopList();
        if (shops != null) {
            res.put("data", shops);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
