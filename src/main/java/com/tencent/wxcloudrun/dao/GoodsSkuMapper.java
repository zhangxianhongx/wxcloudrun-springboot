package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.GoodsSku;

@Mapper
public interface GoodsSkuMapper {
    List<GoodsSku> getGoodsSku(@Param("goodsId") Integer goodsId);
}
