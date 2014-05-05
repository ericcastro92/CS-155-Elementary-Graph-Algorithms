/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphing;

import java.util.ArrayList;

/**
 *
 * @author Augusta Storme
 */
public class Exercises {

    public String BFSx = "";
    public String DFSx = "";
    public String TSx = "";
    public String SCCx = "";

    public Exercises() {
         //BFS Exercises**************************************************************

        BFSx = ("1. What is the running time of BFS if we represent its input graph by an adjacency matrix and "
                + "modify the algorithm to handle this\nform of input?"
                + "\n\n2. There are two types of professional wrestlers: babyfaces and heels. "
                + "Between any pair of professional wrestlers, there may or\nmay not be a rivalry."
                + " Suppose we have n professional wrestlers and we have a list of r pairs of"
                + " wrestlers for which there are\nrivalries. Give an O(n+r) time algorithm that "
                + "determines whether it is possible to designate some of the wrestlers as"
                + " babyfaces\nand the remainder as heels such that each rivalry is between a "
                + "babyface and a heel. If it is possible to perform such a\ndesignation, your "
                + "algorithm should produce it."
                + "\n\n3. The diameter of a tree T = (V, E) is defined as max (u,v) that is, the largest of all shortest-path distances in the tree. "
                + "Give an\nefficient algorithm to compute the diameter of a tree, and analyze the running time of your algorithm"
                + "\n\n4. Let G = (V, E)  be a connected, undirected graph. Give an O(V+E) time algorithm to compute a path in G that traverses each\nedge in E exactly once in each direction. "
                + "Describe how you can find your way out of a maze if you are given a large supply of\npennies.");

        //DFS Exercises**************************************************************
        DFSx = ("1. Make a 3-by-3 chart with row and column labels WHITE, GRAY, and BLACK. "
                + "In each cell (i, j), indicate whether, at any point during a depth-first search of a directed graph, "
                + "there can be an edge from a vertex of color i to a vertex of color j . For each\npossible edge, indicate what edge types it can be. "
                + "Make a second such chart for depth-first search of an undirected graph."
                + "\n\n2. Show that edge (u,v) is\n"
                + "\ta. a tree edge or forward edge if and only if u.d < v.d < u.f\n"
                + "\tb. a back edge if and only if v.d <= u.d < u.f <= v.f and\n"
                + "\tc. a cross edge if and only if v.d < v.f < u.d < u.f"
                + "\n\n3. Show that in an undirected graph, classifying an edge (u,v) as a tree edge or a back edge according to whether (u,v) or\n(v, u) is encountered first during the depth-first search is  equivalent to classifying it according to the ordering of the four types\nin the classification scheme."
                + "\n\n4. Give a counterexample to the conjecture that if a directed graph G contains a path from u to v , and if u.d < v.d in a\ndepth-first search of G, then v is a descendant of u in the depth-first forest produced."
                + "\n\n5. Explain how a vertex u of a directed graph can end up in a depth-first tree containing only u, even though u has both\nincoming and outgoing edges in G."
                + "\n\n6. A directed graph G = (V, E) is singly connected if u -> v implies that G contains at most one simple path from u to v for all\nvertices u, v contained in V . Give an efficient algorithm to determine whether or not a directed graph is\nsingly connected."
                + "\n\n7. Give a counterexample to the conjecture that if a directed graph G contains a path from u to v , then any depth-first search must result in v.d <= u.f .");

        //Topol Sort Exercises**************************************************************
        TSx = ("1. Give an algorithm that determines whether or not a given undirected graph G = (V, E) contains a cycle. Your algorithm should run in O(V) time, independent of |E|."
                + "\n\n2. Prove or disprove: If a directed graph G contains cycles, then TOPOLOGICALSORT (G) produces a vertex ordering that\nminimizes the number of “bad” edges that are inconsistent with the ordering produced."
                + "\n\n3. Another way to perform topological sorting on a directed acyclic graph G = (V,E) is to repeatedly find a vertex of in-degree 0,\noutput it, and remove it and all of its outgoing edges from the graph. "
                + "Explain how to implement this idea so that it runs in\ntime O( V+ E) . What happens to this algorithm if G has cycles?");
        //SCC Exercises**************************************************************
        SCCx = ("1. How can the number of strongly connected components of a graph change if a new edge is added?"
        +"\n\n2. Professor Bacon claims that the algorithm for strongly connected components would be simpler if it used the original\n(instead of the transpose) "
                + "graph in the second depth-first search and scanned the vertices in order of increasing finishing\ntimes. Does this simpler algorithm always produce correct results?"
        +"\n\n3. Give an O(V + E) time algorithm to compute the component graph of a directed graph G = (V, E) Make sure that there is at\nmost one edge between two vertices in the component graph your algorithm produces.");

    }

}
