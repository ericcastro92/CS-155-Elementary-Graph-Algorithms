/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.UI;

import com.graphing.GraphTools;
import com.graphing.GraphWrapper;
import com.graphing.Node;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author ericcastro
 */
public class GraphView extends javax.swing.JFrame 
{   
    private final Timer timer;
    
    private final mxGraph graph;
    private final GraphWrapper wrapper;
    private Object parent;
    
    private final int[][] vertexLocations;
    private int animationSpeed;
    private int maxX;
    private int maxY;
    
    /**
     * Creates new form GraphView
     * @param wrapper
     * @param title
     */
    public GraphView(GraphWrapper wrapper, String title) 
    {
        this.wrapper = wrapper;
        timer = new Timer();
        vertexLocations = new int[wrapper.numNodes][2];
        
        initComponents();
        initCustomComponents();
        
        graph = new mxGraph();
        buildStyles();
        buildGraph();
        
        setTitle(title);
    }
    
    private void initCustomComponents()
    {
        animationSpeed = 3000;
        //Set up speed slider
        speedSlider.setMaximum(5);
        speedSlider.setMinimum(1);
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setSnapToTicks(true);
        speedSlider.setValue(3);
        speedSlider.addChangeListener((ChangeEvent e) -> {
            animationSpeed = (6 - speedSlider.getValue()) * 1000;
            System.out.println(animationSpeed);
        });
    }
    
    /*private void showAlgorithm()
    {
        traverseGraph(null, wrapper.head);
    }*/
    
    private void buildStyles()
    {
        mxStylesheet stylesheet = graph.getStylesheet();
        HashMap<String, Object> style = new HashMap<>();
        
        //Default rounded style
        style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        stylesheet.putCellStyle("ROUNDED", style);
        
        //Red rounded style
        style = new HashMap<>();
        style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        style.put(mxConstants.STYLE_FILLCOLOR, "#FF0000");
        style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
        stylesheet.putCellStyle("RED_ROUNDED", style);
        
        //Overlay edge
        style = new HashMap<>();
        style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
        stylesheet.putCellStyle("OVERLAY_EDGE", style);
    }

    private void buildGraph()
    {
        int nodeSize = 50;
        int chartSpacing = 25;
                
        int chartSize = wrapper.numNodes / 2;
        if(chartSize * chartSize < wrapper.numNodes)
            chartSize+=1;
         
        boolean[][] placementChart = new boolean[chartSize][chartSize];
        
        parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {
            Random rand = new Random();
            Object[] verticies = new Object[wrapper.numNodes];
            //Place head in top right location
            verticies[0] = graph.insertVertex(parent, null, "A", 20, 20, 50, 50, "ROUNDED");
            placementChart[0][0] = true;
            vertexLocations[0][0] = 20;
            vertexLocations[0][1] = 20;
            maxX = 150;
            maxY = 150;
            
            //Place other nodes randomly in the view
            for(int i=1;i<wrapper.numNodes;i++)
            {
                int x = 0;
                int y = 0;
                while(placementChart[x][y])
                {
                    x = rand.nextInt(chartSize);
                    y = rand.nextInt(chartSize);
                }
                placementChart[x][y] = true;
                
                x = (x * 50) + (x * 25) + 20;
                y = (y * 50) + (y * 25) + 20;
                
                vertexLocations[i][0] = x;
                vertexLocations[i][1] = y;
                maxX = x > maxX ? x : maxX;
                maxY = y > maxY ? y : maxY;
                
                verticies[i] = graph.insertVertex(parent, null, ((char) ('A'+i)), x, y, 50, 50, "ROUNDED");
            }
            
            
            //Add edges between nodes
            for(int i=0;i<wrapper.numNodes;i++)
                for(int j=0;j<wrapper.numNodes;j++)
                {
                    if(wrapper.connections[i][j] && i != j)
                        graph.insertEdge(parent, null, null, verticies[i], verticies[j]);
                }
        }
        finally
        {
            graph.getModel().endUpdate();
        }
        
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setDragEnabled(false);
        graphComponent.setEnabled(false);
        graphScrollPane.add(graphComponent);
        graphScrollPane.setViewportView(graphComponent);       
        this.setSize(maxX + 150, maxY + 150);
    }
    
    Object v1;
    
    private void showAlgorithm()
    {
        ArrayList<String> order = GraphTools.dfs(wrapper.head);
        
        graph.getModel().beginUpdate();
        try
        {
            v1 = (mxCell) graph.insertVertex(parent, null, 'A', vertexLocations[0][0], vertexLocations[0][1], 50, 50, "RED_ROUNDED");
        }
        finally
        {
            graph.getModel().endUpdate();
        } 
        TimerTask tt = new TimerTask()
        {
            @Override
            public void run() 
            {
                showAlgorithmOrder(order);
            }
        };
        timer.schedule(tt, animationSpeed);  
        //graph.setCellStyle("ROUNDED", new Object[]{v1});
    }
    
    private void showAlgorithmOrder(ArrayList<String> order)
    {
        if(order.size() == 1)
            return;
        
        char curNodeID = order.get(0).charAt(0);
        char nextNodeID = order.get(1).charAt(0);
        
        graph.getModel().beginUpdate();
        try
        {
            Object v1 = graph.insertVertex(parent, null, curNodeID, 
                                            vertexLocations[curNodeID - 'A'][0], 
                                            vertexLocations[curNodeID - 'A'][1], 
                                            50, 50, "RED_ROUNDED");
            
            Object v2 = graph.insertVertex(parent, null, nextNodeID, 
                                            vertexLocations[nextNodeID - 'A'][0], 
                                            vertexLocations[nextNodeID - 'A'][1], 
                                            50, 50, "RED_ROUNDED");
            
            graph.insertEdge(parent, null, null, v1, v2, "OVERLAY_EDGE");
            
        }
        catch(Exception e)
        {
            System.out.println("Graph Exception");
        }
        finally
        {
            graph.getModel().endUpdate();
        } 
        
        TimerTask tt = new TimerTask()
        {
            @Override
            public void run() 
            {
                order.remove(0);
                showAlgorithmOrder(order);
            }
        };
        timer.schedule(tt, animationSpeed);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speedSlider = new javax.swing.JSlider();
        graphScrollPane = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Graph");

        speedSlider.setMajorTickSpacing(1);
        speedSlider.setMaximum(5);
        speedSlider.setMinimum(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setSnapToTicks(true);
        speedSlider.setToolTipText("Select how fast you wouldl like the algorithm to run.");
        speedSlider.setValue(3);

        jLabel1.setText("Fast");

        jLabel2.setText("Slow");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(speedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(51, 51, 51))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(graphScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startButton)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(speedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(graphScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addGap(43, 43, 43)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        showAlgorithm();
    }//GEN-LAST:event_startButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane graphScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
