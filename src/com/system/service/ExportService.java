package com.system.service;

import com.system.model.User;
import com.system.model.Wages;

import java.util.List;

/**
 *
 * @author leovo
 * @date 2017/12/25
 */
public interface ExportService {
    List<User> getAllUser();

    List<Wages> getAllWages();
}
