package com.tencent.wxcloudrun.service;

import java.util.List;
import java.util.Optional;

import com.tencent.wxcloudrun.model.Shop;

public interface ShopService {
    Optional<Shop> getShop(Integer id);
    Optional<List<Shop>> getShopList();
}
