/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphing;

/**
 *
 * @author Jonathan Yee
 */
public class Quiz {

    String question;
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    int correct;

    public Quiz() {

    }

    public void setQuestion(String q) {
        question = q;
    }

    public void setAnswer1(String a) {
        ans1 = a;
    }

    public void setAnswer2(String b) {
        ans2 = b;
    }

    public void setAnswer3(String c) {
        ans3 = c;
    }

    public void setAnswer4(String d) {
        ans4 = d;
    }

    public void setCorrect(int x) {
        correct = x;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer1() {
        return this.ans1;
    }

    public String getAnswer2() {
        return this.ans2;
    }

    public String getAnswer3() {
        return this.ans3;
    }

    public String getAnswer4() {
        return this.ans4;
    }

    public int getCorrect() {
        return this.correct;
    }

}
