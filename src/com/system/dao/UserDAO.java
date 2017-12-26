package com.system.dao;


import com.system.model.Attendance;
import com.system.model.User;
import com.system.model.User_login;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 缪瑞祥
 */
public interface UserDAO {
    /**
     * 通过工号查找员工
     * @param userid
     * @return
     * @throws SQLException
     */
    User getuser(String userid) throws SQLException;

    /**
     * 获取所有员工信息
     * @return list
     * @throws SQLException
     */
    List<User> getAll() throws SQLException;

    /**
     * 通过电话查找员工
     * @param tel
     * @return
     * @throws SQLException
     */
    User getUser(String tel) throws SQLException;

    /**
     * 通过工号查找登录信息
     * @param userid
     * @return
     * @throws SQLException
     */
    User_login getlogin(String userid) throws SQLException;

    /**
     * 关键词模糊查找
     * @param condition
     * @return
     * @throws SQLException
     */
    List<User> queryBy(String condition) throws SQLException;

    /**
     * 按条件查找
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<User> queryLike(String keywords) throws SQLException;

    /**
     * 更新员工信息
     * @param user
     * @return int
     * @throws SQLException
     */
    int update(User user) throws SQLException;

    /**
     * 新增一个员工
     * @param user
     * @return int
     * @throws SQLException
     */
    int insert(User user) throws SQLException;

    /**
     * 批量新增员工
     * @param users
     * @return int[]
     * @throws SQLException
     */
    int[] batchInsert(List<User> users) throws SQLException;

    /**
     * 批量删除员工
     * @param userids
     * @return int[]
     * @throws SQLException
     */
    int[] batchDelete(List<String> userids) throws SQLException;
    /**
     * 员工签到新增考勤信息
     * @param attendance
     * @return
     * @throws SQLException
     */
    int insert(Attendance attendance) throws SQLException;
}
