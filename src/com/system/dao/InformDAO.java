package com.system.dao;

import com.system.model.Inform;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 邓益聪
 * 通知类的DAO层
 * Created by asus on 2017/12/21.
 */
public interface InformDAO {
    /**
     * 插入通知信息
     * @param inform
     * @return
     * @throws SQLException
     */
    int insertInform(Inform inform)throws SQLException;


    /**
     * 获取所有通知信息
     * @return
     * @throws SQLException
     */
    List<Inform> getAll() throws SQLException;

    /**
     * 批量删除通知信息（删除选中的一组记录）
     * @param informs
     * @return
     * @throws SQLException
     */
    int[] batchDelete(List<Inform> informs) throws SQLException;

}
