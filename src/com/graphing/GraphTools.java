package com.graphing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class GraphTools 
{
    private static ArrayList<String[]> order;
    private static ArrayList<String> topOrder;
    public static final int RAND_EDGES = 0;
    public static final int MAX_EDGES = 1;
    
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
    public static GraphWrapper generateTopologicalGraph(int numNodes)
    {
        GraphWrapper wrapper = new GraphWrapper();
        Random rand = new Random();
        
        boolean[][] connected = new boolean[numNodes][numNodes];
        Node[] nodes = new Node[numNodes];
         
        char label = 'A';
        for(int i=0;i<nodes.length;i++)
            nodes[i] = new Node((label++)+"");
        
        //Generates and random directed acyclic graph for topological sort example
        for(int i=0;i<connected.length;i++)
            for(int j=0;j<i;j++)
            {
                if(rand.nextInt(3) > 1)
                {
                    //Set the array repersentation to true
                    connected[j][i] = true;
                    //Create the connections amongst the nodes
                    nodes[j].addNeighbor(nodes[i]);
                }
            }
        
        //Print out the adjacency matrixs (FOR DEBUGGING)
        for(int i=0;i<connected.length;i++)
        {
            for(int j=0;j<connected.length;j++)
            {
                if(connected[i][j])
                    System.out.print("T|");
                else
                    System.out.print("X|");
            }
            System.out.println();
        }
        
        //Print out the nodes and their neighbors (FOR DEBUGGING)
        for(int i=0;i<nodes.length;i++)
        {
            System.out.print(nodes[i].name+"|");
            //System.out.print(nodes[i].incomingNodes+"|");
            System.out.print(nodes[i].adjacencyList);
            
            System.out.println();
        }
        
        wrapper.numNodes = numNodes;
        wrapper.connections = connected;
        wrapper.forest = nodes;
        
        return wrapper;
    }
    
    /**
     * Generates a graph to be used with the Strongly Connected Components algorithm.
     * This graph can be used for various exercises and visualizations. Always has 
     * eight nodes and a random amount of SCCs.
     * @return All necessary information needed to represent the graph visually
     */
    public static GraphWrapper generateSCCGraph()
    {
        Random rand = new Random();
        Node[] nodes = new Node[8];
        Node[] nodesT = new Node[8];//Node transpose
        char label = 'A';
        //initialize the nodes
        for(int i=0;i<nodes.length;i++)
        {
            String name = (label++)+"";
            nodes[i] = new Node(name);
            nodesT[i] = new Node(name);
        }
        
        boolean[][] connected = new boolean[8][8];
        boolean[][] transpose = new boolean[8][8];
        
        //Create connections amongst the nodes (can only connect to neighbors)
        int threshold = 6;
        for(int i=0;i<nodes.length;i++)
        {
            switch(i)
            {
                case 0:
                    if(rand.nextInt(10)>threshold)
                        connected[0][1] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[0][4] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[0][5] = true;
                    break;
                case 1:
                case 2:
                    if(rand.nextInt(10)>threshold)
                        connected[i][i-1] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[i][i+1] = true;
                    for(int j=0;j<3;j++)
                        if(rand.nextInt(10)>threshold)
                            connected[i][i+3+j] = true;
                    break;
                case 3:
                    if(rand.nextInt(10)>threshold)
                        connected[3][2] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[3][6] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[3][7] = true;
                    break;
                case 4:
                    if(rand.nextInt(10)>threshold)
                        connected[4][0] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[4][1] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[4][5] = true;
                    break;
                case 5:
                case 6:
                    if(rand.nextInt(10)>threshold)
                        connected[i][i-1] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[i][i+1] = true;
                    for(int j=0;j<3;j++)
                        if(rand.nextInt(10)>threshold)
                            connected[i][i-3-j] = true;
                    break;
                case 7:
                    if(rand.nextInt(10)>threshold)
                        connected[7][2] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[7][3] = true;
                    if(rand.nextInt(10)>threshold)
                        connected[7][6] = true;
                    break;
                default:
                    break;
            }
        }
       
        int numEdges = 0;
        //Connect all the nodes based on the adjacency matrix
        //Also form the transpose
        for(int i=0;i<connected.length;i++)
        {
            for(int j=0;j<connected.length;j++)
            {
                if(connected[i][j])
                {
                    nodes[i].addNeighbor(nodes[j]);
                    //Transpose formation
                    transpose[j][i] = true;
                    nodesT[j].addNeighbor(nodesT[i]);
                    numEdges++;
                }
            }
        }
        
        //Print out the nodes and their neighbors (FOR DEBUGGING)
        for(int i=0;i<nodes.length;i++)
        {
            System.out.print(nodes[i].name+"|");
            System.out.print(nodes[i].adjacencyList);
            System.out.println();
        }
        
        //Print out the transpose information (FOR DEBUGGING)
        System.out.println("~~~~~~Transpose~~~~~~");
        for(int i=0;i<nodesT.length;i++)
        {
            System.out.print(nodesT[i].name+"|");
            System.out.print(nodesT[i].adjacencyList);
            System.out.println();
        }
        
        GraphWrapper wrapper = new GraphWrapper();
        wrapper.connections = connected;
        wrapper.connectionsT = transpose;
        wrapper.forest = nodes;
        wrapper.forestT = nodesT;
        wrapper.numNodes = 8;
        wrapper.numEdges = numEdges;
        
        return wrapper;
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
    
    /**
     * Preforms the topological sort algorithm on a forest of nodes
     * @param forest - Group of trees which will be preformed on
     * @return Topological order of the nodes in String format
     */
    public static ArrayList<String[]> topologicalSort(Node[] forest)
    {
        System.out.println("==========Topological Sort==========");
        topOrder = new ArrayList<>();
        order = new ArrayList<>();
        for(int i=0;i<forest.length;i++)
        {
            //Find starting point
            if(!forest[i].visited)
                topologicalSortHelper(null, forest[i]);
        }
        
        System.out.println(topOrder);
        return order;
    }
    
    private static void topologicalSortHelper(Node src, Node root)
    {
        if(root.visited)
            return;
        
        if(src==null)
            order.add(new String[]{"", root.name});
        else
            order.add(new String[]{src.name, root.name});
        
        root.visited = true;
        
        for(Node node : root.adjacencyList)
        {
            topologicalSortHelper(root, node);           
            order.add(new String[]{"BACK", root.name});
        }            
        
        order.add(new String[]{"DONE", root.name});
        topOrder.add(0, root.name);
    }
    
    private int time;
    
    /**
     * Computes the strongly connected components of a graph
     * @param forest Group of nodes that algorithm will act upon
     * @param forestT Transpose of the group of node. 
     */
    public ArrayList<String[]> stronglyConnectedComponenets(Node[] forest, Node[] forestT)
    {
        System.out.println("==========Strongly Connected Components==========");
        order = new ArrayList<>();
        
        time = 1;
        
        //Do DFS and compute finishing times of the forest
        for(int i=0;i<forest.length;i++)
        {
            //Find starting point
            if(!forest[i].visited)
                sccHelperFinishTime(null, forest[i]);
        }
        
        order.add(new String[]{"Transpose", ""});
        
        //Transfer start and finishing times over to transpose
        for(int i = 0;i<forest.length;i++)
        {
            forestT[i].startTime = forest[i].startTime;
            forestT[i].finishTime = forest[i].finishTime;
        }
        
        //Order forest transpose by finish time
        ArrayList<Node> sorted = new ArrayList<>(Arrays.asList(forestT));
        sorted.sort((Node n1, Node n2) -> {
            return n2.finishTime - n1.finishTime;
        });
        for(int i = 0;i<forestT.length;i++)
            forestT[i] = sorted.get(i);
        
        //Print out forest info (DEBUG)
        for(int i = 0;i<forest.length;i++)
        {
            System.out.print(forest[i].name+"|");
            System.out.printf("S: %d|F: %d\n", forest[i].startTime, forest[i].finishTime);
        }
        
        System.out.println("---------------------");
        //Print out forestT info (DEBUG)
        for(int i = 0;i<forestT.length;i++)
        {
            System.out.print(forestT[i].name+"|");
            System.out.printf("S: %d|F: %d\n", forestT[i].startTime, forestT[i].finishTime);
        }
        
        //Do DFS and compute SCC of the graph
        for(int i=0;i<forestT.length;i++)
        {
            //Find starting point
            if(!forestT[i].visited)
                sccHelperSCC(forestT[i]);
        }
        
        return order;
    }
    
    private void sccHelperFinishTime(Node src, Node root)
    {
        if(root.visited)
            return;
        
        root.visited = true;
        root.startTime = time++;
        if(src==null)
            order.add(new String[]{"", root.name});
        else
            order.add(new String[]{src.name, root.name});
        
        for(Node node : root.adjacencyList)
        {
            sccHelperFinishTime(src, node);       
            order.add(new String[]{"BACK", root.name});
        }
        
        root.finishTime =  time++;
        order.add(new String[]{"DONE", root.name});
    }
    
    private void sccHelperSCC(Node root)
    {
        if(root.visited)
            return;
        
        root.visited = true;
        order.add(new String[]{"SCC", root.name});
        
        for(Node node : root.adjacencyList)
            sccHelperSCC(node);           
        
        order.add(new String[]{"SCC_END", ""});
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
