package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tencent.wxcloudrun.dao.GoodsSkuMapper;
import com.tencent.wxcloudrun.model.GoodsSku;
import com.tencent.wxcloudrun.service.GoodsSkuService;

@Service
public class GoodsSkuServiceImpl implements GoodsSkuService {
    final GoodsSkuMapper goodsSkuMapper;
    public GoodsSkuServiceImpl(@Autowired GoodsSkuMapper goodsSkuMapper) {
        this.goodsSkuMapper = goodsSkuMapper;
    } 
    @Override
    public Optional<List<GoodsSku>> getGoodsSku(Integer goodsId) {
        return Optional.ofNullable(this.goodsSkuMapper.getGoodsSku(goodsId));
    }

    
}
