package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.Wages;
import com.system.service.WageServiceDAO;
import com.system.utils.DialogDatePicker;
import com.system.utils.ExportExcel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

/**
 * @author 王宁
 * on 2017/12/25.
 * 查询工资面板
 */
public class SearchPanel extends  JPanel{
    private JPanel mainpanel;
    private JTable wagestable;
    private JScrollPane scrollpane;
    private JTextField keyfield;
    private JButton searchbutton;
    private JButton gettime;
    private JLabel timelabel;
    private JComboBox comboBox1;
    private JButton extortdata;
    private StringBuffer condition = new StringBuffer();
    private String dateString;
    private String basicwages=null;
    private DefaultTableModel dtm;
    private java.util.List<Wages>wages;
    private WageServiceDAO wageServiceDAO= ServiceFactory.getWageServiceDAOInstance();

    public SearchPanel() {
        showTabel();

        gettime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txtDate = new JTextField();
                //弹出时间选择框
                new DialogDatePicker(true, txtDate, 750, 450);
                //获得日期
                dateString = txtDate.getText();
                timelabel.setText(dateString);
                condition=new StringBuffer();
                condition.append("WHERE date= '"+dateString+"' ");
                updateModel();
            }
        });
        searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords =keyfield.getText();
                wages = wageServiceDAO.querylike(keywords);
                int count = dtm.getRowCount();
                for (int i = count - 1; i >= 0; i--) {
                    dtm.removeRow(i);
                }
                for (Wages wages1 : wages) {
                    add(wages1);
                }
            }
        });
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    basicwages=comboBox1.getSelectedItem().toString();
                    condition=new StringBuffer();
                    condition.append("WHERE basicwages="+basicwages);
                    //更新数据
                    updateModel();
                }
            }
        });
        extortdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportExcel.exportData(wages);
                JOptionPane.showMessageDialog(null,"导出成功");
            }
        });
    }

    public void showTabel(){
        dtm=new DefaultTableModel();
        String[] title={"工号","基本工资","全勤奖","工龄工资","惩罚","保险","个税","应得工资","实得工资","发放时间"};
        dtm.setColumnIdentifiers(title);
        wagestable.setModel(dtm);
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        wagestable.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        wagestable.getTableHeader().setDefaultRenderer(r1);
        String[] content=new String[11];
        wages=wageServiceDAO.getAllWages();
        Iterator<Wages> iterator = wages.iterator();
        while (iterator.hasNext()) {
            Wages wages = iterator.next();
            content[0] = wages.getUserid();
            content[1] = String.valueOf(wages.getBasicwages());
            content[2] = String.valueOf(wages.getAttendancereward());
            content[3] = String.valueOf(wages.getYearwages());
            content[4]= String.valueOf(wages.getPublish());
            content[5]= String.valueOf(wages.getInsurance());
            content[6]= String.valueOf(wages.getTax());
            content[7]= String.valueOf(wages.getWages());
            content[8]= String.valueOf(wages.getTruewages());
            content[9]= String.valueOf(wages.getDate());
            dtm.addRow(content);
        }
    }

    /**
     * 表格增加一行数据
     * @param
     */
    public void add(Wages wages) {
        Object[] rowData = {wages.getUserid(),wages.getBasicwages(),wages.getAttendancereward(),wages.getYearwages(),wages.getPublish(),
                        wages.getInsurance(),wages.getTax(),wages.getWages(),wages.getTruewages(),wages.getDate()};
        dtm.addRow(rowData);
    }

    /**
     * 更新表格模型数据
     */
    public void updateModel() {
        wages = wageServiceDAO.queryfilter(condition.toString());
        int count = dtm.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (Wages wages1 : wages) {
            add(wages1);
        }
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SearchPanel");
        frame.setContentPane(new SearchPanel().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,750);
        frame.setVisible(true);
    }
}
