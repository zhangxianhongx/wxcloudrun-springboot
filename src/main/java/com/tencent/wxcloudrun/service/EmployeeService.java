package com.tencent.wxcloudrun.service;

import java.util.List;
import java.util.Optional;


import com.tencent.wxcloudrun.model.Employee;

public interface EmployeeService {
    Optional<Employee> getEmployee(Integer id);
    Optional<List<Employee>> getEmployeeList();
    Optional<List<Employee>>getShopEmployeeList(Integer shopId);
    Optional<List<Employee>>getActivityEmployeeList(Integer activityId);

}
