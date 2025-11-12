package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tencent.wxcloudrun.dao.CollectMapper;
import com.tencent.wxcloudrun.model.Collect;
import com.tencent.wxcloudrun.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService {
    final CollectMapper collectMapper;
    public CollectServiceImpl(@Autowired CollectMapper collectMapper) {
        this.collectMapper = collectMapper;
    }

    @Override
    public Optional<List<Collect>> getShopCollect(Integer shopId) {
        return Optional.ofNullable(this.collectMapper.getShopCollect(shopId));
    }

    @Override
    public Optional<List<Collect>> getUserCollect(Integer userId) {
        return Optional.ofNullable(this.collectMapper.getUserCollect(userId));
    }

}
