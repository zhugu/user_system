package com.system.frame;

import com.system.model.User;
import com.system.ui.Style;
import com.system.utils.PermissionUtils;
import com.system.utils.SwitchUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel contentPanel;
    private JPanel leftPanel;
    private JButton cancelButton;
    private JLabel iconLabel;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel dateLabel;
    private JLabel wheatherLabel;
    private JLabel logoLabel;
    private JButton 注销登录Button;
    private JLabel depLabel;
    private JButton[] buttons;
    private int i = 0;
    private User user;
    private Map<String,List<String>> userAuthorityMap;
    private JButton[] jButtons ;
    private JPanel applyPanel;
    private JPanel searchFrame;
    private Integer j = 0;
    private PermissionUtils permissionUtils;
    private SwitchUtil switchUtil;
    private List<String> items;





    public MainFrame(User user, Map<String,List<String>> userAuthorityMap) {
        this.user = user;
        this.userAuthorityMap = userAuthorityMap;

        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        add(mainPanel);

        nameLabel.setText(user.getName());
        idLabel.setText(user.getUserid());
        iconLabel.setIcon(new ImageIcon(user.getPicture()));
        depLabel.setText(user.getJob());
        cancelButton.setBorderPainted(false);
        cancelButton.setBackground(Style.BLUE);
        Style.setBlueButtonStyle(cancelButton);
        Style.setBlueButtonStyle(注销登录Button);

        int group = userAuthorityMap.entrySet().size();
        buttons = new JButton[group];
        leftPanel.setLayout(new GridLayout(group,1));
        JPanel[] jPanels = new JPanel[group];


        //设置卡片布局
        CardLayout card = new CardLayout();
        contentPanel.setLayout(card);



        //循环Map数据
        for (Map.Entry<String, List<String>> entry : userAuthorityMap.entrySet()) {
            int count = entry.getValue().size();



            jPanels[i] = new JPanel(new GridLayout(2,1));
            jPanels[i].setPreferredSize(new Dimension(150,20));
            JPanel groupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            groupPanel.setPreferredSize(new Dimension(150,10));
            JPanel itemPanel = new JPanel(new GridLayout(count,1));
            itemPanel.setVisible(false);


            items =new ArrayList<>();

            //权限项按钮的初始化
            JPanel[] jPanels1 =new JPanel[20];
            jButtons = new JButton[20];


            //获得权限项按钮
            for (String item:entry.getValue()) {
                jButtons[j] = new JButton(item);
                items.add(item);
                jPanels1[j] = new JPanel(new FlowLayout(FlowLayout.CENTER));
                jPanels1[j].setSize(new Dimension(150,10));
                jPanels1[j].setBackground(Style.BACKGROUND2);
                jPanels1[j].add(jButtons[j]);
                itemPanel.add(jPanels1[j]);

                jButtons[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String info = e.getActionCommand();
                        permissionUtils = new PermissionUtils();
                        switchUtil = new SwitchUtil();
                        switchUtil.getaction(info,contentPanel,permissionUtils.getPermissions());
                    }
                });

                j ++;
            }


            //权限组按钮的设置
            buttons[i] = new JButton(entry.getKey());
            Style.setFunctionButton1(buttons[i]);
            groupPanel.add(buttons[i]);
            groupPanel.setBackground(Style.BACKGROUND1);
            jPanels[i].add(groupPanel);
            jPanels[i].add(itemPanel);
            jPanels[i].setBackground(Style.BACKGROUND2);
            leftPanel.add(jPanels[i]);

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!itemPanel.isVisible()){
                        itemPanel.setVisible(true);
                    }else {
                        itemPanel.setVisible(false);
                    }
                }
            });

            i++;
        }
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        注销登录Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.dispose();
                new LoginFrame();
            }
        });
    }

}
