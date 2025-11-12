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

import com.tencent.wxcloudrun.model.GoodsSku;
import com.tencent.wxcloudrun.service.GoodsSkuService;
@Controller
public class GoodsSkuController {
    final GoodsSkuService goodsSkuService;
    final Logger logger;
    public GoodsSkuController(@Autowired GoodsSkuService goodsSkuService) {
        this.goodsSkuService = goodsSkuService;
        this.logger = LoggerFactory.getLogger(GoodsSkuController.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/goodsSku")
    @ResponseBody
    public Map<String,Object> getGoodsSku(String goodsId, HttpServletRequest request) {
        logger.info("/api/getGoodsSku get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (goodsId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Optional<List<GoodsSku>> goodsSkus = goodsSkuService.getGoodsSku(Integer.parseInt(goodsId));
        if (goodsSkus != null) {
            res.put("data", goodsSkus);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
