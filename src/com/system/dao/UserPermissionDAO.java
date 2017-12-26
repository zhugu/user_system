package com.system.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 用户权限接口
 */
public interface UserPermissionDAO {
    /**
     * 根据员工工号查询其权限
     *
     * @param userid
     * @return map
     * @throws SQLException
     */
    Map<String, List<String>> getUserPermission(String userid) throws SQLException;
}
