package com.system.serviceimpl;

import com.system.dao.RepublishDAO;
import com.system.factory.DAOFactory;
import com.system.model.Republish;
import com.system.service.RepublishSerice;

import java.sql.SQLException;
import java.util.List;

public class RepublishServiceImpl implements RepublishSerice {
    private RepublishDAO republishDAO = DAOFactory.getRepublishDAOInstance();

    @Override
    public List<Republish> getRP(String userid) throws SQLException {
        return republishDAO.getRP(userid);
    }

    @Override
    public List<Republish> getAll() throws SQLException {
        return republishDAO.getAll();
    }

    @Override
    public int insert(Republish republish) throws SQLException {
        return republishDAO.insert(republish);
    }

    @Override
    public int[] batchDelete(List<Integer> ids) throws SQLException {
        return republishDAO.batchDelete(ids);
    }

    @Override
    public List<Republish> queryBy(String condition) throws SQLException {
        return republishDAO.queryBy(condition);
    }
}
