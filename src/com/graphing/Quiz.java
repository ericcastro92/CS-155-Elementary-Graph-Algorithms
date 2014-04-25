/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.graphing;

/**
 *
 * @author Augusta Storme
 */
public class Quiz {
    String question;
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    
    Quiz(){
        
    }
    void setQuestion(String q){
        question = q;
    }
    void setAnswer1(String a){
        ans1 = a;
    }
    void setAnswer2(String b){
        ans2 = b;
    }
    void setAnswer3(String c){
        ans3 = c;
    }
    void setAnswer4(String d){
        ans4 = d;
    }
}
