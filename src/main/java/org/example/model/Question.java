package org.example.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {

    private String questionText;
    private ArrayList<Answer> answers;

    public void printQuestion(){
        System.out.println(questionText);
        for(int i = 1; i <= answers.size(); i++){
            System.out.println(i + ". " + answers.get(i-1));
        }
    }

    public boolean getAnswerFromUser(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String inputFromUser = scanner.nextLine();
            int pickedAnswer = Integer.parseInt(inputFromUser);
            if(pickedAnswer < 0 || pickedAnswer > answers.size()){
                System.out.println("Please pick a valid answer");
                continue;
            }
            if(answers.get(pickedAnswer).isCorrect()){
                return true;
            }
            return false;
        }
    }

}
