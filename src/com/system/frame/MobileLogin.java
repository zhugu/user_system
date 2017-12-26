package com.system.frame;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.system.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.system.utils.SendCode.sendSms;

/**
 * @author 缪瑞祥
 */
public class MobileLogin {
    private JPanel contentPanel;
    private UserService userService;
    private static String captcha;
    private static String phone;

    public void MobileLogin(JPanel contentPanel,UserService userService) {
        this.contentPanel = contentPanel;
        this.userService = userService;

        JPanel jPanels[];
        JPanel jPanel = new JPanel(new GridLayout(5,1));
        jPanel.setPreferredSize(new Dimension(400,400));
        jPanel.setOpaque(false);
        jPanels = new JPanel[5];
        for(int i=0;i<jPanels.length;i++){
            jPanels[i] = new JPanel();
            jPanels[i].setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
            jPanels[i].setBackground(null);
            jPanels[i].setOpaque(false);
        }
        JLabel idLabel = new JLabel("手机号");
        idLabel.setFont(new Font("仿宋",Font.BOLD,18));
        JLabel passwordLabel = new JLabel("验证码");
        passwordLabel.setFont(new Font("仿宋",Font.BOLD,18));
        JTextField phoneTextField = new JTextField();
        phoneTextField.setPreferredSize(new Dimension(200,30));
        phoneTextField.setOpaque(false);
        JTextField captchaTextField = new JTextField();
        captchaTextField.setPreferredSize(new Dimension(200,30));
        captchaTextField .setOpaque(false);
        JButton loginButton = new JButton("登录");
        loginButton.setFont(new Font("仿宋",Font.BOLD,18));
        loginButton.setPreferredSize(new Dimension(75,30));
        JButton returnButton = new JButton("返回");
        returnButton.setFont(new Font("仿宋",Font.BOLD,18));
        returnButton.setPreferredSize(new Dimension(75,30));
        JButton mobileButton = new JButton("获取验证码");
        mobileButton.setFont(new Font("仿宋",Font.BOLD,13));
        mobileButton.setPreferredSize(new Dimension(120,30));
        jPanels[1].add(idLabel);jPanels[1].add(phoneTextField);
        jPanels[2].add(passwordLabel);jPanels[2].add(captchaTextField);
        jPanels[3].add(mobileButton);
        jPanels[4].add(loginButton);jPanels[4].add(returnButton);
        contentPanel.add(jPanel);

        for(int i = 0;i<jPanels.length;i++){
            jPanel.add(jPanels[i]);
        }

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                StringBuffer str = new StringBuffer();
                for (int i = 0;i<6;i ++){
                    str.append(random.nextInt(10));
                }
                captcha = str.toString();
                phone = phoneTextField.getText();
                try {
                    SendSmsResponse response = sendSms(phone,str.toString());
                } catch (ClientException e1) {
                    e1.printStackTrace();
                }finally {
                    JOptionPane.showMessageDialog(null,"发送成功！");
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phone = phoneTextField.getText();
                String number = captchaTextField.getText();
                Map<String, Object> map = null;
                try {
                    map = userService.phoneLogin(phone,number,captcha);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                //输出登陆成功与否的信息
                JOptionPane.showMessageDialog(null,map.get("info"));
                System.out.println(map.get("user"));
                //取得该用户的权限组和相应权限项
                Map<String, java.util.List<String>> userPermissionMap = (Map<String, java.util.List<String>>) map.get("userPermissionMap");
//                for (Map.Entry<String, List<String>> entry : userPermissionMap.entrySet()) {
//                    System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
//                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.setVisible(false);
                UserLogin userLogin = new UserLogin();
                userLogin.UserLogin(contentPanel,userService);
            }
        });
    }
}
