package com.system.factory;

import com.system.dao.*;
import com.system.daoimpl.*;

/**
 * @author 徐文倩
 */
public class DAOFactory {
    public static UserDAO getUserDAOInstance(){
        return new UserDAOImpl();
    }
    public static AttendanceDAO getAttendanceDAOInstance(){
        return new AttendanceDAOImpl();
    }

    public static UserPermissionDAO getUserAuthorityDAOInstance() {
        return new UserPermissionDAOImpl();
    }
    public static ApplyDAO getApplyDAOInstance(){
        return new ApplyDAOImpl();
    }
    public static InformDAO getInformDAOInstance(){
        return  new InformDAOImpl();
    }
    public static WagesDAO getWagesDAOInstance(){
        return new WagesDAOImpl();
    }
    public static DepartmentDAO getDepartmentDAOInstance() {
        return new DepartmentDAOImpl();
    }
    public static InitializationDAO getInitializationDAOInstance() {
        return new InitializationDAOImpl();
    }
    public static ExportDAO getExportDAOInstance() {
        return new ExportDAOImpl();
    }
    public static RepublishDAO getRepublishDAOInstance(){
        return new RepublishDAOImpl();
    }

}
