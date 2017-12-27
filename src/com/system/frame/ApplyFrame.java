package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.Apply;
import com.system.model.User;
import com.system.service.ApplyService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by asus on 2017/12/25.
 */
public class ApplyFrame extends JFrame{
    private JPanel mainPanel;
    private JLabel JLabel1;
    private JLabel JLabel2;
    private JLabel JLabel3;
    private JLabel JLabel4;
    private JLabel JLabel5;
    private JTextArea textArea1;
    private JRadioButton 通过RadioButton;
    private JRadioButton 驳回RadioButton;
    private JButton 确认Button;
    private JButton 返回Button;
    private JLabel JLabel6;
    private JLabel JLabel7;
    private JLabel JLabel8;
    private Apply apply;
    private User user;
    private String flag;
    private ApplyService applyService = ServiceFactory.getApplyServiceInstance();

    public ApplyFrame(Apply apply){
        add(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(800,600);

        this.apply = apply;
        try {
            user = ServiceFactory.getUserServiceInstance().getUser(apply.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JLabel6.setText(apply.getUserid());
        JLabel7.setText(user.getName());
        JLabel8.setText(apply.getApplydate().toString());
        textArea1.append(apply.getApplyinfo());
        ButtonGroup group = new ButtonGroup();
        group.add(通过RadioButton);
        group.add(驳回RadioButton);
        if (apply.getExamination().equals("通过"))
        {
            通过RadioButton.isSelected();
        }
        if (apply.getExamination().equals("驳回"))
        {
            驳回RadioButton.isSelected();
        }
        确认Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (通过RadioButton.isSelected()){
                    flag = " 通过";
                    apply.setExamination(flag);
                } if (驳回RadioButton.isSelected())
                {
                    flag = " 驳回 ";
                    apply.setExamination(flag);
                }
                try {
                    applyService.update(apply);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                ApplyFrame.this.dispose();
            }
        });
        返回Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
