package gui;

import constants.CommonConstants;
import javax.swing.*;
import java.awt.*;

public class ToDoListGUI extends JFrame {
    public ToDoListGUI(){
        super(CommonConstants.FRAME_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        addGUIComponent();
        this.setVisible(true);
    }

    public void addGUIComponent(){
        JPanel listPanel = new JPanel();
        listPanel.setSize(CommonConstants.MAINPANEL_SIZE[0], CommonConstants.MAINPANEL_SIZE[1]);
        listPanel.setBackground(Color.LIGHT_GRAY);
        listPanel.setLayout(null);

        JLabel titleLabel = new JLabel("ToDoList");
        listPanel.add(titleLabel);

        JPanel addPanel = new JPanel();
        addPanel.setSize(CommonConstants.ADDPANEL[0], CommonConstants.ADDPANEL[1]);
        addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addPanel.setBackground(Color.gray);

        this.getContentPane().add(listPanel);
        this.getContentPane().add(addPanel);

        // task
        JTextField taskTextField = new JTextField(CommonConstants.TEXTFIELD);
        taskTextField.setFont(new Font("Dialog", Font.PLAIN, 18));

        JButton addBtn = new JButton("Add");
        addBtn.setFont(new Font("Dialog", Font.PLAIN, 18));

        addPanel.add(taskTextField);
        addPanel.add(addBtn);
    }
}