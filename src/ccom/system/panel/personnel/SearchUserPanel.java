package ccom.system.panel.personnel;

import com.system.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author 缪瑞祥
 */
public class SearchUserPanel extends JPanel{
    private List<User> user;
    private JComboBox departmentBox;
    private JComboBox sexBox;
    private JComboBox placeBox;
    private JTextField searchField;
    private JButton searchButton;
    private JScrollPane scrollPane;
    private JTable table;

    public SearchUserPanel() {
        this.user = user;

        setLayout(new BorderLayout());
        departmentBox = new JComboBox();
        sexBox = new JComboBox();
        placeBox = new JComboBox();
        searchField = new JTextField();
        searchButton = new JButton("搜索");
        JLabel jLabel = new JLabel();

        departmentBox.addItem("人事部");
        departmentBox.addItem("财务部");
        sexBox.addItem("男");
        sexBox.addItem("女");
        placeBox.addItem("江苏");
        placeBox.addItem("山东");
        placeBox.addItem("浙江");
        searchField.setPreferredSize(new Dimension(100,30));
        jLabel.setPreferredSize(new Dimension(500,30));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,10));
        topPanel.setBackground(Color.WHITE);
        topPanel.add(departmentBox);
        topPanel.add(sexBox);
        topPanel.add(placeBox);
        topPanel.add(jLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);









        add(topPanel,BorderLayout.NORTH);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("ce78");
        frame.setSize(1200,1200);
        frame.setLocationRelativeTo(null);
        frame.add(new SearchUserPanel());
        frame.setVisible(true);
    }
}
