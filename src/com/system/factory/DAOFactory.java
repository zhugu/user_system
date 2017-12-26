package com.system.factory;

import com.system.dao.*;
import com.system.daoimpl.*;

/**
 * @author 徐文倩
 */
public class DAOFactory {
    public static UserDAO getUserDAOInstance() {
        return new UserDAOImpl();
    }

    public static UserPermissionDAO getUserPermissionDAOInstance() {
        return new UserPermissionDAOImpl();
    }
    public static RepublishDAO getRepublishDAOInstance(){
        return new RepublishDAOImpl();
    }
    public static AttendanceDAO getAttendanceDAOInstance(){
        return new AttendanceDAOImpl();
    }
    public static WagesDAO getWagesDAOInstance(){
        return new WagesDAOImpl();
    }

}
