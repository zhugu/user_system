package com.system.service;

import com.system.model.Apply;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by asus on 2017/12/24.
 */
public interface ApplyService {


    /**
     * 更新申请
     * @param apply
     * @return
     * @throws SQLException
     */
    boolean update(Apply apply)     throws SQLException  ;

    /**
     * 通过工号查找申请
     * @param userid
     * @return
     * @throws SQLException
     */
    Apply getApply(String userid);


    /**
     * 得到所有申请信息
     * @return
     */
    List<Apply> getAllApply() ;

    /**
     * 根据条件组合查询
     * @param condition
     * @return
     */
    List<Apply> queryFilter(String condition);


    /**
     * 模糊查询
     * @param keywords
     * @return
     */
    List<Apply> queryLike(String keywords);
}
