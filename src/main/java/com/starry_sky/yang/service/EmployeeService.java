package com.starry_sky.yang.service;

import com.starry_sky.yang.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    /**
     * 查询员工信息
     * @return
     */
    List<Employee> employeeList();

    /**
     * 保存员工信息
     * @param employee
     */
    void save(Employee employee);

    /**
     * 查询一个员工详细信息
     * @param id
     * @return
     */
    Employee findById(Integer id);

    /**
     * 更新员工信息
     * @param employee
     */
    void update(Employee employee);

    /**
     * 删除员工信息
     * @param id
     */
    void delete(Integer id);
}
