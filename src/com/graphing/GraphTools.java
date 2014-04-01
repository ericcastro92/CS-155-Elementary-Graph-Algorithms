package com.graphing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class GraphTools 
{
    private static ArrayList<String[]> order;
    
    /**
     * Generates a graph given the number of nodes and edges
     * @param numNodes Number of desired Nodes, n (1 - 20)
     * @param numEdges Number of desired edges, between n-1 and n+n-1+...+n-(n-1). Exception of 1 (no edges possible)
     * @return GraphWrapper with all pertinent info and objects for the generated graph. Null if any parameters were invalid.
     */
    public static GraphWrapper generateGraph(int numNodes, int numEdges)
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

        ArrayList<Node> unconnectedNodes = new ArrayList<>();
        ArrayList<Node> connectedNodes = new ArrayList<>();
        connectedNodes.add(nodes[0]);
        
        //Generate n-1 nodes
        for(int n=1;n<numNodes;n++)
        {
            nodes[n] = new Node((label++)+"");
            unconnectedNodes.add(nodes[n]);
        }

        for(Node node : nodes)
            System.out.println(node.name);

        Random rand = new Random();
        int prevNode = 0;
        int nextNode = 0;
        
        //Generate MST edges
        while(!unconnectedNodes.isEmpty() && numNodes != 1)
        {
            Node srcNode = connectedNodes.get(rand.nextInt(connectedNodes.size()));
            Node targetNode = unconnectedNodes.remove(rand.nextInt(unconnectedNodes.size()));
            srcNode.addNeighbor(targetNode);
            connectedNodes.add(targetNode);
            
            System.out.println(srcNode.name + " connecting to " + targetNode.name);
            
            connected[srcNode.name.charAt(0) - 'A'][targetNode.name.charAt(0) - 'A'] = true;
        }

        //Add random edges
        int remainingEdges = numEdges - numNodes + 1;

        GraphWrapper wrapper = new GraphWrapper();
        wrapper.connections = connected;
        wrapper.numNodes = numNodes;
        wrapper.numEdges = numEdges;
        wrapper.head = nodes[0];
        
        sortNeighbors(nodes);//Sort node neighbors alphabetically
        if(remainingEdges<=0)
            return wrapper;

        System.out.println("Remaining Edges: " + remainingEdges);
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
        
        sortNeighbors(nodes);//Sort node neighbors alphabetically

        return wrapper;
    }

    public static ArrayList<String[]> dfs(Node head)
    {
        System.out.println("==========DFS==========");
        order = new ArrayList<>();
        dfsHelper(null, head);
        System.out.println("=======================");
        for(int i=0;i<order.size();i++)
            System.out.println(Arrays.toString(order.get(i)));
        return order;
    }

    private static void dfsHelper(Node src, Node head)
    {
        if(head.visited)
            return;

        System.out.println(head.name);
        if(src==null)
            order.add(new String[]{"", head.name});
        else
            order.add(new String[]{src.name, head.name});
        
        head.visited = true;
        
        for(Node node : head.adjacencyList)
            dfsHelper(head, node);
    }

    public static void bfs(Node head)
    {
        System.out.println("==========DFS==========");
        bfsHelper(head);
        System.out.println("=======================");
    }
    
    private static void bfsHelper(Node head)
    {
        
    }
    
    public static void resetNodes(ArrayList<Node> nodes)
    {
        for(Node node : nodes)
            node.visited = false;
    }
                 
    private static void sortNeighbors(Node[] nodes)
    {
        for(int i=0;i<nodes.length;i++)
        {
            nodes[i].adjacencyList.sort(new Comparator<Node>()
            {
                @Override
                public int compare(Node n1, Node n2) 
                {
                    return n1.name.charAt(0) - n2.name.charAt(0);
                }
            });
            System.out.println(nodes[i] + ": " + nodes[i].adjacencyList);
        }
    }
    
}
