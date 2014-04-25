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
        boolean[][] connected = new boolean[numNodes][numNodes];//Keeps track of created edges
        char label = 'A';

        //Generate the head
        nodes[0] = new Node((label++)+"");
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

    /**
     * Generates a directed acyclic graph (dag) for topological sort given the number of nodes and edges
     * @param numNodes Number of desired Nodes, n (1 - 20)
     * @param edgeSetting Generate random edges or maximum possible edges
     * @return GraphWrapper with all pertinent info and objects for the generated graph. Null if any parameters were invalid.
     */
    public static GraphWrapper generateTopologicalGraph(int numNodes, int edgeSetting)
    {
        Random rand = new Random();
        
        //Creates a directed acyclic graph (dag)
        int RAND_EDGES = 0;
        int MAX_EDGES = 1;
                
        int remainingNodes = numNodes;
        int levels = rand.nextInt(numNodes - 2) + 2;
        
        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
        
        boolean[][] connected = new boolean[numNodes][numNodes];//Keeps track of created edges
        char label = 'A';

        for(int i=0;i<levels;i++)//Add arraylist for each level
        {   
            nodes.add(new ArrayList<>());
            //Add default node to the level
            nodes.get(i).add(new Node(""+label++));
            numNodes--;
        }
        
        //Randomly add remaining nodes to the graph
        while(numNodes-->0)
        {
            int level = rand.nextInt(levels);
            nodes.get(level).add(new Node(""+label++));
        }

        //TODO: Generate edges

        //return wrapper;
        return null;
    }
    
    public static ArrayList<String[]> dfs(Node root)
    {
        System.out.println("==========DFS==========");
        order = new ArrayList<>();
        dfsHelper(null, root);
        System.out.println("=======================");
        for(int i=0;i<order.size();i++)
            System.out.println(Arrays.toString(order.get(i)));
        return order;
    }

    private static void dfsHelper(Node src, Node root)
    {
        if(root.visited)
            return;

        System.out.println(root.name);
        if(src==null)
            order.add(new String[]{"", root.name});
        else
            order.add(new String[]{src.name, root.name});
        
        root.visited = true;
        
        for(Node node : root.adjacencyList)
            dfsHelper(root, node);
    }

    public static ArrayList<String[]> bfs(Node root)
    {
        System.out.println("==========DFS==========");
        //Visit root node
        root.visited = true;
        System.out.println(root.name);
        
        order = new ArrayList<>();
        order.add(new String[]{"", root.name});
        bfsHelper(root);
        
        System.out.println("=======================");
        for(int i=0;i<order.size();i++)
            System.out.println(Arrays.toString(order.get(i)));
        return order;
    }
    
    private static void bfsHelper(Node root)
    {
        for(Node node : root.adjacencyList)
        {
            if(node.visited)
                continue;
            
            node.visited = true;
            
            order.add(new String[]{root.name, node.name});
            System.out.println(node.name);
        }
        
        for(Node node : root.adjacencyList)
            bfsHelper(node);
        
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
