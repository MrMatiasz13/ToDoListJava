package gui;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ToDoListGUI extends JFrame implements ActionListener {
    public JPanel listPanel;
    private JPanel addPanel;
    private JTextField taskTextField;
    private JButton addBtn;
    private JButton refresBtn;

    static TaskOperations taskOperations = new TaskOperations();

    public ToDoListGUI() throws SQLException {
        super(CommonConstants.FRAME_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        addGUIComponent();
    }

    public void addGUIComponent() throws SQLException {
        listPanel = new JPanel();
        listPanel.setPreferredSize(new Dimension(400,350));
        listPanel.setBackground(CommonConstants.COLOR_SECONDARY);
        listPanel.setLayout(new GridLayout(10,1,0,5));

        JLabel titleLabel = new JLabel("ToDoList");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        listPanel.add(titleLabel);

        addPanel = new JPanel();
        addPanel.setPreferredSize(new Dimension(400,120));
        addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        addPanel.setBackground(CommonConstants.COLOR_PRIMARY);

        this.add(listPanel, BorderLayout.NORTH);
        this.add(addPanel, BorderLayout.SOUTH);

        // task
        taskTextField = new JTextField(CommonConstants.TEXTFIELD);
        taskTextField.setFont(new Font("Dialog", Font.PLAIN, 18));

        addBtn= new JButton("Add");
        addBtn.setFont(new Font("Dialog", Font.PLAIN, 18));
        addBtn.setFocusable(false);
        addBtn.addActionListener(this);

        refresBtn = new JButton("Refresh");
        refresBtn.setFont(new Font("Dialog", Font.PLAIN, 18));
        refresBtn.setFocusable(false);
        refresBtn.addActionListener(this);

        addPanel.add(taskTextField);
        addPanel.add(addBtn);
        addPanel.add(refresBtn);



        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            String taskText = taskTextField.getText();

            if(taskText.isEmpty()){
                return;
            }
            else {
                try {
                    taskOperations.sendTask(taskText);
                } catch (Exception a) {
                    System.out.println(a);
                }
            }
        }
    }
}