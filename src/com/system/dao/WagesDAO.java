package com.system.dao;

import com.system.model.User;
import com.system.model.Wages;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 徐文倩
 */
public interface WagesDAO {
    /**
     * 查看自己薪资
     * @param userid
     * @return
     * @throws SQLException
     */
    Wages getWages(String userid) throws SQLException;
    //插入一条工资信息
    int insertWages(Wages wages)throws SQLException;
    //修改工资表信息
    int updateWages(Wages wages)throws SQLException;
    //查看某人工资表信息
    Wages search(String account)throws SQLException;
    //查看工资表所有信息
    List<Wages>getAllWages()throws SQLException;
    //获取所有员工信息
    List<User> getAll() throws SQLException;
    //模糊查询
    List<Wages>querylike(String keywords)throws SQLException;
    //条件查询
    List<Wages>queryfilter(String condition)throws SQLException;

}
