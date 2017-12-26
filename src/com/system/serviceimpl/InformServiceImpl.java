package com.system.serviceimpl;

import com.system.dao.InformDAO;
import com.system.factory.DAOFactory;
import com.system.model.Inform;
import com.system.service.InformService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 邓益聪
 * InformService的实现类
 * Created by asus on 2017/12/24.
 */
public class InformServiceImpl implements InformService {
    private InformDAO informDAO = DAOFactory.getInformDAOInstance();

    @Override
    public int insertInform(Inform inform) {
        int n = 0;
        try {
            n = informDAO.insertInform(inform);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Inform> getAllInform() {
        List<Inform> informList = new ArrayList<>();
        try {
            informList= informDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return informList;
    }

    @Override
    public int[] batchDelete(List<String> ids) {
        int[] result = new int[ids.size()];
        try {
            result = informDAO.batchDelete(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
