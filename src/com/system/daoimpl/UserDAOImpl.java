package com.system.daoimpl;


import com.system.dao.UserDAO;
import com.system.model.Attendance;
import com.system.model.User;
import com.system.model.User_login;
import com.system.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 徐文倩
 */
public class UserDAOImpl implements UserDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public User getuser(String userid) throws SQLException {
        String sql = "SELECT * FROM t_user WHERE userid = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{userid});
        if (map.size() != 0) {
            User user = new User(map.get("userid").toString(),map.get("name").toString(),
                    (byte[]) map.get("picture"), map.get("sex").toString(), map.get("address").toString(),
                    map.get("place").toString(), map.get("nation").toString(), (Integer)map.get("departmentid"),
                    map.get("job").toString(), map.get("tel").toString(), (Date) map.get("entrytime"),
                    map.get("identityID").toString()
            );
            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM t_user";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getUserList(list);
    }

    @Override
    public User getUser(String tel) throws SQLException {
        String sql = "SELECT * FROM t_user WHERE tel = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{tel});
        if (map.size() != 0) {
            User user = new User(map.get("userid").toString(),map.get("name").toString(),
                    (byte[]) map.get("picture"), map.get("sex").toString(), map.get("address").toString(),
                    map.get("place").toString(), map.get("nation").toString(), (Integer)map.get("departmentid"),
                    map.get("job").toString(), map.get("tel").toString(), (Date) map.get("entrytime"),
                    map.get("identityID").toString()
            );
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User_login getlogin(String userid) throws SQLException {
        String sql = "SELECT * FROM t_login WHERE userid = ? ";
        Map<String, Object>map = jdbcUtil.executeQuerySingle(sql,new Object[]{userid});
        if (map.size() != 0){
            User_login user_login = new User_login(map.get("userid").toString(), map.get("password").toString());
            return user_login;
        }else {
            return null;
        }
    }

    @Override
    public List<User> queryBy(String condition) throws SQLException {
        String sql = "SELECT * FROM t_user " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getUserList(list);
    }

    @Override
    public List<User> queryLike(String keywords) throws SQLException {
        String sql = "SELECT * FROM t_user WHERE CONCAT(userid,name,sex,address,place,nation,department,job,entrytime) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        return getUserList(list);
    }

    @Override
    public int update(User user) throws SQLException {
        String sql = "UPDATE t_user SET name = ?,picture = ?,sex = ?,address = ?,place = ?,nation = ?,departmentid = ?,job = ?,tel = ?,entrytime = ?,identityID = ? WHERE userid = ? ";
        Object[] params = {user.getName(),user.getPicture(),user.getSex(),user.getAddress(),user.getPlace(),user.getNation(),user.getDepartmentid(),user.getJob(),user.getTel(),user.getEntrytime(),user.getIdentityID(),user.getUserid()};
        int n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }
    @Override
    public int insert(User user) throws SQLException {
        String sql = "INSERT INTO t_user VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] params = {user.getUserid(), user.getName(), user.getPicture(), user.getSex(),
                           user.getAddress(), user.getPlace(), user.getNation(), user.getDepartmentid(),
                           user.getJob(), user.getTel(), user.getEntrytime(), user.getIdentityID()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    @Override
    public int[] batchInsert(List<User> users) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_user VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (User user : users) {
            ps.setString(1, user.getUserid());
            ps.setString(2, user.getName());
            ps.setBytes(3, user.getPicture());
            ps.setString(4, user.getSex());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPlace());
            ps.setString(7, user.getNation());
            ps.setInt(8, user.getDepartmentid());
            ps.setString(9, user.getJob());
            ps.setString(10, user.getTel());
            ps.setDate(11, user.getEntrytime());
            ps.setString(12, user.getIdentityID());
            ps.addBatch();
        }
        // 执行批量更新操作
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;
    }

    @Override
    public int[] batchDelete(List<String> userids) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_user WHERE userid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (String userid : userids) {
            ps.setString(1, userid);
            ps.addBatch();
        }
        // 执行批量更新操作
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;
    }

    @Override
    public int insert(Attendance attendance) throws SQLException {
        String sql = "INSERT INTO t_attendance VALUES (null,?,?,?,?) ";
        Object[] params = {attendance.getId(),attendance.getUserid(),attendance.getDate(),attendance.getAttendance()};
        int n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    private List<User> getUserList(List<Object> list) {
        List<User> users = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            User user = new User(map.get("userid").toString(),map.get("name").toString(),
                    (byte[]) map.get("picture"), map.get("sex").toString(), map.get("address").toString(),
                    map.get("place").toString(), map.get("nation").toString(), (Integer)map.get("departmentid"),
                    map.get("job").toString(), map.get("tel").toString(), (Date) map.get("entrytime"),
                    map.get("identityID").toString());
            users.add(user);
        }
        return users;
    }
}
