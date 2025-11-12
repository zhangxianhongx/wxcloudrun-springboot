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

import com.tencent.wxcloudrun.model.CollectPhotos;
import com.tencent.wxcloudrun.service.CollectPhotosService;

@Controller
public class CollectPhotoController {
    
    final CollectPhotosService collectPhotosService;
    final Logger logger;
    public CollectPhotoController(@Autowired CollectPhotosService collectPhotosService) {
        this.collectPhotosService = collectPhotosService;
        this.logger = LoggerFactory.getLogger(CollectPhotoController.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/collectPhotos")
    @ResponseBody
    public Map<String,Object> getCollectPhotos(String collectId, HttpServletRequest request) {
        logger.info("/api/getCollectPhotos get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (collectId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Optional<List<CollectPhotos>> collectPhotos = collectPhotosService.getCollectPhotos(Integer.parseInt(collectId));
        if (collectPhotos != null) {
            res.put("data", collectPhotos);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
    
}