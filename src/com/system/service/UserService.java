package com.system.service;

import com.system.model.Attendance;
import com.system.model.Republish;
import com.system.model.User;
import com.system.model.Wages;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author 徐文倩
 */
public interface UserService {
    /**
     * 登录
     *
     * @param userid
     * @param password
     * @return
     */
    Map<String, Object> userLogin(String userid, String password) throws SQLException;

    Map<String, Object> phoneLogin(String tel, String number, String captcha) throws SQLException;

    /**
     * 获取员工信息
     * @param userid
     * @return
     */
    User getUser(String userid) throws SQLException;

    /**
     * 获取某个员工的考勤信息列表
     * @param userid
     * @return
     * @throws SQLException
     */
    List<Attendance> getAttendance(String userid ) throws SQLException;

    /**
     * 修改员工信息
     * @param user
     * @return boolean
     */
    boolean updateUser(User user) throws SQLException;

    /**
     * 获取员工的奖惩列表
     * @param userid
     * @return
     * @throws SQLException
     */
    List<Republish> getRP(String userid) throws SQLException;

    /**
     * 查看员工薪资状况
     * @param userid
     * @return
     * @throws SQLException
     */
    List<Wages> getWages(String userid) throws SQLException;
}
