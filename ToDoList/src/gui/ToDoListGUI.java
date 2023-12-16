package gui;

import constants.CommonConstants;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI extends JFrame implements ActionListener {
    private JPanel listPanel;
    private JPanel addPanel;
    private JTextField taskTextField;
    private JButton addBtn;

    private Color primary = new Color(55,0,179);
    private Color secondary = new Color(98,0,238);
    public ToDoListGUI(){
        super(CommonConstants.FRAME_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        addGUIComponent();
    }

    public void addGUIComponent(){
        listPanel = new JPanel();
        listPanel.setPreferredSize(new Dimension(400,280));
        listPanel.setBackground(secondary);
        listPanel.setLayout(new GridLayout(10,1,0,5));

        JLabel titleLabel = new JLabel("ToDoList");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        listPanel.add(titleLabel);

        addPanel = new JPanel();
        addPanel.setPreferredSize(new Dimension(400,90));
        addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        addPanel.setBackground(primary);

        this.add(listPanel, BorderLayout.NORTH);
        this.add(addPanel, BorderLayout.SOUTH);

        // task
        taskTextField = new JTextField(CommonConstants.TEXTFIELD);
        taskTextField.setFont(new Font("Dialog", Font.PLAIN, 18));

        addBtn= new JButton("Add");
        addBtn.setFont(new Font("Dialog", Font.PLAIN, 18));
        addBtn.setFocusable(false);
        addBtn.addActionListener(this);

        addPanel.add(taskTextField);
        addPanel.add(addBtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            Task task = new Task();
            listPanel.add(task);
            revalidate();
        }
    }
}