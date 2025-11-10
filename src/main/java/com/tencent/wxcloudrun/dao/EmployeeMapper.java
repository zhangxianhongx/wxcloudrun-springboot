package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.Employee;
@Mapper
public interface EmployeeMapper {

  Employee getEmployee(@Param("id") Integer id);
  List<Employee> getEmployeeList();
  List<Employee> getShopEmployeeList(@Param("shopId") Integer shopId);
  List<Employee> getActivityEmployeeList(@Param("activityId") Integer activityId);
} 
