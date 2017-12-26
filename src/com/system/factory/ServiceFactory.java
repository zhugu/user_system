package com.system.factory;

import com.system.service.*;
import com.system.serviceimpl.*;

/**
 * @author 徐文倩
 */
public class ServiceFactory {
    public static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }
    public static ApplyService getApplyServiceInstance(){
        return new ApplyServiceImpl();
    }
    public static InformService getInformServiceInstance(){
        return  new InformServiceImpl();
    }
    public static WageServiceDAO getWageServiceDAOInstance(){
        return new WageServiceDAOImpl();
    }
    public static DepartmentService getDepartmentServiceInstance() {
        return new DepartmentServiceImpl();
    }
    public static InitializationService getInitializationServiceInstance() {
        return new InitializationServiceImpl();
    }
    public static ExportService getExportServiceInstance() {
        return new ExportServiceImpl();
    }
    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }
    public static RepublishSerice getRepublishSericeInstance() {
        return new RepublishServiceImpl();
    }
}
