package com.tencent.wxcloudrun.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.Shop;
@Mapper
public interface ShopMapper {
    Shop getShop(@Param("id") Integer id);
    List<Shop> getShopList();
}
