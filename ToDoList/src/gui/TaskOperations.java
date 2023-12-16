package gui;

import javax.swing.*;
import java.sql.*;

public class TaskOperations {
    private String url = "jdbc:mysql://localhost:3306/taskbase";
    private String username = "root";
    private String password = "";
    private Connection connection;
    private Statement statement;
    private ResultSet query;

    public void sendTask(String taskLabel) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);

        String query = "INSERT INTO tasks (text) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, taskLabel);

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        }
        connection.close();
    }
}
