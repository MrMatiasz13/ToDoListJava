package gui;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI extends JFrame implements ActionListener {
    private JPanel listPanel;
    private JPanel addPanel;
    private JTextField taskTextField;
    private JButton addBtn;
    static TaskOperations taskOperations = new TaskOperations();
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
        listPanel.setBackground(CommonConstants.COLOR_SECONDARY);
        listPanel.setLayout(new GridLayout(10,1,0,5));

        JLabel titleLabel = new JLabel("ToDoList");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        listPanel.add(titleLabel);

        addPanel = new JPanel();
        addPanel.setPreferredSize(new Dimension(400,90));
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

        addPanel.add(taskTextField);
        addPanel.add(addBtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            String taskText = taskTextField.getText();
            try {
                taskOperations.sendTask(taskText);
            } catch (Exception a) {
                System.out.println(a);
            }

            Task task = new Task();
            listPanel.add(task);
            revalidate();
        }
    }

    public void getTasks(){

    }
}