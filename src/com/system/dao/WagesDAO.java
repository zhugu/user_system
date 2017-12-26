package com.system.dao;

import com.system.model.Wages;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 徐文倩
 */
public interface WagesDAO {
    /**
     * 查看自己薪资
     * @param userid
     * @return
     * @throws SQLException
     */
    Wages getWages(String userid) throws SQLException;

}
