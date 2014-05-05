/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.graphing;

/**
 * Contains all information to build mxGraph from one generated with GraphTools
 * @author ericcastro
 */
public class GraphWrapper 
{
    public Node head;//Starting point for the graph
    public int numNodes;//Number of nodes in the graph
    public int numEdges;//Number of edges in the graph
    
    public boolean[][] connections;//Array representation of all edges
    public Node[] forest;//Forest of trees, used for Topological and SCC
}
