/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.graphing;

/**
 *
 * @author ericcastro
 */
public class TopologicalNode extends Node
{
    public int incomingNodes;
    
    public TopologicalNode(String name) 
    {
        super(name);
        incomingNodes = 0;
    }
    
    public boolean addNeighbor(TopologicalNode node)
    {
        node.incomingNodes++;
        return super.addNeighbor(node);
    }
    
    public boolean removeNeighbor(TopologicalNode node)
    {
        if(adjacencyList.remove(node))
        {
            node.incomingNodes--;
            return true;
        }
        
        return false;
    }
}
