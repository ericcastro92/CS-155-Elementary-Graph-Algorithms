package com.UI;

import java.awt.Toolkit;
import javax.swing.event.ChangeEvent;
import com.graphing.*;
import java.awt.Button;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

/**
 * Basic frame that contains information about each algorithm
 * @author ericcastro
 */
public class InformationFrame extends javax.swing.JFrame {

    /**
     * Creates new form InformationFrame
     */
    public InformationFrame(int algorithm) {
        initComponents();
        setTitle("Information");
        
        switch(algorithm)
        {
            case GraphView.DFS:
                displayDFSInfo();
                break;
            case GraphView.BFS:
                displayBFSInfo();
                break;
            case GraphView.TOPOLOGICAL:
                displayTopologicalInfo();
                break;
            case GraphView.SCC:
                displaySCCInfo();
                break;
            default:break;
        }
    }

    /**
     * Displays information about DFS
     */
    private void displayDFSInfo()
    {
        String info = "Depth First Search\n\n" +
                "Depth first search visits each node in the graph by constantly \'going down\' a level until it cannot go any farther.\n" +
                "Once it is at the \'bottom\' it will traverse back up the graph until it can find another way back down. In other words\n" +
                "it will visit the neighbors of a node one at a time, and then visit that nodes neighbores one at a time, and so on.\n\n"
                + "Time Complexity: O(|E|)\n"
                + "Space Complexity: O(|V|)\n\n" + 
                "1  procedure DFS(G,v):\n" +
                "2      label v as discovered\n" +
                "3      for all edges from v to w in G.adjacentEdges(v) do\n" +
                "4          if vertex w is not labeled as discovered then\n" +
                "5              recursively call DFS(G,w)";
        informationArea.setText(info);
    }
    
    /**
     * Displays information about BFS
     */
    private void displayBFSInfo()
    {
        String info = "Breadth First Search\n\n"+
                "Breadth first search iterates through a graph by visiting each neighbore node first before it proceeds to the next level.\n"
                + "Only once every neighbor has been visited may the algorithm start visiting the \'neighbors neighbors'.\n\n" + 
                "Time Complexity: O(|E|)\n" +
                "Space Complexity: O(|V|)\n\n" +
                "Psuedo Code:\n" +
                "1  procedure BFS(G,v) is\n" +
                "2      create a queue Q\n" +
                "3      create a vector set V\n" +
                "4      enqueue v onto Q\n" +
                "5      add v to V\n" +
                "6      while Q is not empty loop\n" +
                "7         t ← Q.dequeue()\n" +
                "8         if t is what we are looking for then\n" +
                "9            return t\n" +
                "10        end if\n" +
                "11        for all edges e in G.adjacentEdges(t) loop\n" +
                "12           u ← G.adjacentVertex(t,e)\n" +
                "13           if u is not in V then\n" +
                "14               add u to V\n" +
                "15               enqueue u onto Q\n" +
                "16           end if\n" +
                "17        end loop\n" +
                "18     end loop\n" +
                "19     return none\n" +
                "20 end BFS";
        informationArea.setText(info);        
    }
    
    /**
     * Displays information about Topological Sort
     */
    private void displayTopologicalInfo()
    {
        String info = "Topological Sort\n\n" + 
                "\"A topological sort of a directed graph is a linear ordering of its vertices such that for every directed edge uv from\n" +
                " vertex u to vertex v, u comes before v in the ordering.\"-Wikipedia\n\n" +
                "Time Complexity: O(|V|+|E|)\n\n" + 
                "Psuedo Code:\n" + 
                "1 call DFS.G/ to compute finishing times 􏰁:f for each vertex 􏰁\n" +
                "2 as each vertex is finished, insert it onto the front of a linked list\n" +
                "3 return the linked list of vertices";
        informationArea.setText(info);
    }
    
    /**
     * Displays information about SCC
     */
    private void displaySCCInfo()
    {
        String info = "Strongly Connected Components\n\n" +
                "Two nodes are strongly connected if there is a path from u to v and from v to u. This algorithm will find all the strongly\n" + 
                "connected components in a given graph\n"+
                "Time Complexity: O(|V|+|E|)\n\n" +
                "Psuedo Code:\n" +
                "1 call DFS(G) to compute finishing times u.f for each vertex u" +
                "2 compute G^T\n" +
                "3 call DFS(G^T), but in the main loop of DFS, consider the vertices\n" +
                "  in order of decreasing u.f (as computed in line 1)\n" +
                "4 output the vertices of each tree in the depth-first forest formed in line 3 as a\n" +
                "separate strongly connected component";
        informationArea.setText(info);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bfsButton = new javax.swing.JButton();
        dfsButton = new javax.swing.JButton();
        topButton = new javax.swing.JButton();
        sccButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        informationArea = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bfsButton.setText("Bread-First Search");
        bfsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfsButtonActionPerformed(evt);
            }
        });

        dfsButton.setText("Depth-First Search");
        dfsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfsButtonActionPerformed(evt);
            }
        });

        topButton.setText("Topological Sort");
        topButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topButtonActionPerformed(evt);
            }
        });

        sccButton.setText("Strongly Connected Components");
        sccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sccButtonActionPerformed(evt);
            }
        });

        informationArea.setColumns(20);
        informationArea.setLineWrap(true);
        informationArea.setRows(5);
        jScrollPane1.setViewportView(informationArea);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Information");
        jTextField1.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bfsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dfsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sccButton)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bfsButton)
                    .addComponent(dfsButton)
                    .addComponent(topButton)
                    .addComponent(sccButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bfsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfsButtonActionPerformed
        displayBFSInfo();
    }//GEN-LAST:event_bfsButtonActionPerformed

    private void dfsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfsButtonActionPerformed
        displayDFSInfo();
    }//GEN-LAST:event_dfsButtonActionPerformed

    private void topButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topButtonActionPerformed
        displayTopologicalInfo();
    }//GEN-LAST:event_topButtonActionPerformed

    private void sccButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sccButtonActionPerformed
        displaySCCInfo();
    }//GEN-LAST:event_sccButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bfsButton;
    private javax.swing.JButton dfsButton;
    private javax.swing.JTextArea informationArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton sccButton;
    private javax.swing.JButton topButton;
    // End of variables declaration//GEN-END:variables
}
