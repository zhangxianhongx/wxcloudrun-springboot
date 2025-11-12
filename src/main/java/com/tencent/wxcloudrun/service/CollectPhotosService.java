package com.tencent.wxcloudrun.service;

import java.util.List;
import java.util.Optional;

import com.tencent.wxcloudrun.model.CollectPhotos;

public interface CollectPhotosService {
    Optional<List<CollectPhotos>> getCollectPhotos(Integer collectId);
}
