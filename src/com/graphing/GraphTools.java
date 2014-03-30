package com.graphing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GraphTools 
{
        /**
         * Generates a graph given the number of nodes and edges
         * @param numNodes Number of desired Nodes, n (1 - 20)
         * @param numEdges Number of desired edges, between n-1 and n+n-1+...+n-(n-1). Exception of 1 (no edges possible)
         * @return First node of the graph, null if there's an invalid parameter.
         */
        public static Node generateGraph(int numNodes, int numEdges)
        {
            if(numEdges < numNodes - 1)
                return null;
            
            if(numEdges > numNodes * (numNodes - 1))
                return null;
                
            Node[] nodes = new Node[numNodes];
            boolean[] connectedMST = new boolean[numNodes];//Keep check if node 'n' is connected to the graph
            boolean[][] connected = new boolean[numNodes][numNodes];//Keeps track of created edges
            char label = 'A';
            
            //Generate the head
            nodes[0] = new Node((label++)+"");
            connectedMST[0] = true;
            for(int i=0;i<numNodes;i++)
                connected[i][i] = true;
            
            //Generate n-1 nodes
            for(int n=1;n<numNodes;n++)
                nodes[n] = new Node((label++)+"");
            
            for(Node node : nodes)
                System.out.println(node.name);
            
            Random rand = new Random();
            int prevNode = 0;
            int nextNode = 0;
            
            //Generate MST edges
            System.out.println(numEdges);
            for(int i=0;i<numNodes-1;i++)
            {
                while(connectedMST[nextNode])
                    nextNode = rand.nextInt(numNodes);
                
                System.out.println(nodes[prevNode].name + " connecting to " + nodes[nextNode].name);
                nodes[prevNode].addNeighbor(nodes[nextNode]);
                connected[prevNode][nextNode] = true;
                connectedMST[nextNode] = true;
                prevNode = nextNode; 
            }
            
            //Add random edges
            int remainingEdges = numEdges - numNodes - 1;
            
            if(remainingEdges<=0)
                return nodes[0];
            
            for(int i=0;i<remainingEdges;i++)
            {
                //Find two nodes without an edge from prev to next
                while(connected[prevNode][nextNode])
                {
                    prevNode = rand.nextInt(numNodes);
                    nextNode = rand.nextInt(numNodes);
                }
                System.out.println(nodes[prevNode].name + " connecting to " + nodes[nextNode].name);
                nodes[prevNode].addNeighbor(nodes[nextNode]);
                connected[prevNode][nextNode] = true;
            }
            
            return nodes[0];
        }
    
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
        
        public static int maxEdges(int numNodes)
        {
            if(numNodes == 1)
                return 0;
            
            int maxEdges = 0;
            while(numNodes!=0)
                maxEdges+=--numNodes;
            
            return maxEdges;
        }
}
