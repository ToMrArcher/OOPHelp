package org.example.app;

import org.example.database.DatabaseConnector;
import org.example.model.Question;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuizGame {

    private ArrayList<Question> questions;
    private String quizName;
    private int score;

    public QuizGame(String quizName) {
        this.questions = new ArrayList<>();
    }

    public void start(int id) throws SQLException {

        DatabaseConnector databaseConnector = new DatabaseConnector();
        quizName = databaseConnector.getQuizName(id);
        System.out.println(quizName);

    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
}
