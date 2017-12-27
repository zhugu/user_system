package com.system.frame;

import com.system.model.Inform;
import com.system.utils.DialogDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 邓益聪
 * 通知面板类的实现
 * Created by asus on 2017/12/24.
 */
public class InformPanel extends JPanel {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton 选择发布时间Button;
    private JButton 发布Button;
    private JButton 返回Button;
    private JLabel dateLabel;
    private Inform inform;
    private Date date;

    public InformPanel(){
        add(mainPanel);


        选择发布时间Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txtDate = new JTextField();
                //弹出时间选择框
                new DialogDatePicker(true, txtDate, 750, 450);
                //获得日期
                String dateString = txtDate.getText();
                dateLabel.setText(dateString);
            }
        });
        发布Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = textArea1.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
                Date now = new Date(System.currentTimeMillis());
                try {
                    date = sdf.parse(dateLabel.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

            }
        });
        返回Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
