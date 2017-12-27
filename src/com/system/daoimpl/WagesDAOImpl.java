package com.system.daoimpl;

import com.system.dao.WagesDAO;
import com.system.model.User;
import com.system.model.Wages;
import com.system.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 王宁
 * on 2017/12/20.
 * wagesDAO实现类
 */
public class WagesDAOImpl implements WagesDAO {
    private JDBCUtil jdbcUtil= JDBCUtil.getInitJDBCUtil();
    @Override
    public int insertWages(Wages wages) throws SQLException {
        String  sql="INSERT INTO t_wages VALUES (null,?,?,?,?,?,?,?,?,?,?) ";
        Object[] params={wages.getUserid(),wages.getBasicwages(),wages.getAttendancereward(),wages.getYearwages(),
                            wages.getPublish(),wages.getInsurance(),wages.getTax(),wages.getWages(),wages.getTruewages(),wages.getDate()};
        int n=jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public int updateWages(Wages wages) throws SQLException {
        int n;
        String sql = "UPDATE t_wages SET attendancereward = ?,publish = ? WHERE userid = ? ";
        Object[] params = {wages.getAttendancereward(),wages.getPublish(),wages.getUserid()};
        n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public List<Wages> search(String account) throws SQLException {
        String sql="SELECT * FROM t_wages WHERE userid = ? ";
        List<Object>list=jdbcUtil.excuteQuery(sql,new Object[]{account});
        List<Wages>rpList=new ArrayList<>();
        for (Object object : list){
            Map<String, Object> map = (Map<String, Object>) object;
            Wages wages=new Wages((int)map.get("wagesid"),map.get("userid").toString(),(double)map.get("basicwages"),
                    (double)map.get("attendancereward"),(double)map.get("yearwages"),(double)map.get("publish"),
                    (double)map.get("insurance"),(double)map.get("tax"),(double)map.get("wages"),(double)map.get("truewages"),
                    (Date) map.get("date"));
            //给id设置值
            wages.setWagesid((Integer) map.get("id"));
            rpList.add(wages);
        }
        return rpList;
    }

    @Override
    public List<Wages> getAllWages() throws SQLException {
        String sql="SELECT * FROM t_wages ";
        List<Object>list=jdbcUtil.excuteQuery(sql,null);
        return getWagesList(list);
    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM t_user ";
        List<Object> list = jdbcUtil.excuteQuery(sql,null);
        return getUserList(list);
    }

    @Override
    public List<Wages> querylike(String keywords) throws SQLException {
        String sql="SELECT * FROM t_wages WHERE CONCAT (userid,basicwages,attendancereward,yearwages,tax,DATE) LIKE ? ";
        List<Object>list=jdbcUtil.excuteQuery(sql,new Object[]{"%"+keywords+"%"});
        return getWagesList(list);
    }

    @Override
    public List<Wages> queryfilter(String condition) throws SQLException {
        String sql="SELECT * FROM t_wages "+condition;
        List<Object>list=jdbcUtil.excuteQuery(sql,null);
        return getWagesList(list);
    }

    private List<Wages> getWagesList(List<Object> list) {
        List<Wages> wages = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Wages wage=new Wages((int)map.get("wagesid"),map.get("userid").toString(),(double)map.get("basicwages"),
                    (double)map.get("attendancereward"),(double)map.get("yearwages"),(double)map.get("publish"),
                    (double)map.get("insurance"),(double)map.get("tax"),(double)map.get("wages"),(double)map.get("truewages"),
                    (Date) map.get("date"));
            wages.add(wage);
        }
        return wages;
    }

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
}
