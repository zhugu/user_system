package com.system.dao;

import com.system.model.User;
import com.system.model.Wages;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author leovo
 * @date 2017/12/25
 */
public interface ExportDAO {
    List<User> getAllUser() throws SQLException;

    List<Wages> getAllWages() throws SQLException;
}
