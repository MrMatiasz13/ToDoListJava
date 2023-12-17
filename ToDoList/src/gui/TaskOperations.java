package gui;

import javax.swing.*;
import java.sql.*;

public class TaskOperations extends Task{
    private String url = "jdbc:mysql://localhost:3306/taskbase";
    private String username = "root";
    private String password = "";

    public void sendTask(String taskLabel) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        String query = "INSERT INTO tasks (text, isdone) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, taskLabel);
            if(isDone){
                preparedStatement.setInt(2, 2);
            }
            else {
                preparedStatement.setInt(2,1);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        }
        connection.close();
    }

    public void getTasks(JPanel listPanel) throws SQLException {
        Connection connection = DriverManager.getConnection(url,username, password);

        Statement statement = connection.createStatement();

        ResultSet query = statement.executeQuery("SELECT * FROM tasks");

        while (query.next()){
            labelText = query.getString(2);
            int done = query.getInt(3);

            if(done == 2){
                taskLabel.setText("<html><strike>" + labelText + "</strike></html>b");
            }
            else{
                taskLabel.setText(labelText);
            }

            Task task = new Task();
            listPanel.add(task);
            revalidate();
        }
    }
}
