package com.system.service;

import com.system.model.User;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {
    /**
     *人事管理
     */
    User getuser(String userid) throws SQLException;
    List<User> getAll() throws SQLException;
    List<User> queryBy(String condition) throws SQLException;
    List<User> queryLike(String keywords) throws SQLException;
    int update(User user) throws SQLException;
    int insert(User user) throws SQLException;
    int[] batchInsert(List<User> users) throws SQLException;
    int[] batchDelete(List<String> userids) throws SQLException;


}
