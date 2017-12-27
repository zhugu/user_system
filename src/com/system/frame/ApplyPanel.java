package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.Apply;
import com.system.service.ApplyService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

/**
 * @author 邓益聪
 * 申请面板类的实现
 * Created by asus on 2017/12/24.
 */
public class ApplyPanel extends JPanel {
    private JPanel mainPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel infoLabel;
    private JTable table1;
    private JScrollPane jscrollPanel;
    private JButton checkButton;
    private DefaultTableModel defaultTableModel;
    private List<Apply> applyList;
    private List<Apply> applies;
    private int row;
    private Apply apply = null;
    private ApplyService applyService = ServiceFactory.getApplyServiceInstance();


    public ApplyPanel(){
        add(mainPanel);
        showtable();




        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = table1.getSelectedRow();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = searchField.getText();
                applies = applyService.queryLike(keywords);
                int count = defaultTableModel.getRowCount();
                for (int i = count - 1; i >= 0; i--) {
                    defaultTableModel.removeRow(i);
                }
                for (Apply apply : applies) {
                    add(apply);
                }
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rows = row;
                apply = applyService.getApply(table1.getValueAt(rows,1).toString());
                new ApplyFrame(apply);
            }
        });
    }

    private void add(Apply apply) {
        Object[] rowData = {apply.getApplyid(),apply.getUserid(),apply.getApplyinfo(),apply.getApplydate(),apply.getExamination()};
        defaultTableModel.addRow(rowData);
    }

    private void showtable(){
        defaultTableModel = new DefaultTableModel();
        //设置表头标题
        String []titles = {"序列号","申请人工号","申请事项","申请时间","审批情况"};
        defaultTableModel.setColumnIdentifiers(titles);
        //给表格设置数据模型
        table1.setModel(defaultTableModel);
        // 将单元格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        // 设置水平方向居中
        r.setHorizontalAlignment(JLabel.CENTER);
        table1.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        table1.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[7];
        //获取到数据库中所有用户信息
        applyList = applyService.getAllApply();
        Iterator<Apply> iterator = applyList.iterator();
        while (iterator.hasNext()) {
            Apply apply = iterator.next();
            content[0] = apply.getApplyid().toString();
            content[1] = apply.getUserid();
            content[2] = apply.getApplyinfo();
            content[3] = apply.getApplydate().toString();
            content[4] = apply.getExamination();
            defaultTableModel.addRow(content);
        }
        mainPanel.revalidate();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ApplyPanel");
        frame.setContentPane(new ApplyPanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
