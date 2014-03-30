package com.graphing;

import java.util.ArrayList;

/**
 *
 * @author ericcastro
 */
public class Main 
{
    public static void main(String[] args) 
    {        
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);

        a.addNeighbor(b);
        a.addNeighbor(c);
        c.addNeighbor(d);
        d.addNeighbor(e);

        GraphTools.dfs(a);
        GraphTools.resetNodes(nodes);
        
        Node head = GraphTools.generateGraph(4, 6);
        GraphTools.dfs(head);
    }
}
