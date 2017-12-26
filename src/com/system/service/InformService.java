package com.system.service;

import com.system.model.Inform;

import java.util.List;

/**
 * @author 邓益聪
 * inform的Service层接口
 * Created by asus on 2017/12/24.
 */
public interface InformService {

    /**
     * 插入一条新通知
     * @param inform
     * @return
     */
    int insertInform(Inform inform);

    /**
     * 得到所有通知信息
     * @return
     */
    List<Inform> getAllInform();

    /**
     * 删除选中行
     * @param ids
     * @return
     */
    int[] batchDelete(List<String> ids);

}
