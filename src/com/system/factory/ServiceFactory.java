package com.system.factory;

import com.system.service.UserService;
import com.system.serviceimpl.UserServiceImpl;

/**
 * @author 徐文倩
 */
public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }
}
