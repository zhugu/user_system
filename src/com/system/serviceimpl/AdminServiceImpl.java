package com.system.serviceimpl;

import com.system.dao.UserDAO;
import com.system.factory.DAOFactory;
import com.system.model.User;
import com.system.service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private UserDAO userDAO = DAOFactory.getUserDAOInstance();

    @Override
    public User getuser(String userid) throws SQLException{
        return userDAO.getuser(userid);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userDAO.getAll();
    }

    @Override
    public List<User> queryBy(String condition) throws SQLException {
        return userDAO.queryBy(condition);
    }

    @Override
    public List<User> queryLike(String keywords) throws SQLException{
        return userDAO.queryLike(keywords);
    }

    @Override
    public int update(User user) throws SQLException {
        int n = 0;
        try {
            n = userDAO.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insert(User user) throws SQLException {
        int n = 0;
        try {
            n = userDAO.insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int[] batchInsert(List<User> users) throws SQLException {
        return userDAO.batchInsert(users);
    }

    @Override
    public int[] batchDelete(List<String> userids) throws SQLException {
        return userDAO.batchDelete(userids);
    }
}
