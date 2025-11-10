package com.tencent.wxcloudrun.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tencent.wxcloudrun.dao.EmployeeMapper;
import com.tencent.wxcloudrun.model.Employee;
import com.tencent.wxcloudrun.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(@Autowired EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    } 
    @Override
    public Optional<Employee> getEmployee(Integer id) {
        return Optional.ofNullable(this.employeeMapper.getEmployee(id));
    }

    @Override
    public Optional<List<Employee>> getEmployeeList() {
        return Optional.ofNullable(this.employeeMapper.getEmployeeList());
    }
    @Override
    public Optional<List<Employee>> getShopEmployeeList(Integer shopId) {
        return Optional.ofNullable(this.employeeMapper.getShopEmployeeList(shopId));
    }
    @Override
    public Optional<List<Employee>> getActivityEmployeeList(Integer activityId) {
        return Optional.ofNullable(this.employeeMapper.getActivityEmployeeList(activityId));
    }
    
}
