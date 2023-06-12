package org.example.app;

import org.example.database.DatabaseConnector;
import org.example.model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public User loggedInUser;

    public App() {
        loggedInUser = null;
    }

    public void start() throws SQLException {

        DatabaseConnector databaseConnector = new DatabaseConnector();
        Scanner scanner = new Scanner(System.in);

        boolean userIsPlaying = true;

        while (userIsPlaying){
            if(loggedInUser == null){
                System.out.println("Hello!\nWelcome to the best quiz app ever!!");
                System.out.println("Please enter your username");
                String username = scanner.nextLine();
                loggedInUser = databaseConnector.addOrRetrieve(username);
            }else{
                System.out.println(".");
            }

        }

        databaseConnector.addUser(user);

    }
}
