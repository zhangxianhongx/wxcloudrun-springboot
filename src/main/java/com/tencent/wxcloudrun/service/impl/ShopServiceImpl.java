package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tencent.wxcloudrun.dao.ShopMapper;
import com.tencent.wxcloudrun.model.Shop;
import com.tencent.wxcloudrun.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
    final ShopMapper shopMapper;

    public ShopServiceImpl(@Autowired ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    } 
    @Override
    public Optional<Shop> getShop(Integer id) {
        return Optional.ofNullable(this.shopMapper.getShop(id)); 
    }

    @Override
    public Optional<List<Shop>> getShopList() {
        return Optional.ofNullable(this.shopMapper.getShopList());
    }
    
}
