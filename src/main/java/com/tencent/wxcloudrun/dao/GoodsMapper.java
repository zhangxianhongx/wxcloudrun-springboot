package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.Goods;

@Mapper
public interface GoodsMapper {
    List<Goods> getGoods(@Param("shopId") Integer shopId);
    List<Goods> getUserGoods(@Param("userId") Integer userId);
    Goods getGoodsInfo(@Param("id") Integer id);
}