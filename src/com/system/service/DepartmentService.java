package com.system.service;

import com.system.model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author leovo
 * @date 2017/12/21
 */
public interface DepartmentService {
    int insertDepartment(Department department) throws SQLException;

    int deleteDepartment(int departmentid) throws SQLException;

    int update(Department department) throws SQLException;

    Department get(int departmentid) throws SQLException;

    List<Department> getAll() ;
}
