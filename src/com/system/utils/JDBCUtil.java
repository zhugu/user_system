package com.system.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC辅助类 用于构建数据库连接（采用单例模式），封装了增、删、改、查的基本功能，方便具体的DAO类实现
 */
public final class JDBCUtil {
    private static String url = "jdbc:mysql://localhost:3306/db_system";
    private static String name = "root";
    private static String password = "root";
    private static Connection connnection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static JDBCUtil jdbcUtil = null;

    public static JDBCUtil getInitJDBCUtil() {
        if (jdbcUtil == null) {
            //线程加锁
            synchronized (JDBCUtil.class) {
                if (jdbcUtil == null) {
                    //懒汉式加载
                    jdbcUtil = new JDBCUtil();
                }
            }
        }
        return jdbcUtil;
    }

    private JDBCUtil() {
    }

    // 通过静态代码块注册数据库驱动，保证注册只执行一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获得连接
    public Connection getConnection() {
        try {
            connnection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connnection;

    }

    /**
     * insert update delete SQL语句的执行的统一方法
     *
     * @param sql    SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 受影响的行数
     */
    public int executeUpdate(String sql, Object[] params) {
        // 受影响的行数
        int affectedLine = 0;
        try {
            // 获得连接
            connnection = this.getConnection();
            // 调用SQL
            preparedStatement = connnection.prepareStatement(sql);
            // 参数赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            // 执行更新操作
            affectedLine = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // 释放资源
            closeAll();
        }
        //返回受影响的记录行数
        return affectedLine;
    }

    /**
     * SQL 查询将查询结果直接放入ResultSet中
     *
     * @param sql    SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 结果集
     */
    private ResultSet executeQueryRS(String sql, Object[] params) {
        try {
            // 获得连接
            connnection = this.getConnection();
            // 调用SQL
            preparedStatement = connnection.prepareStatement(sql);
            // 参数赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            // 执行
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultSet;
    }

    /**
     * 获取结果集，并将结果放在List中
     *
     * @param sql SQL语句
     * @return List 结果集
     */
    public List<Object> excuteQuery(String sql, Object[] params) {
        // 执行SQL获得结果集
        ResultSet rs = executeQueryRS(sql, params);
        // ResultSetMetaData接口, 用于获取关于ResultSet 对象中列的类型和属性信息的对象
        ResultSetMetaData rsmd = null;
        // 结果集列数
        int columnCount = 0;
        try {
            //获得结果集的元数据信息
            rsmd = rs.getMetaData();
            // 获得结果集列数
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e1) {
            System.err.println(e1.getMessage());
        }
        // 创建List
        List<Object> list = new ArrayList<Object>();
        try {
            // 以下代码将ResultSet的结果保存到List中
            //循环遍历所有的记录
            while (rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                //循环遍历一条记录的所有列
                for (int i = 1; i <= columnCount; i++) {
                    //将列名、对应列的值放进map对象
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));
                }
                //将一条记录放进List
                list.add(map);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            // 关闭所有资源
            closeAll();
        }
        return list;
    }

    /**
     * SQL 查询将查询结果：一行
     *
     * @param sql    SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 结果集
     */
    public  Map<String, Object> executeQuerySingle(String sql, Object[] params) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 获得连接
            connnection = this.getConnection();
            // 调用SQL
            preparedStatement = connnection.prepareStatement(sql);
            // 参数赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            // 执行查询
            resultSet = executeQueryRS(sql, params);
            ResultSetMetaData rsmd = null;
            // 结果集列数
            int columnCount = 0;
            try {
                //获取结果集的元数据信息，各个列的数据
                rsmd = resultSet.getMetaData();
                // 获得结果集列数
                columnCount = rsmd.getColumnCount();
            } catch (SQLException e1) {
                System.err.println(e1.getMessage());
            }
            //找到一行记录
            if (resultSet.next()) {
                //遍历该行记录的所有列
                for (int i = 1; i <= columnCount; i++) {
                    map.put(rsmd.getColumnLabel(i), resultSet.getObject(i));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return map;
    }

    /**
     * 关闭所有资源
     */
    public void closeAll() {
        // 关闭结果集对象
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        // 关闭PreparedStatement对象
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        // 关闭Connection 对象
        if (connnection != null) {
            try {
                connnection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
