import gui.TaskOperations;
import gui.ToDoListGUI;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ToDoListGUI toDoListGUI = new ToDoListGUI();
        TaskOperations taskOperations = new TaskOperations();

        taskOperations.getTasks(toDoListGUI.listPanel);
    }
}