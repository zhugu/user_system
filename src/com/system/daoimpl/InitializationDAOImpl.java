package com.system.daoimpl;

import com.system.dao.InitializationDAO;
import com.system.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by leovo on 2017/12/22.
 */
public class InitializationDAOImpl implements InitializationDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public int deleteAll() throws SQLException {
        int count;
        String sql = "DROP DATABASE db_system;  ";
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        count = ps.executeUpdate();
        return count;
    }
}
