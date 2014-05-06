package com.graphing;

import java.util.ArrayList;

/**
 *
 * @author Jonathan Yee
 */
public class QuizTools {

    public ArrayList<Quiz> quiz = new ArrayList<>();
    private int qCounter = 0;

    public void main() {
        quizMaker();
    }

    public void quizMaker() {
        Quiz temp = new Quiz();
        temp.setQuestion("How can a graph G = (V,E) be represented by?");
        temp.setAnswer1("A. Adjacency List.");
        temp.setAnswer2("B. Adjacency Matrix.");
        temp.setAnswer3("C. Both.");
        temp.setAnswer4("D. Neither.");
        temp.setCorrect(3);
        quiz.add(temp);

        temp = new Quiz();
        temp.setQuestion("What is the running time of Breadth-First Search");
        temp.setAnswer1("A. O(1).");
        temp.setAnswer2("B. O(E).");
        temp.setAnswer3("C. O(n).");
        temp.setAnswer4("D. O(V + E).");
        temp.setCorrect(4);
        quiz.add(temp);

        temp = new Quiz();
        temp.setQuestion("What type of algorithm is Prim's minimum-spanning tree algorithm based on?");
        temp.setAnswer1("A. Breadth-First search.");
        temp.setAnswer2("B. Depth-First search");
        temp.setAnswer3("C. Topological Sort");
        temp.setAnswer4("D. None of the above.");
        temp.setCorrect(1);
        quiz.add(temp);

        temp = new Quiz();
        temp.setQuestion("What type of algorithm is Dijkstra's single-source shortest-path \n"
                + "algorithm based on?");
        temp.setAnswer1("A. Breadth-First search.");
        temp.setAnswer2("B. Depth-First search");
        temp.setAnswer3("C. Topological Sort");
        temp.setAnswer4("D. None of the above.");
        temp.setCorrect(1);
        quiz.add(temp);

        temp = new Quiz();
        temp.setQuestion("What type of algorithm works on both directed and undirected \n"
                + "graphs?");
        temp.setAnswer1("A. Breadth-First search.");
        temp.setAnswer2("B. Depth-First search");
        temp.setAnswer3("C. Topological Sort");
        temp.setAnswer4("D. All of the above.");
        temp.setCorrect(4);
        quiz.add(temp);

        //Question 6
        temp = new Quiz();
        temp.setQuestion("In a Depth-First search, what are edges in the depth-first forest?");
        temp.setAnswer1("A. Tree Edges.");
        temp.setAnswer2("B. Back Edges.");
        temp.setAnswer3("C. Forward Edges.");
        temp.setAnswer4("D. Cross Edges.");
        temp.setCorrect(1);
        quiz.add(temp);

        temp = new Quiz();
        temp.setQuestion("In a Depth-First search, what are edges not classified by any other edge?");
        temp.setAnswer1("A. Tree Edges.");
        temp.setAnswer2("B. Back Edges.");
        temp.setAnswer3("C. Forward Edges.");
        temp.setAnswer4("D. Cross Edges.");
        temp.setCorrect(4);
        quiz.add(temp);

        temp = new Quiz();
        temp.setQuestion("In a Depth-First search, what are those nontree edges (u,v) \n"
                + "connecting a vertex u to a descendant?"
                + " in a depth-first tree.");
        temp.setAnswer1("A. Tree Edges.");
        temp.setAnswer2("B. Back Edges.");
        temp.setAnswer3("C. Forward Edges.");
        temp.setAnswer4("D. Cross Edges.");
        temp.setCorrect(3);
        quiz.add(temp);

        temp = new Quiz();
        temp.setQuestion("In a Depth-First search, what are those edges (u,v) connecting a \n"
                + "vertex u to an ancestor in a depth-first tree.");
        temp.setAnswer1("A. Tree Edges.");
        temp.setAnswer2("B. Back Edges.");
        temp.setAnswer3("C. Forward Edges.");
        temp.setAnswer4("D. Cross Edges.");
        temp.setCorrect(2);
        quiz.add(temp);
        
        temp = new Quiz();
        temp.setQuestion("How does the alogrithm for finding strongly conencted components work?");
        temp.setAnswer1("A. It uses one depth-first sesarchs, one on G and one on G^T.");
        temp.setAnswer2("B. It uses two depth-first sesarchs, one on G and one on G^T.");
        temp.setAnswer3("C. It uses one breadth-first sesarchs, one on G and one on G^T.");
        temp.setAnswer4("D. It uses two breadth-first sesarchs, one on G and one on G^T.");
        temp.setCorrect(2);
        quiz.add(temp);
    }
}
