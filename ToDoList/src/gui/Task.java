package gui;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task extends JPanel implements ActionListener {

    static String labelText;
    static JLabel taskLabel;

    private JButton doneBtn;

    static boolean isDone;
    Task(){
        this.setSize(400,50);
        this.setLayout(new BorderLayout());
        this.setBackground(CommonConstants.COLOR_PRIMARY);

        // task label
        taskLabel = new JLabel(labelText);
        taskLabel.setForeground(Color.white);
        taskLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        taskLabel.setPreferredSize(new Dimension(400,90));

        this.add(taskLabel, BorderLayout.WEST);

        // done button
        doneBtn = new JButton("Done");
        doneBtn.setFont(new Font("Dialog", Font.BOLD, 10));
        doneBtn.setPreferredSize(new Dimension(40,30));
        doneBtn.setBorder(BorderFactory.createEmptyBorder());
        doneBtn.setFocusable(false);
        doneBtn.addActionListener(this);

        this.add(doneBtn, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == doneBtn){
            isDone = true;
        }
    }
}