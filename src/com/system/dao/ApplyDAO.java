package com.system.dao;

import com.system.model.Apply;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 邓益聪
 * 申请类DAO层
 * Created by asus on 2017/12/19.
 */
public interface ApplyDAO {


    /**
     * 通过工号查找
     * @param userid
     * @return
     * @throws SQLException
     */
    Apply getApply(String userid)throws SQLException;


    /**
     * 获取所有申请信息
     * @return
     * @throws SQLException
     */
    List<Apply> getAllApply() throws SQLException;


    /**
     * 更新申请
     * @param apply
     * @return
     * @throws SQLException
     */
    int update(Apply apply) throws  SQLException;

    /**
     * 根据条件组合查询
     * @param condition
     * @return
     * @throws SQLException
     */
    List<Apply> queryFilter(String condition) throws SQLException;

    /**
     * 模糊查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Apply> queryLike(String keywords) throws SQLException;


}
