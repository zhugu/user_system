package com.system.serviceimpl;

import com.system.dao.ExportDAO;
import com.system.factory.DAOFactory;
import com.system.model.User;
import com.system.model.Wages;
import com.system.service.ExportService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leovo on 2017/12/25.
 */
public class ExportServiceImpl implements ExportService {
    private ExportDAO exportDAO = DAOFactory.getExportDAOInstance();

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            userList = exportDAO.getAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<Wages> getAllWages()  {
        List<Wages> wagesList = new ArrayList<>();
        try {
            wagesList = exportDAO.getAllWages();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wagesList;
    }
}
