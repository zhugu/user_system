package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.User;
import com.system.service.WageServiceDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

/**
 * @author 王宁
 *on 2017/12/25.
 * 显示员工面板
 */
public class AddFrame extends JPanel{
    private JPanel mainpanel;
    private JScrollPane scrollpane;
    private JTable membertabel;
    private JButton okbutton;
    private DefaultTableModel dtm;
    private int getrow;
    private String userid;
    private java.util.List<User>users;
    private WageServiceDAO wageServiceDAO= ServiceFactory.getWageServiceDAOInstance();

    public AddFrame(){
        showTabel();
        okbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                okbutton.setBackground(Color.CYAN);
            }
        });
        okbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                okbutton.setBackground(Color.WHITE);
            }
        });
        membertabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getrow=membertabel.getSelectedRow();
                userid=membertabel.getValueAt(getrow,0).toString();
            }
        });
        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getrow!=0){
                    new WageFrame(AddFrame.this);
                }else {
                    JOptionPane.showMessageDialog(null,"请选择你要发工资的对象！！！");
                }
            }
        });
    }

    public String getAccount(){
        return userid;
    }

    public void showTabel(){
        dtm=new DefaultTableModel();
        String[] title={"工号","姓名","性别","职位","电话","入职时间"};
        dtm.setColumnIdentifiers(title);
        membertabel.setModel(dtm);
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        membertabel.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        membertabel.getTableHeader().setDefaultRenderer(r1);
        String[] content=new String[7];
        users=wageServiceDAO.getAll();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            content[0] = user.getUserid();
            content[1] = user.getName();
            content[2] = user.getSex();
            content[3] = user.getJob();
            content[4]=user.getTel();
            content[5]= String.valueOf(user.getEntrytime());
            dtm.addRow(content);
        }
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddFrame");
        frame.setContentPane(new AddFrame().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,750);
        frame.setVisible(true);
    }
}
