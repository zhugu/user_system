package com.system.frame;

import com.system.model.User;
import com.system.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserLogin {
    private JPanel contentPanel;
    private UserService userService;


    public void UserLogin(JPanel contentPanel,UserService userService) {
        this.contentPanel = contentPanel;
        this.userService = userService;

        JPanel jPanel = new JPanel(new GridLayout(5,1));
        jPanel.setPreferredSize(new Dimension(400,400));
        jPanel.setOpaque(false);
        JPanel jPanels[];
        jPanels = new JPanel[5];
        for(int i=0;i<jPanels.length;i++){
            jPanels[i] = new JPanel();
            jPanels[i].setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
            jPanels[i].setBackground(null);
            jPanels[i].setOpaque(false);
        }
        JLabel idLabel = new JLabel("账号");
        idLabel.setFont(new Font("仿宋",Font.BOLD,18));
        JLabel passwordLabel = new JLabel("密码");
        passwordLabel.setFont(new Font("仿宋",Font.BOLD,18));
        JTextField idTextField = new JTextField();
        idTextField.setPreferredSize(new Dimension(200,30));
        idTextField.setOpaque(false);
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setPreferredSize(new Dimension(200,30));
        passwordTextField .setOpaque(false);
        JButton loginButton = new JButton("登录");
        loginButton.setFont(new Font("仿宋",Font.BOLD,18));
        loginButton.setPreferredSize(new Dimension(75,30));
        JLabel mobileLabel = new JLabel("手机验证码登录");
        mobileLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/icon/手机.png")));
        mobileLabel.setFont(new Font("仿宋",Font.BOLD,18));
        mobileLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel.setVisible(false);
                MobileLogin mobileLogin = new MobileLogin();
                mobileLogin.MobileLogin(contentPanel,userService);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Object> map = null;
                try {
                    map = userService.userLogin(idTextField.getText(), passwordTextField.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                //输出登陆成功与否的信息
                JOptionPane.showMessageDialog(null,map.get("info"));

                //取得该用户的权限组和相应权限项
                Map<String, java.util.List<String>> userPermissionMap = (Map<String, java.util.List<String>>) map.get("userPermissionMap");
                if (map.get("info").equals("登录成功")){
                    new MainFrame((User) map.get("user"),userPermissionMap);
                }

            }
        });

        jPanels[1].add(idLabel);jPanels[1].add(idTextField);
        jPanels[2].add(passwordLabel);jPanels[2].add(passwordTextField);
        jPanels[3].add(loginButton);
        jPanels[4].add(mobileLabel);
        for(int i = 0;i<jPanels.length;i++){
            jPanel.add(jPanels[i]);
        }
        contentPanel.add(jPanel);

    }


}
