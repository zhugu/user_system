package com.system.utils;

import javax.swing.*;
import java.util.Map;

/**
 * @author 邓益聪
 * 对主面板内容面板的判断 封装类
 * Created by asus on 2017/12/26.
 */
public class SwitchUtil {
    public void getaction(String info, JPanel contenPanel, Map<String,JPanel> map){
        switch (info){
            case "查看个人信息":
                contenPanel.removeAll();
                JPanel jPanel1 = new JPanel();
                jPanel1 = map.get(info);
                contenPanel.add(jPanel1);
                contenPanel.revalidate();
                break;
            case "修改个人密码":
                contenPanel.removeAll();
                JPanel jPanel2 = new JPanel();
                jPanel2 =  map.get(info);
                contenPanel.add(jPanel2);
                contenPanel.revalidate();
                break;
            case "查看员工信息":
                contenPanel.removeAll();
                JPanel jPanel3 = map.get(info);
                contenPanel.add(jPanel3);
                contenPanel.revalidate();
                break;
            case "修改员工信息":
                contenPanel.removeAll();
                JPanel jPanel4 = map.get(info);
                contenPanel.add(jPanel4);
                contenPanel.revalidate();
                break;
            case "新增员工信息":
                contenPanel.removeAll();
                JPanel jPanel5 = map.get(info);
                contenPanel.add(jPanel5);
                contenPanel.revalidate();
                break;
            case "删除员工信息":
                contenPanel.removeAll();
                JPanel jPanel6 = map.get(info);
                contenPanel.add(jPanel6);
                contenPanel.revalidate();
                break;
            case "查看工资":
                contenPanel.removeAll();
                JPanel jPanel7 = new JPanel();
                jPanel7 = map.get(info);
                contenPanel.add(jPanel7);
                contenPanel.revalidate();
                break;
            case "录入工资":
                contenPanel.removeAll();
                JPanel jPanel8 = map.get(info);
                contenPanel.add(jPanel8);
                contenPanel.revalidate();
                break;
            case "修改工资":
                contenPanel.removeAll();
                JPanel jPanel9 = map.get(info);
                contenPanel.add(jPanel9);
                contenPanel.revalidate();
                break;
            case "生成工资报表":
                contenPanel.removeAll();
                JPanel jPanel10 = map.get(info);
                contenPanel.add(jPanel10);
                contenPanel.revalidate();
                break;
            case "发出通知":
                contenPanel.removeAll();
                JPanel jPanel11 = map.get(info);
                contenPanel.add(jPanel11);
                contenPanel.revalidate();
                break;
            case "查看通知":
                contenPanel.removeAll();
                JPanel jPanel12 = map.get(info);
                contenPanel.add(jPanel12);
                contenPanel.revalidate();
                break;
            case "新增管理员权限":
                contenPanel.removeAll();
                JPanel jPanel13 = map.get(info);
                contenPanel.add(jPanel13);
                contenPanel.revalidate();
                break;
            case "修改管理员权限":
                contenPanel.removeAll();
                JPanel jPanel14 = map.get(info);
                contenPanel.add(jPanel14);
                contenPanel.revalidate();
                break;
            case "查看管理员权限":
                contenPanel.removeAll();
                JPanel jPanel15 = map.get(info);
                contenPanel.add(jPanel15);
                contenPanel.revalidate();
                break;
            case "查看所有部门":
                contenPanel.removeAll();
                JPanel jPanel16 = map.get(info);
                contenPanel.add(jPanel16);
                contenPanel.revalidate();
                break;
            case "新增部门":
                contenPanel.removeAll();
                JPanel jPanel17 = map.get(info);
                contenPanel.add(jPanel17);
                contenPanel.revalidate();
                break;
            case "查看考勤":
                contenPanel.removeAll();
                JPanel jPanel18 = map.get(info);
                contenPanel.add(jPanel18);
                contenPanel.revalidate();
                break;
            case "考勤签到":
                contenPanel.removeAll();
                JPanel jPanel19 = map.get(info);
                contenPanel.add(jPanel19);
                contenPanel.revalidate();
                break;
            case "发起申请":
                contenPanel.removeAll();
                JPanel jPanel20 = new JPanel();
                jPanel20 = map.get(info);
                contenPanel.add(jPanel20);
                contenPanel.revalidate();
                break;
            case "查看申请":
                contenPanel.removeAll();
                JPanel jPanel21 = new JPanel();
                jPanel21 = map.get(info);
                System.out.println(info);
                contenPanel.add(jPanel21);
                contenPanel.revalidate();
                break;
            case "审核申请":
                contenPanel.removeAll();
                JPanel jPanel22 = new JPanel();
                jPanel22 = map.get(info);
                contenPanel.add(jPanel22);
                contenPanel.revalidate();
                break;
            case "修改部门信息":
                contenPanel.removeAll();
                JPanel jPanel23 = map.get(info);
                contenPanel.add(jPanel23);
                contenPanel.revalidate();
                break;
            case "新增奖惩信息":
                contenPanel.removeAll();
                JPanel jPanel24 = map.get(info);
                contenPanel.add(jPanel24);
                contenPanel.revalidate();
                break;
            case "查看奖惩信息":
                contenPanel.removeAll();
                JPanel jPanel25 = map.get(info);
                contenPanel.add(jPanel25);
                contenPanel.revalidate();
                break;
            case "查看所有人工资":
                contenPanel.removeAll();
                JPanel jPanel26 = map.get(info);
                contenPanel.add(jPanel26);
                contenPanel.revalidate();
                break;
            case "查看考勤情况":
                contenPanel.removeAll();
                JPanel jPanel27 = map.get(info);
                contenPanel.add(jPanel27);
                contenPanel.revalidate();
                break;
            case "查看所有人申请":
                contenPanel.removeAll();
                JPanel jPanel28 = map.get(info);
                contenPanel.add(jPanel28);
                contenPanel.revalidate();
                break;
        }
    }

}
