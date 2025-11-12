package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tencent.wxcloudrun.dao.CollectPhotosMapper;
import com.tencent.wxcloudrun.model.CollectPhotos;
import com.tencent.wxcloudrun.service.CollectPhotosService;

@Service
public class CollectPhotosServiceImpl implements CollectPhotosService {
    final CollectPhotosMapper collectPhotosMapper;
    public CollectPhotosServiceImpl(@Autowired CollectPhotosMapper collectPhotosMapper) {
        this.collectPhotosMapper = collectPhotosMapper;
    }
    @Override
    public Optional<List<CollectPhotos>> getCollectPhotos(Integer collectId) {
        return Optional.ofNullable(this.collectPhotosMapper.getCollectPhotos(collectId));
    }

}
