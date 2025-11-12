package com.tencent.wxcloudrun.service;

import java.util.List;
import java.util.Optional;

import com.tencent.wxcloudrun.model.Goods;

public interface GoodsService {
    Optional<List<Goods>> getGoods(Integer shopId);
    Optional<List<Goods>> getUserGoods(Integer userId);
    Optional<Goods> getGoodsInfo(Integer id);
}
