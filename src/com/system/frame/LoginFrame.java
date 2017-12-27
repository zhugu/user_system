package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.service.UserService;
import com.system.thread.Thread;
import com.system.utils.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 徐文倩，缪瑞祥
 */
public class LoginFrame {
    private JPanel mainPanel;
    private ImagePanel imagePanel;
    private ImagePanel contentPanel;
    private UserService userService;

    public LoginFrame(){
        userService = ServiceFactory.getUserServiceInstance();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        imagePanel = new ImagePanel(screenSize.width,screenSize.height,"1.png");
        imagePanel.setLayout(new GridLayout(2,1));
        mainPanel.add(imagePanel);

        contentPanel = new ImagePanel(480,480,"bg.png");
        contentPanel.setOpaque(false);

        JLabel closeLabel = new JLabel();
        closeLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/icon/关闭.png")));
        closeLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
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
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,1));
        JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jPanel1.add(closeLabel);
        Font font = new Font("华文新魏",Font.BOLD,70);
        JLabel titleLabel = new JLabel("企  业  管  理  系  统");
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.WHITE);
        jPanel2.add(titleLabel);
        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
        topPanel.setOpaque(false);
        topPanel.add(jPanel1);
        topPanel.add(jPanel2);
        imagePanel.add(topPanel);

        UserLogin userLogin = new UserLogin();
        userLogin.UserLogin(contentPanel,userService);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        centerPanel.setOpaque(false);
        centerPanel.add(contentPanel);
        imagePanel.add(centerPanel);

        Thread thread = new Thread();
        thread.setImagePanel(imagePanel);
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(thread,2,2, TimeUnit.SECONDS);
    }



    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("LoginFrame");
        frame.setContentPane(new LoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
