package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.User;
import com.system.service.UserService;
import com.system.ui.Style;
import com.system.utils.ImgUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 徐文倩
 * 查看以及修改个人信息
 */
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
    private byte[] b;
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
        idLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(UserFrame1.this);//！！内部匿名类，访问外部类对象
                if (result == JFileChooser.APPROVE_OPTION) {
                    //正常选择一个文件
                    File file = chooser.getSelectedFile();//用户选择得到文件（非空）
                    if (file != null) {
                        String fileName = file.getAbsolutePath();//获得用户选择的图片的完整绝绝对路径
                        try {
                            b = ImgUtil.getImgByte(fileName);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        profileLabel.setIcon(new ImageIcon(b));//更新头像
                    }
                }

            }
        });
        编辑Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setEnabled(true);
                addressField.setEnabled(true);
                nationField.setEnabled(true);
                placeField.setEnabled(true);
                tellField.setEnabled(true);
                idnumberField.setEnabled(true);
            }
        });
        保存Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                user.setName(name);
                String address = addressField.getText();
                user.setAddress(address);
                String nation = nationField.getText();
                user.setNation(nation);
                String place = placeField.getText();
                user.setPlace(place);
                String tell = tellField.getText();
                user.setTel(tell);
                String idnumber = idnumberField.getText();
                user.setIdentityID(idnumber);
                boolean flag = false;
                flag = userService.updateUser(user);
                if(flag){
                    JOptionPane.showMessageDialog(null,"修改成功！");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        UserService userService = ServiceFactory.getUserServiceInstance();
        User user = null;
        user = userService.getUser("101005");
        JFrame frame = new JFrame("UserFrame1");
        frame.setContentPane(new UserFrame1(user).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
