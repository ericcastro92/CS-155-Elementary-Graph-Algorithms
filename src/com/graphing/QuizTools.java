package com.graphing;

import java.util.ArrayList;

/**
 *
 * @author Jonathan Yee
 */
public class QuizTools {

    public static ArrayList<Quiz> quiz = new ArrayList<>();
    private static int qCounter = 0;
    
    public static void main() {
        quizMaker();

    }

    public static void quizMaker() {
        Quiz temp = new Quiz();
        temp.setQuestion("How can a graph G = (V,E) be represented by?");
        temp.setAnswer1("A. Adjacency List.");
        temp.setAnswer2("B. Adjacency Matrix.");
        temp.setAnswer3("C. Both.");
        temp.setAnswer4("D. Neither.");
        temp.setCorrect(3);

        quiz.add(temp);

    }
}
