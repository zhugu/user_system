package com.system.ui;

import com.system.factory.ServiceFactory;
import com.system.service.InitializationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by leovo on 2017/12/25.
 */
public class WarningDialog extends JDialog {
    private String info;
    private JLabel infoLabel;
    private JLabel warnIcon;
    private JButton confirmButton;
    private JButton cancelButton;
    private InitializationService initializationService = ServiceFactory.getInitializationServiceInstance();

    public WarningDialog(String info) {
        this.info = info;
        setModal(true);
        setTitle("警告框");
        setSize(800,600);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(new Color(79,193,176));
        infoLabel = new JLabel(info);
        infoLabel.setBounds(150,100,600,100);
        infoLabel.setFont(new Font("微软雅黑",Font.BOLD,24));
        add(infoLabel);
        confirmButton = new JButton("确认");
        confirmButton.setBounds(480,440,120,50);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    initializationService.deleteAll();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                WarningDialog.this.dispose();
                JOptionPane.showMessageDialog(null,"初始化成功");
            }
        });
        cancelButton = new JButton("取消");
        cancelButton.setBounds(180,440,120,50);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WarningDialog.this.dispose();
            }
        });
        add(cancelButton);
        add(confirmButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WarningDialog("您确定要初始化吗？这会使您丢失所有数据。");
    }

}
