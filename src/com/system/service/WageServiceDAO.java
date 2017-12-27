package com.system.service;

import com.system.model.User;
import com.system.model.Wages;

import java.util.List;

/**
 * @author 王宁
 * on 2017/12/23.
 * wagesservice接口
 */
public interface WageServiceDAO {
    //插入一条工资信息
    int insertWages(Wages wages);
    //修改工资表信息
    int updateWages(Wages wages);
    //查看某人工资表信息
    List<Wages> search(String account);
    //查看工资表所有信息
    List<Wages> getAllWages();
    //查找全部员工
    List<User> getAll();
    //模糊查询
    List<Wages>querylike(String keywords);
    //条件查询
    List<Wages>queryfilter(String condition);
}
