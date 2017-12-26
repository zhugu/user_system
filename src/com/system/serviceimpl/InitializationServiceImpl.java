package com.system.serviceimpl;

import com.system.dao.InitializationDAO;
import com.system.factory.DAOFactory;
import com.system.service.InitializationService;

import java.sql.SQLException;

/**
 * Created by leovo on 2017/12/24.
 */
public class InitializationServiceImpl implements InitializationService {
    private InitializationDAO initializationDAO = DAOFactory.getInitializationDAOInstance();

    @Override
    public int deleteAll() throws SQLException {
        int n = 0;
        n = initializationDAO.deleteAll();
        return n;
    }
}
