package com.system.dao;

import com.system.factory.DAOFactory;
import com.system.model.User;
import com.system.model.User_login;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 缪瑞祥
 */
public class UserDAOTest {
    private UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        userDAO = DAOFactory.getUserDAOInstance();
    }

    @Test
    public void getUser() throws Exception {
        User user = userDAO.getUser("15195226887");
        System.out.println(user);
    }

    @Test
    public void get() throws Exception {
        User user = userDAO.getuser("101001");
        System.out.println(user);
    }

    @Test
    public void getlogin() throws Exception {
        User_login user_login = userDAO.getlogin("111");
        System.out.println(user_login);
    }

    @Test
    public void getAll() throws Exception {
        List<User> userList = userDAO.getAll();
        userList.forEach(user -> System.out.println(user));
    }


}