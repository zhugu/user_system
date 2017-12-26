package com.system.service;

import com.system.dao.WagesDAO;
import com.system.factory.DAOFactory;
import com.system.model.User;
import com.system.model.Wages;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

;

/**
 * @author 王宁
 * on 2017/12/23.
 * service层实现类
 */
public class WageServiceDAOImpl implements WageServiceDAO {
    private WagesDAO wagesDAO= DAOFactory.getWagesDAOInstance();

    @Override
    public int insertWages(Wages wages) {
        int n=0;
        try {
            n=wagesDAO.insertWages(wages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int updateWages(Wages wages) {
        int n=0;
        try {
            n=wagesDAO.updateWages(wages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Wages search(String account) {
        Wages wages=null;
        try {
            wages=wagesDAO.search(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wages;
    }

    @Override
    public List<Wages> getAllWages() {
        List<Wages>wagesList=new ArrayList<>();
        try {
            wagesList=wagesDAO.getAllWages();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wagesList;
    }

    @Override
    public List<User> getAll(){
        List<User>userList=new ArrayList<>();
        try {
            userList=wagesDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<Wages> querylike(String keywords) {
        List<Wages>list=new ArrayList<>();
        try {
            list=wagesDAO.querylike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Wages> queryfilter(String condition) {
        List<Wages>list=new ArrayList<>();
        try {
            list=wagesDAO.queryfilter(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
