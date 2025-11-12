package com.tencent.wxcloudrun.service;

import java.util.List;
import java.util.Optional;

import com.tencent.wxcloudrun.model.Collect;

public interface CollectService {
    Optional<List<Collect>> getShopCollect(Integer shopId);
    Optional<List<Collect>> getUserCollect(Integer userId);
}
