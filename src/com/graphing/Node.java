package com.graphing;

import java.util.ArrayList;

public class Node 
{
	public String name;
	public ArrayList<Node> adjacencyList;
	
        public boolean visited;
        
        //For use with SCC
        public int startTime;
        public int finishTime;
	
	public Node(String name)
	{
		this.name = name;
		this.visited = false;
		
		adjacencyList = new ArrayList<Node>();
	}
	
	public boolean addNeighbor(Node node)
	{
            return adjacencyList.add(node);
	}
        
        @Override
        public String toString()
        {
            return name;
        }
}
