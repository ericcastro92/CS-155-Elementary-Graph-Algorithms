package com.graphing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ericcastro
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>();
        
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");

        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        nodes.add(h);

        a.addNeighbor(b);
        a.addNeighbor(c);
        b.addNeighbor(d);
        b.addNeighbor(e);
        c.addNeighbor(f);
        c.addNeighbor(g);
        e.addNeighbor(h);

        GraphTools.dfs(a);
        GraphTools.resetNodes(nodes);

        GraphTools.bfs(a);
        GraphTools.resetNodes(nodes);

        //Node head = GraphTools.generateGraph(4, 6).head;
        //GraphTools.dfs(head);
        
        GraphWrapper gw = GraphTools.generateTopologicalGraph(5);
        ArrayList<String[]> order = GraphTools.topologicalSort(gw.forest);
        for(int i=0;i<order.size();i++)
            System.out.println(Arrays.toString(order.get(i)));
        
        //System.out.println(topOrder);
        System.out.println("===================");
        GraphTools gt = new GraphTools();
        GraphWrapper wrapper = GraphTools.generateSCCGraph();
        System.out.println("=========Algorithm Start==========");
        order = gt.stronglyConnectedComponenets(wrapper.forest, wrapper.forestT);
        for(int i=0;i<order.size();i++)
            System.out.println(Arrays.toString(order.get(i)));
        
        System.out.println("--------Start and Finish Times---------");
        for(int i=0;i<wrapper.forest.length;i++)
            System.out.printf("%s|%d|%d\n",wrapper.forest[i].name,
                                           wrapper.forest[i].startTime,
                                           wrapper.forest[i].finishTime);
            
    }
    
}
