package com.system.dao;

import com.system.model.Republish;

import java.sql.SQLException;
import java.util.List;

public interface RepublishDAO {
    /**
     * 查询员工的奖惩信息
     * @param userid
     * @return
     * @throws SQLException
     */
    List<Republish> getRP(String userid) throws SQLException;
    /**
     * 查询所有的奖惩信息
     *
     * @return
     * @throws SQLException
     */
    List<Republish> getAll() throws SQLException;

    /**
     *新增一个奖惩信息
     * @param rp
     * @return
     * @throws SQLException
     */
    int insert(Republish republish) throws SQLException;

    /**
     * 批量删除奖项信息
     * @param ids
     * @return
     * @throws SQLException
     */
    int[] batchDelete(List<Integer> ids) throws SQLException;

    /**
     * 按条件查找奖惩
     * @param condition
     * @return
     * @throws SQLException
     */
    List<Republish> queryBy(String condition)throws SQLException;

}
