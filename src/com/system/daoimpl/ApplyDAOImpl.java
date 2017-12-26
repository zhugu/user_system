package com.system.daoimpl;

import com.system.dao.ApplyDAO;
import com.system.model.Apply;
import com.system.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 邓益聪
 * 申请类的DAO实现层
 * Created by asus on 2017/12/19.
 */
public class ApplyDAOImpl implements ApplyDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Apply getApply(String userid) throws SQLException {
        String sql = " SELECT * FROM t_apply WHERE userid = ? ";
        Map<String ,Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{userid});
        if (map.size()!=0){
            Apply apply = new Apply((Integer)map.get("applyid"),map.get("userid").toString(),map.get("applyinfo").toString(),(Date)map.get("applydate"),map.get("examination").toString());
            return apply;
        }
        return null;
    }

    @Override
    public List<Apply> getAllApply() throws SQLException {
        String sql = " SELECT * FROM t_apply  ";
        List<Object>list = jdbcUtil.excuteQuery(sql,null);
        List<Apply> informs = new ArrayList<>();
        for (Object object :list){
            Map<String, Object> map = (Map<String, Object>) object;
            Apply apply = new Apply((Integer)map.get("applyid"),map.get("userid").toString(),map.get("applyinfo").toString(),(Date)map.get("applydate"),map.get("examination").toString());
            apply.setApplyid((Integer)map.get("applyid"));
            informs.add(apply);
        }
        return informs;
    }

    @Override
    public int update(Apply apply) throws SQLException {
        String sql = " UPDATE t_apply SET userid = ?,applyinfo = ?,applydate = ?,examination = ? WHERE applyid = ? ";
        Object[]params = {apply.getUserid(),apply.getApplyinfo(),apply.getApplydate(),apply.getExamination(),apply.getApplyid()};
        int n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public List<Apply> queryFilter(String condition) throws SQLException {
        String sql = "SELECT * FROM t_apply " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getApplyList(list);
    }

    @Override
    public List<Apply> queryLike(String keywords) throws SQLException {
        String sql = "SELECT * FROM t_apply WHERE CONCAT(applyid,userid,applyinfo,applydate,examination) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        return getApplyList(list);    }


    private List<Apply> getApplyList(List<Object> list) {
        List<Apply> applies = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Apply apply = new Apply((Integer)map.get("applyid"),map.get("userid").toString(),map.get("applyinfo").toString(),(Date)map.get("applydate"),map.get("examination").toString());
            applies.add(apply);
        }
        return applies;
    }
}
