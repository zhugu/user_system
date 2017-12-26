package com.system.serviceimpl;

import com.system.dao.ApplyDAO;
import com.system.factory.DAOFactory;
import com.system.model.Apply;
import com.system.service.ApplyService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 邓益聪
 * ApplyService层的实现类
 * Created by asus on 2017/12/24.
 */
public class ApplyServiceImpl implements ApplyService {
    private ApplyDAO applyDAO = DAOFactory.getApplyDAOInstance();

    @Override
    public boolean update(Apply apply) {
        boolean flag = false;
        int n = 0;
        try {
            n = applyDAO.update(apply);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(n == 1){
            flag = true;
        }
        return flag;
    }

    @Override
    public Apply getApply(String userid)  {
        Apply apply = null;
        try {
            apply = applyDAO.getApply(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apply;
    }

    @Override
    public List<Apply> getAllApply() {
        List<Apply> applyList = new ArrayList<>();
        try {
            applyList= applyDAO.getAllApply();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applyList;
    }

    @Override
    public List<Apply> queryFilter(String condition) {
        List<Apply> applyList = new ArrayList<>();
        try {
            applyList = applyDAO.queryFilter(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applyList;
    }

    @Override
    public List<Apply> queryLike(String keywords) {
        List<Apply> applyList = new ArrayList<>();
        try {
            applyList = applyDAO.queryLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applyList;
    }
}
