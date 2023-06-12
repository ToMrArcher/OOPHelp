package org.example;

import org.example.database.DatabaseConnector;
import org.example.model.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        DatabaseConnector databaseConnector = new DatabaseConnector();

        System.out.println("Enter username of user to be added:");
        Scanner scanner = new Scanner(System.in);
        String usernameInput = scanner.nextLine();
        User user = new User(usernameInput);

        databaseConnector.addUser(user);

    }
}