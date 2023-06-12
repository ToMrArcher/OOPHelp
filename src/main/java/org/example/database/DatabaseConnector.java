package org.example.database;

import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector {

    public static final String MYSQL_URL = "jdbc:mysql://localhost/quizdb";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "qwer1234";

    public ArrayList<User> getAllUsers() throws SQLException {

        Connection connection = createConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

        ArrayList<User> users = new ArrayList<>();

        while(resultSet.next()){
            User user = new User(
                    resultSet.getString("username")
            );

            users.add(user);
        }

        connection.close();

        return users;

    }

    public void addUser(User user) throws SQLException {

        Connection connection = createConnection();

    }

    private Connection createConnection() throws SQLException {

        return DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);

    }

}
