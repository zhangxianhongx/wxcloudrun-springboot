package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.CollectPhotos;

@Mapper
public interface CollectPhotosMapper {
    List<CollectPhotos> getCollectPhotos(@Param("collectId") Integer collectId);
}
