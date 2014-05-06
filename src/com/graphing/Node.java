package com.graphing;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Basic Node class that can be linked with multiple other nodes to be used in
 * DFS, BFS, Topological Sort or SCC algorithms
 * @author ericcastro
 */
public class Node
{
    public String name;//Name of the node
    public ArrayList<Node> adjacencyList;//List of neighbors

    public boolean visited;//Has this node been visited(?)

    //For use with SCC
    public int startTime;
    public int finishTime;

    public Node(String name)
    {
            this.name = name;
            this.visited = false;

            adjacencyList = new ArrayList<Node>();
    }

    /**
     * Create an edge between this node and the given node
     * @param node Node to become a neighbor
     * @return Successfully added
     */
    public boolean addNeighbor(Node node)
    {
        return adjacencyList.add(node);
    }

    /**
     * String representation of the node
     * @return Name of the node.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
