package com.tencent.wxcloudrun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tencent.wxcloudrun.model.Employee;
import com.tencent.wxcloudrun.service.EmployeeService;

@Controller
public class EmployeeController {
    final EmployeeService employeeService;
    final Logger logger;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.logger = LoggerFactory.getLogger(EmployeeController.class);
    }
    /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/employeeInfo")
    @ResponseBody
    public Map<String,Object> getEmployeeInfo(String employeeId, HttpServletRequest request) {
        logger.info("/api/employeeInfo get request");
        Map<String, Object> res = new HashMap<String, Object>();
        if (employeeId == null) {
            res.put("code", "-1");
            res.put("msg", "参数缺失");
            return res;
        }
        Integer id = Integer.parseInt(employeeId);
        logger.info("employeeId " + id);
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee != null) {
            res.put("data", employee);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
     /**
     * 
     * @return API response json
     */
  
    @PostMapping("/api/employeeList")
    @ResponseBody
    public Map<String,Object> getEmployeeList( HttpServletRequest request) {
        logger.info("/api/getEmployeeList get request");
        Map<String, Object> res = new HashMap<String, Object>();
        Optional<List<Employee>> employees = employeeService.getEmployeeList();
        if (employees != null) {
            res.put("data", employees);
        }
        res.put("code", "0");
        res.put("msg", "请求成功");
        return res;
    }
}
