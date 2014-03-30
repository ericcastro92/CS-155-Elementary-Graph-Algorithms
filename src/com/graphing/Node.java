package com.graphing;

import java.util.ArrayList;

public class Node 
{
	public String name;
	public ArrayList<Node> adjacencyList;
	
	public boolean visited;
	
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
}
