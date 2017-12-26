package com.system.daoimpl;

import com.system.dao.WagesDAO;
import com.system.model.Wages;
import com.system.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 徐文倩
 */
public class WagesDAOImpl implements WagesDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Wages getWages(String userid) throws SQLException {
        String sql = "SELECT * FROM t_wages WHERE userid = ? ";
        Map<String,Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{userid});
        if(map.size()!= 0){
            Wages wages = new Wages((Integer) map.get("wagesid"),
                    map.get("userid").toString(),(Double)map.get("basicwages"),
                    (Double)map.get("attendancereward"),(Double)map.get("yearwages"),
                    (Double)map.get("publish"),(Double)map.get("insurance"),
                    (Double)map.get("tax"),(Double)map.get("wages"),
                    (Double)map.get("truewages"),(Date)map.get("date"));
            wages.setWagesid((Integer)map.get("id"));
            return wages;
        }else {
            return null;
        }

    }

    private List<Wages> getWagesList(List<Object> list){
        List<Wages> wagesList = new ArrayList<>();
        for(Object object : list){
            Map<String, Object> map = (Map<String, Object>) object;
            Wages wages = new Wages((Integer) map.get("wagesid"),
                    map.get("userid").toString(),(Double)map.get("basicwages"),
                    (Double)map.get("attendancereward"),(Double)map.get("yearwages"),
                    (Double)map.get("publish"),(Double)map.get("insurance"),
                    (Double)map.get("tax"),(Double)map.get("wages"),
                    (Double)map.get("truewages"),(Date)map.get("date"));
            wages.setWagesid((Integer)map.get("id"));
            wagesList.add(wages);
        }
        return wagesList;
    }
}
