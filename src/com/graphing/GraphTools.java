package com.graphing;

import java.util.ArrayList;

public class GraphTools 
{
	public static void dfs(Node head)
	{
		System.out.println("==========DFS==========");
		dfsHelper(head);
		System.out.println("=======================");
	}
	
	private static void dfsHelper(Node head)
	{
		if(head.visited)
			return;
		
		head.visited = true;
		System.out.println(head.name);
		
		for(Node node : head.adjacencyList)
			dfsHelper(node);
	}
	
	public static void resetNodes(ArrayList<Node> nodes)
	{
		for(Node node : nodes)
			node.visited = false;
	}
}
