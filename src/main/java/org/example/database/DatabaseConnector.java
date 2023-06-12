package org.example.database;

import org.example.app.QuizGame;
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

    public User getUser(String username) throws SQLException {
        Connection connection = createConnection();

        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM user WHERE username = (?)"
        );
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            return new User(resultSet.getString("username"));
        }

        return null;

    }

    public void addUser(User user) throws SQLException {

        Connection connection = createConnection();

        String sql = "INSERT INTO user (username) VALUES (?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());

        statement.executeUpdate();

        connection.close();

    }

    public User addOrRetrieve(String username) throws SQLException {

        User user = getUser(username);

        if(user != null){
            return user;
        }else{
            user = new User(username);
            addUser(user);
            return user;
        }



    }

    private Connection createConnection() throws SQLException {

        return DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);

    }

    public String getQuizName(int id) throws SQLException {

        Connection connection = createConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM quiz WHERE id = (?)");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString("quiz_name");
        }
        return null;
    }

    public ArrayList<QuizGame> getAllQuizzes() throws SQLException {

        Connection connection = createConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM quiz");

        ArrayList<QuizGame> quizGames = new ArrayList<>();

        while(resultSet.next()){
            QuizGame quizGame = new QuizGame(
                    resultSet.getString("quiz_name")
            );

            quizGames.add(quizGame);
        }

        connection.close();

        return quizGames;

    }
}
