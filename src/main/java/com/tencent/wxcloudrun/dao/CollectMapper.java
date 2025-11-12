package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.Collect;

@Mapper
public interface CollectMapper {
    List<Collect> getShopCollect(@Param("shopId") Integer shopId);
    List<Collect> getUserCollect(@Param("userId") Integer userId);
}
