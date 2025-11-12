package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tencent.wxcloudrun.dao.GoodsMapper;
import com.tencent.wxcloudrun.model.Goods;
import com.tencent.wxcloudrun.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
    final GoodsMapper goodsMapper;
    public GoodsServiceImpl(@Autowired GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    } 
    @Override
    public Optional<List<Goods>> getGoods(Integer shopId) {
        return Optional.ofNullable(this.goodsMapper.getGoods(shopId));
    }

    @Override
    public Optional<Goods> getGoodsInfo(Integer id) {
        return Optional.ofNullable(this.goodsMapper.getGoodsInfo(id));
    }
    @Override
    public Optional<List<Goods>> getUserGoods(Integer userId) {
        return Optional.ofNullable(this.goodsMapper.getUserGoods(userId));
    }

}
