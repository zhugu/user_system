package com.system.daoimpl;

import com.system.dao.ExportDAO;
import com.system.model.User;
import com.system.model.Wages;
import com.system.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leovo on 2017/12/25.
 */
public class ExportDAOImpl implements ExportDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public List<User> getAllUser() throws SQLException {
        String sql = "SELECT * FROM t_user ";
        List<Object> list = jdbcUtil.excuteQuery(sql,null);
        return getUserList(list);
    }

    @Override
    public List<Wages> getAllWages() throws SQLException {
        String sql = "SELECT * FROM t_wages ";
        List<Object> list1 = jdbcUtil.excuteQuery(sql,null);
        return getWagesList(list1);
    }

    /**
     * 封装一个本类的私有方法，用来把object集合转换成user类型的集合
     * @param list
     * @return
     */
    private List<User> getUserList(List<Object> list){
        List<User> users = new ArrayList<>();
        for(Object object : list){
            Map<String,Object> map = (Map<String,Object>) object;
            User user = new User(map.get("userid").toString(),map.get("name").toString(),
                    (byte[])map.get("picture"),map.get("sex").toString(),
                    map.get("address").toString(),map.get("place").toString(),
                    map.get("nation").toString(),(Integer)map.get("departmentid"),
                    map.get("job").toString(),map.get("tel").toString(),(Date)map.get("entrytime"),
                    map.get("identityID").toString());
            users.add(user);
        }
        return users;
    }

    private List<Wages> getWagesList(List<Object> list1){
        List<Wages> wages1 = new ArrayList<>();
        for(Object object : list1){
            Map<String,Object> map = (Map<String,Object>) object;
            Wages wages = new Wages((Integer)map.get("wagesid"),map.get("userid").toString(),
                    (Double)map.get("basicwages"),(Double)map.get("attendancereward"),(Double)map.get("yearwages"),
                    (Double)map.get("publish"),(Double)map.get("insurance"),(Double)map.get("tax"),
                    (Double)map.get("wages"),(Double)map.get("truewages"),(Date)map.get("date"));
            wages1.add(wages);
        }
        return wages1;
    }
}
