package com.system.serviceimpl;

import com.system.dao.DepartmentDAO;
import com.system.factory.DAOFactory;
import com.system.model.Department;
import com.system.service.DepartmentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leovo
 * @date 2017/12/21
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO = DAOFactory.getDepartmentDAOInstance();

    @Override
    public int insertDepartment(Department department) throws SQLException {
        int n = 0;
        try {
            n = departmentDAO.insertDepartment(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteDepartment(int departmentid) throws SQLException {
        int n = 0;
        try {
            n = departmentDAO.deleteDepartment(departmentid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int update(Department department) throws SQLException {
        int n = 0;
        try {
            n = departmentDAO.update(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Department get(int departmentid) throws SQLException {
        Department department = null;
        try {
            department = departmentDAO.get(departmentid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departmentList = new ArrayList<>();
        try {
            departmentList = departmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }
}
