package com.system.daoimpl;

import com.system.dao.RepublishDAO;
import com.system.model.Republish;
import com.system.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepublishDAOImpl implements RepublishDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public List<Republish> getRP(String userid) throws SQLException {
        String sql = "SELECT * FROM t_rp WHERE userid = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{userid});
        return getRPList(list);
    }

    private List<Republish> getRPList(List<Object> list){
        List<Republish> rplist = new ArrayList<>();
        for(Object object : list){
            Map<String,Object> map = (Map<String,Object>) object;
            Republish rp = new Republish((Integer) map.get("rpid"),map.get("userid").toString(),map.get("rpname").toString(),(Date)map.get("rpdate"),map.get("rpreason").toString(),map.get("rpresult").toString());
            rp.setRpid((Integer)map.get("rpid"));
            rplist.add(rp);
        }
        return rplist;
    }
}
