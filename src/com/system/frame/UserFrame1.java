package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.User;
import com.system.service.UserService;
import com.system.ui.Style;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserFrame1 extends JPanel {
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField placeField;
    private JTextField nationField;
    private JTextField tellField;
    private JTextField idnumberField;
    private JLabel idLabel;
    private JLabel profileLabel;
    private JLabel sexLabel;
    private JLabel depidLabel;
    private JLabel jobLabel;
    private JLabel entrytimeLabel;
    private JButton 编辑Button;
    private JButton 保存Button;
    private User user;
    private UserService userService = ServiceFactory.getUserServiceInstance();

    public UserFrame1(User user) {
        this.user = user;
        init();

    }

    public void init(){
        idLabel.setText(user.getUserid());
        nameField.setText(user.getName());
        profileLabel.setIcon(new ImageIcon(user.getPicture()));
        sexLabel.setText(user.getSex());
        addressField.setText(user.getAddress());
        nationField.setText(user.getNation());
        placeField.setText(user.getPlace());
        depidLabel.setText(String.valueOf(user.getDepartmentid()));
        jobLabel.setText(user.getJob());
        tellField.setText(user.getTel());
        entrytimeLabel.setText(String.valueOf(user.getEntrytime()));
        idnumberField.setText(user.getIdentityID());
        Style.setBlueButtonStyle(编辑Button);
        Style.setBlueButtonStyle(保存Button);
        编辑Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        保存Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        UserService userService = ServiceFactory.getUserServiceInstance();
        User user = null;
        try {
            user = userService.getUser("101001");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("UserFrame1");
        frame.setContentPane(new UserFrame1(user).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
