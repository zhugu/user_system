package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.service.WageServiceDAO;
import com.system.utils.DialogDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author 王宁
 * on 2017/12/25.
 * 工资录入面板
 */
public class WageFrame extends JFrame{
    private JPanel mainpanel;
    private JPanel contentpanel;
    private JLabel titlelabel;
    private JTextField accountfield;
    private JLabel label1;
    private JTextField basicwages;
    private JTextField attentionwages;
    private JTextField yearwages;
    private JTextField wagesfeild;
    private JLabel label3;
    private JLabel label2;
    private JTextField publish;
    private JTextField insurance;
    private JTextField tax;
    private JLabel label4;
    private JTextField truewagesfield;
    private JButton OKbutton;
    private JButton 取消Button;
    private JButton gettimebutton;
    private JLabel timelabel;
    private AddFrame addFrame;
    private String dateString;
    private WageServiceDAO wageServiceDAO= ServiceFactory.getWageServiceDAOInstance();

    public WageFrame(AddFrame addFrame){
        this.addFrame=addFrame;
        init();
        setTitle("工资录入面板");
        setSize(600,700);
        setLocationRelativeTo(null);
          mainpanel=new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/img/bg.jpg"));
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(WageFrame.this.getWidth(), WageFrame.this.getHeight(), Image.SCALE_FAST));
                imageIcon.paintIcon(this, g, 0, 0);
            }
        };
        mainpanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,150));
        setVisible(true);
        contentpanel.setOpaque(false);
        contentpanel.setSize(new Dimension(680,700));
        mainpanel.add(contentpanel);
          add(mainpanel);
    }
    public void init(){
        //获得工号
        accountfield.setText(addFrame.getAccount());
        //获取五险一金
        insurance.setText(String .valueOf(100));
        //获取发放工资日期
        gettimebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txtDate = new JTextField();
                //弹出时间选择框
                new DialogDatePicker(true, txtDate, 750, 450);
                //获得日期
                dateString = txtDate.getText();
                timelabel.setText(dateString);
            }
        });
        //wageServiceDAO.insertWages();
        OKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = null;
                try {
                    date =sdf.parse(dateString);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Date enrollment = new java.sql.Date(date.getTime());

            }
        });
    }
}
