package com.system.frame;

import com.system.factory.ServiceFactory;
import com.system.model.Inform;
import com.system.service.InformService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by asus on 2017/12/26.
 */
public class InformPanel2 extends JPanel{
    private JPanel mainPanel;
    private JButton cancelButton;
    private JLabel titleLabel;
    private JTable table1;
    private JButton 删除Button;
    private DefaultTableModel defaultTableModel;
    private java.util.List<Inform> informs;
    private InformService informService = ServiceFactory.getInformServiceInstance();
    private Integer[] rows;


    public InformPanel2(){
        add(mainPanel);
        showTable();
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        删除Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> ids = new ArrayList<>();
                //遍历选中的多行
                for (int i : rows) {
                    ids.add(table1.getValueAt(i, 0).toString());
                }
                //result容量最大就是记录总数
                int[] result = new int[informs.size()];
                //调用批量删除方法，得到一个整型数组（受影响的记录行）
                result = informService.batchDelete(ids);

                if (result.length != 0) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    //从表格模型中移除掉已经删除的记录
                    for (int i = rows.length - 1; i >= 0; i--) {
                        defaultTableModel.removeRow(rows[i]);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }
            
        });
    }

    private void showTable() {
        defaultTableModel = new DefaultTableModel();
        //设置表头标题
        String []titles = {"序列号","通知时间","通知内容"};
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
        String[] content = new String[3];
        //获取到数据库中所有用户信息
        informs = informService.getAllInform();
        Iterator<Inform> iterator = informs.iterator();
        while (iterator.hasNext()) {
            Inform inform = iterator.next();
            content[0] = inform.getInformid().toString();
            content[1] = inform.getInformtime().toString();
            content[2] = inform.getInforminfo().toString();

            defaultTableModel.addRow(content);
        }
        mainPanel.revalidate();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
