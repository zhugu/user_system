package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.User;
import com.system.model.Wages;
import com.system.service.UserService;
import com.system.ui.Style;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author 徐文倩
 * 查看薪资
 */
public class UserFrame2 {
    private JButton 查看工资报表Button;
    private JLabel 编号Label;
    private JLabel 工号Label;
    private JLabel 基本工资Label;
    private JLabel 全勤奖Label;
    private JLabel 工龄工奖Label;
    private JLabel 惩Label;
    private JLabel 五险一金Label;
    private JLabel 个税Label;
    private JLabel 应发工资Label;
    private JLabel 实发工资Label;
    private JLabel 时间Label;
    private JPanel mainPanel;
    private  Wages wages;

    public UserFrame2(Wages wages){
        this.wages = wages;
        init();
    }
    public void init(){
        Style.setBlueButtonStyle(查看工资报表Button);
       // 编号Label.setText(String.valueOf(wages.getWagesid()));
        工号Label.setText(wages.getUserid());
        基本工资Label.setText(String.valueOf(wages.getBasicwages()));
        全勤奖Label.setText(String.valueOf(wages.getAttendancereward()));
        工龄工奖Label.setText(String.valueOf(wages.getYearwages()));
        惩Label.setText(String.valueOf(wages.getPublish()));
        五险一金Label.setText(String.valueOf(wages.getInsurance()));
        个税Label.setText(String.valueOf(wages.getTax()));
        应发工资Label.setText(String.valueOf(wages.getWages()));
        实发工资Label.setText(String.valueOf(wages.getTruewages()));
        时间Label.setText(String.valueOf(wages.getDate()));
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        UserService userService = ServiceFactory.getUserServiceInstance();
        Wages wages = null;
        try {
            wages = userService.getWages("101001" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("UserFrame2");
        frame.setContentPane(new UserFrame2(wages).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
