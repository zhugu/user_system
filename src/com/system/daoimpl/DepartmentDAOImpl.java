package com.system.daoimpl;

import com.system.dao.DepartmentDAO;
import com.system.model.Department;
import com.system.utils.JDBCUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leovo on 2017/12/21.
 */
public class DepartmentDAOImpl implements DepartmentDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Department get(int departmentid) {
        String sql = "SELECT * FROM t_department WHERE departmentid = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{departmentid});
        if (map.size() != 0) {
            Department department = new Department(map.get("departmentname").toString(),map.get("introduction").toString(),map.get("departmenttel").toString());
            //给id设置值
            department.setDepartmentid((Integer)map.get("departmentid"));
            return department;
        } else {
            return null;
        }
    }

    @Override
    public int insertDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO t_department VALUES (null,?,?,?) ";
        Object[] params = {department.getDepartmentname(),department.getIntroduction(),department.getDepartmenttel()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    @Override
    public int deleteDepartment(int departmentid) throws SQLException {
        String sql = "DELETE FROM t_department WHERE departmentid = ? ";
        Object[] params = {departmentid};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    @Override
    public int update(Department department) throws SQLException {
        int n;
        String sql = "UPDATE t_department SET departmentname = ?\n" + "WHERE departmentid = ? ";
        Object[] params = {department.getDepartmentname(),department.getDepartmentid()};
        n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public List<Department> getAll() throws SQLException {
        String sql = "SELECT * FROM t_department ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        List<Department> departments = new ArrayList<>();
        for (Object object:list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Department department = new Department(map.get("departmentname").toString(),map.get("introduction").toString(),map.get("departmenttel").toString());
            department.setDepartmentid((Integer)map.get("id"));
            departments.add(department);
        }
        return departments;
    }

    @Override
    public String departmentname(int departmentid) throws SQLException {
        String sql = "SELECT * FROM t_department WHERE departmentid = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{departmentid});
        if (map.size() != 0) {
            String departmentname = map.get("departmentname").toString();
            return departmentname;
        } else {
            return null;
        }    }

    @Override
    public int departmentid(String departmentname) throws SQLException {
        String sql = "SELECT * FROM t_department WHERE departmentname = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{departmentname});
        if (map.size() != 0) {
            int departmentid = (Integer) map.get("departmentid");
            return departmentid;
        } else {
            return 0;
        }
    }
}
