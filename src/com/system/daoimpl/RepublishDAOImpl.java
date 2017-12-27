package com.system.daoimpl;

import com.system.dao.RepublishDAO;
import com.system.model.Republish;
import com.system.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

    @Override
    public List<Republish> getAll() throws SQLException {
        String sql = "SELECT * FROM t_rp ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getRPList(list);    }

    @Override
    public int insert(Republish republish) throws SQLException {
        String sql = "INSERT INTO t_rp VALUES (null,?,?,?,?,?) ";
        Object[] params = {republish.getUserid(), republish.getRpname(), republish.getRpdate(), republish.getRpreason(), republish.getReresult()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;    }

    @Override
    public int[] batchDelete(List<Integer> ids) throws SQLException {
        int[] result;
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_rp WHERE rpid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (Integer id : ids) {
            ps.setInt(1, id);
            ps.addBatch();
        }
        result = ps.executeBatch();
        jdbcUtil.closeAll();
        return result;    }

    @Override
    public List<Republish> queryBy(String condition) throws SQLException {
        String sql = "SELECT * FROM t_rp " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getRPList(list);    }

    private List<Republish> getRPList(List<Object> list){
        List<Republish> rplist = new ArrayList<>();
        for(Object object : list){
            Map<String,Object> map = (Map<String,Object>) object;
            Republish rp = new Republish(map.get("userid").toString(),map.get("rpname").toString(),(Date)map.get("rpdate"),map.get("rpreason").toString(),map.get("rpresult").toString());
            rp.setRpid((Integer)map.get("rpid"));
            rplist.add(rp);
        }
        return rplist;
    }
}
