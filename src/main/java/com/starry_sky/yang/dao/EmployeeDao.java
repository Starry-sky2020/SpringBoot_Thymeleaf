package com.starry_sky.yang.dao;

import com.starry_sky.yang.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeDao {

    /**
     * 员工列表页面
     * 查询所有员工
     */
    List<Employee> employeeList();

    /**
     * 插入员工数据
     * 保存员工信息
     */
    void save(Employee employee);

    /**
     * 修改员工信息
     * 查询一个员工信息进行信息修改
     * @param id
     * @return
     */
    Employee findById(@Param("id") Integer id);

    /**
     * 更新员工信息
     * @param employee
     */
    void update(Employee employee);

    /**
     * 删除数据
     * @param id
     */
    void delete(@Param("id") Integer id);
}
