package com.system.utils;

import ccom.system.panel.personnel.SearchUserPanel;
import com.system.frame.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PermissionUtils {
    private static Map<String,JPanel> map = new HashMap<>();

    public Map<String,JPanel> getPermissions(){
 //       map.put("查看个人信息",new UserFrame1().getMainPanel());
//        map.put("修改个人密码",new SearchRepublishiPanel().getMainPanel());
//        map.put("查看员工信息",new SearchUserPanel().getMainPanel());
//        map.put("修改员工信息",new UpdateUserPanel().getMainPanel());
//        map.put("新增员工信息",new NewUser().getMainPanel());
//        map.put("删除员工信息",new DeletUserPanel().getMainPanel());
//        map.put("查看工资",new );
          map.put("查看所有人工资",new SearchPanel().getMainpanel());
          map.put("录入工资",new AddPanel().getMainpanel());
//        map.put("修改工作",new );
 //       map.put("生成工资报表",new );
          map.put("发出通知",new InformPanel().getMainPanel());
          map.put("查看通知",new InformPanel2().getMainPanel());
//          map.put("新增管理员权限",new SuperAdministratorFrame().getMainPanel());
//        map.put("修改管理员权限",new );
//        map.put("查看管理员权限",new );
//        map.put("查看所有部门",new );
//        map.put("修改部门信息",new );
//        map.put("新增部门",new );
//        map.put("查看考勤",new );
//        map.put("查看考勤情况",new SearchAttendancePanel().getMainPanel());
//        map.put("考勤签到",new );
//        map.put("发起申请",new );
//        map.put("查看申请",new );
        map.put("查看所有人申请",new ApplyPanel().getMainPanel());
 //       map.put("审核申请",new );
//        map.put("查看奖惩信息",new SearchRepublishiPanel().getMainPanel());
//        map.put("新增奖惩信息",new NewRepublishPanel().getMainPanel());
        return map;
    }
}
