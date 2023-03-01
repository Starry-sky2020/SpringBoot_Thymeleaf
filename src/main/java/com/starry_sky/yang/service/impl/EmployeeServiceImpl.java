package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.EmployeeDao;
import com.starry_sky.yang.pojo.Employee;
import com.starry_sky.yang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> employeeList() {

        List<Employee> employeeList = employeeDao.employeeList();
        return employeeList;
    }

    /**
     * 保存员工信息
     * @param employee
     */
    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    /**
     * 查询一个员工的信息
     * @param id
     * @return
     */
    @Override
    public Employee findById(Integer id) {

        Employee employee = employeeDao.findById(id);
        return employee;
    }

    /**
     * 更新员工信息
     * @param employee
     */
    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    /**
     * 删除员工信息
     * @param id
     */
    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }
}
