package com.tencent.wxcloudrun.service;

import java.util.List;
import java.util.Optional;

import com.tencent.wxcloudrun.model.GoodsSku;

public interface GoodsSkuService {
    Optional<List<GoodsSku>> getGoodsSku(Integer goodsId);
}
