package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.Department;
import com.system.model.User;
import com.system.model.Wages;
import com.system.service.DepartmentService;
import com.system.service.ExportService;
import com.system.utils.ExportUserExcel;
import com.system.utils.ExportWagesExcel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 张康宁
 * @date 2017/12/20
 */
public class SuperAdministratorFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JButton 职务管理Button;
    private JButton 部门管理Button;
    private JButton 数据导出Button;
    private JButton 初始化数据Button;
    private JPanel card1;
    private JPanel card2;
    private JPanel card3;
    private JPanel card4;
    private JLabel picture;
    private JLabel label1;
    private JLabel label2;
    private JTable table1;
    private JButton 员工信息button;
    private JButton 工资报表Button;
    private JTable table2;
    private JButton 导出员工信息Button;
    private JButton 导出工资报表Button;
    private JButton outButton;
    private JTable table3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton 删除Button;
    private DefaultTableModel dtm1;
    private DefaultTableModel dtm2;
    private DefaultTableModel dtm3;
    private List<User> users;
    private List<Wages> wages;
    private List<Department> departments;
    private ExportService exportService = ServiceFactory.getExportServiceInstance();
    private DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();
    private int row;

    public SuperAdministratorFrame() {
        init();
        setTitle("超级管理员界面");
        this.setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void init() {
        add(mainPanel);

        职务管理Button.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        部门管理Button.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        数据导出Button.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        初始化数据Button.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        outButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));

        Dimension size = new Dimension(200,80);
        职务管理Button.setPreferredSize(size);
        部门管理Button.setPreferredSize(size);
        数据导出Button.setPreferredSize(size);
        初始化数据Button.setPreferredSize(size);
        outButton.setPreferredSize(size);

        职务管理Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        部门管理Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        数据导出Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        初始化数据Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        outButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CardLayout card = new CardLayout();
        centerPanel.setLayout(card);

        centerPanel.add("职务管理",card1);
        centerPanel.add("部门管理",card2);
        centerPanel.add("数据导出",card3);
        centerPanel.add("初始化数据",card4);

//        JTextField jTextField = new JTextField();
//        jTextField.setBounds(600,100,100,100);
//        card2.setLayout(new FlowLayout());
//        card2.add(jTextField);

        职务管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(centerPanel,"职务管理");
            }
        });

        部门管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(centerPanel,"部门管理");
                showDepartmentTable();
            }

            private void showDepartmentTable() {
                dtm3 = new DefaultTableModel();
                String[] titles = {"部门名称","部门介绍","部门电话"};
                dtm3.setColumnIdentifiers(titles);
                table3.setModel(dtm3);
                DefaultTableCellRenderer r = new DefaultTableCellRenderer();
                r.setHorizontalAlignment(JLabel.CENTER);
                table3.setDefaultRenderer(Object.class, r);
                DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
                r1.setHorizontalAlignment(JLabel.CENTER);
                r1.setBackground(Color.LIGHT_GRAY);
                table3.getTableHeader().setDefaultRenderer(r1);
                String[] content = new String[3];
                departments = departmentService.getAll();
                Iterator<Department> iterator = departments.iterator();
                while (iterator.hasNext()) {
                    Department department = iterator.next();
                    content[0] = department.getDepartmentname();
                    content[1] = department.getIntroduction();
                    content[2] = department.getDepartmenttel();
                    dtm3.addRow(content);
                }
                card2.revalidate();
                centerPanel.revalidate();
            }
        });

//        table3.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                row = table3.getSelectedRow();
//            }
//        });
//
//
//
//        删除Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });


        数据导出Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(centerPanel,"数据导出");
            }
        });

        员工信息button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUserTable();
            }

            private void showUserTable() {
                dtm1 = new DefaultTableModel();
                String[] titles = {"工号","名字","性别","住址","籍贯","民族","部门","职位","电话","身份证号"};
                dtm1.setColumnIdentifiers(titles);
                table2.setModel(dtm1);
                DefaultTableCellRenderer r = new DefaultTableCellRenderer();
                r.setHorizontalAlignment(JLabel.CENTER);
                table2.setDefaultRenderer(Object.class, r);
                DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
                r1.setHorizontalAlignment(JLabel.CENTER);
                r1.setBackground(Color.LIGHT_GRAY);
                table2.getTableHeader().setDefaultRenderer(r1);
                String[] content = new String[10];
                users = exportService.getAllUser();
                Iterator<User> iterator = users.iterator();
                while (iterator.hasNext()) {
                    User user = iterator.next();
                    content[0] = user.getUserid();
                    content[1] = user.getName();
                    content[2] = user.getSex();
                    content[3] = user.getAddress();
                    content[4] = user.getPlace();
                    content[5] = user.getNation();
                    content[6] = String.valueOf(user.getDepartmentid());
                    content[7] = user.getJob();
                    content[8] = user.getTel();
                    content[9] = user.getIdentityID();
                    dtm1.addRow(content);
                }
                card3.revalidate();
                centerPanel.revalidate();
            }
        });

        导出员工信息Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportUserExcel.exportData(users);
                JOptionPane.showMessageDialog(null, "导出成功");
            }
        });

        工资报表Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWagesTable();
            }

            private void showWagesTable() {
                dtm2 = new DefaultTableModel();
                String[] titles = {"工号","基本工资","全勤奖","工龄补助工资","处罚扣除工资","五险一金","个人所得税","应发工资","实发工资","发放时间"};
                dtm2.setColumnIdentifiers(titles);
                table2.setModel(dtm2);
                DefaultTableCellRenderer r = new DefaultTableCellRenderer();
                r.setHorizontalAlignment(JLabel.CENTER);
                table2.setDefaultRenderer(Object.class, r);
                DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
                r1.setHorizontalAlignment(JLabel.CENTER);
                r1.setBackground(Color.LIGHT_GRAY);
                table2.getTableHeader().setDefaultRenderer(r1);
                String[] content = new String[10];
                 wages = exportService.getAllWages();
                Iterator<Wages> iterator = wages.iterator();
                while (iterator.hasNext()) {
                    Wages wages = iterator.next();
                    content[0] = wages.getUserid();
                    content[1] = String.valueOf(wages.getBasicwages());
                    content[2] = String.valueOf(wages.getAttendancereward());
                    content[3] = String.valueOf(wages.getYearwages());
                    content[4] = String.valueOf(wages.getPublish());
                    content[5] = String.valueOf(wages.getInsurance());
                    content[6] = String.valueOf(wages.getTax());
                    content[7] = String.valueOf(wages.getWages());
                    content[8] = String.valueOf(wages.getTruewages());
                    content[9] = String.valueOf(wages.getDate());
                    dtm2.addRow(content);
                }
                card3.revalidate();
                centerPanel.revalidate();
            }
        });

        导出工资报表Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportWagesExcel.exportWagesData(wages);
                JOptionPane.showMessageDialog(null,"导出成功");
            }
        });

        初始化数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(centerPanel,"初始化数据");
//                new WarningDialog("您确定要初始化吗？这可能会使您丢失所有数据。");
            }
        });

        outButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperAdministratorFrame.this.dispose();
            }
        });
    }


    public static void main(String[] args) {
        new SuperAdministratorFrame();
    }
}
