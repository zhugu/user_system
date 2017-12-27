package com.system.dao;

import com.system.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserPermissionDAOTest {
    private  UserPermissionDAO userPermissionDAO;

    @Before
    public void setUp() throws Exception {
        userPermissionDAO = DAOFactory.getUserAuthorityDAOInstance();
    }

    @Test
    public void getUserPermission() throws Exception {
        Map<String, List<String>> map = userPermissionDAO.getUserPermission("101001");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
        }
    }

}