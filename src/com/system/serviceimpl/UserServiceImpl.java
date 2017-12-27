package com.system.serviceimpl;

import com.system.dao.*;
import com.system.factory.DAOFactory;
import com.system.model.*;
import com.system.service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 徐文倩
 */
public class UserServiceImpl implements UserService{
    private UserDAO userDAO = DAOFactory.getUserDAOInstance();
    private UserPermissionDAO userPermissionDAO = DAOFactory.getUserAuthorityDAOInstance();
    private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceDAOInstance();
    private RepublishDAO republishDAO = DAOFactory.getRepublishDAOInstance();
    private WagesDAO wagesDAO = DAOFactory.getWagesDAOInstance();
    @Override
    public Map<String, Object> userLogin(String userid, String password) {
        Map<String, Object> map = new HashMap<>();
        User_login user_login = null;
        User user = null;
        try {
            user_login = userDAO.getlogin(userid);
            user = userDAO.getuser(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user_login != null) {
            if (user_login.getPassword().equals(password)) {
                map.put("info", "登录成功");
                map.put("user", user);
                Map<String, List<String>> userPermissionMap = null;
                try {
                    userPermissionMap = userPermissionDAO.getUserPermission(userid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                map.put("userPermissionMap", userPermissionMap);
            } else {
                map.put("info", "密码错误");
            }
        } else {
            map.put("info", "账号不存在");
        }
        return map;
    }

    @Override
    public Map<String, Object> phoneLogin(String tel, String number, String captcha){
        Map<String, Object> map = new HashMap<>();
        User user = null;

        try {
            user = userDAO.getUser(tel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            if (number.equals(captcha)) {
                map.put("info", "登录成功");
                map.put("user", user);
                Map<String, List<String>> userPermissionMap = null;
                try {
                    userPermissionMap = userPermissionDAO.getUserPermission(user.getUserid());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                map.put("userPermissionMap", userPermissionMap);
            } else {
                map.put("info", "验证码错误");
            }
        } else {
            map.put("info", "账号不存在");
        }
        return map;
    }
    @Override
    public User getUser(String userid) {
        User user = null;
        try {
            user = userDAO.getuser(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Attendance> getAttendance(String userid){
        List<Attendance> list = null;
        try {
            list = attendanceDAO.getAttendance(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        int n = 0;
        try {
            n = userDAO.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(n == 1){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Republish> getRP(String userid){
        List<Republish> list = null;
        try {
            list = republishDAO.getRP(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Wages> search(String account) throws SQLException {
        List<Wages> wages=null;
        try {
            wages=wagesDAO.search(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wages;
    }
}
