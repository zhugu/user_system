package com.system.dao;

import com.system.model.Republish;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 徐文倩
 */
public interface RepublishDAO {
    /**
     * 查询员工的奖惩信息
     * @param userid
     * @return
     * @throws SQLException
     */
    List<Republish> getRP(String userid) throws SQLException;
}
