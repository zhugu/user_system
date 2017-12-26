package com.system.frame;

import com.system.dao.RepublishDAO;
import com.system.factory.DAOFactory;
import com.system.model.Republish;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.Iterator;

import static javax.swing.SwingConstants.CENTER;

/**
 * @author 徐文倩
 * 查看员工奖惩信息
 */
public class UserPanel1 extends JPanel{
    private ImagePanel imagePanel;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer renderer,renderer1;
    private java.util.List<Republish> republishes;
    Iterator<Republish> iterater = null;
    private RepublishDAO republishDAO = DAOFactory.getRepublishDAOInstance();

    public UserPanel1() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        imagePanel = new ImagePanel(1085,750,"4.png");
        table = new JTable();
        scrollPane = new JScrollPane();
        dtm = new DefaultTableModel();
        renderer = new DefaultTableCellRenderer();
        renderer1 = new DefaultTableCellRenderer();
//        scrollPane.setViewportView(table);
        scrollPane.setOpaque(false);
        init();
        add(imagePanel);
        imagePanel.add(table);
        //add(scrollPane,CENTER);
    }
    private void init(){
        RepublishTable();
    }

    private void RepublishTable() {
        dtm = new DefaultTableModel();
        String[] titles = {"奖惩编号","工号","奖惩名称","奖惩日期","奖惩原因","奖惩结果"};
        dtm.setColumnIdentifiers(titles);
        table.setModel(dtm);
        renderer.setHorizontalAlignment(CENTER);
        table.setDefaultRenderer(Object.class,renderer);
        renderer1.setHorizontalAlignment(CENTER);
        renderer.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setDefaultRenderer(renderer1);
        String[] content = new String[6];
        try {
            republishes = republishDAO.getRP("101001");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        iterater = republishes.iterator();
        while (iterater.hasNext()){
            Republish republish = iterater.next();
            content[0] = String.valueOf(republish.getRpid());
            content[1] = republish.getUserid().toString();
            content[2] = republish.getRpname();
            content[3] = String.valueOf(republish.getRpdate());
            content[4] = republish.getRpreason();
            content[5] = republish.getReresult();
            dtm.addRow(content);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("个人奖惩信息");
        frame.setSize(1085,750);
        frame.setLocationRelativeTo(null);
        frame.add(new UserPanel1());
        frame.setVisible(true);
    }

}

