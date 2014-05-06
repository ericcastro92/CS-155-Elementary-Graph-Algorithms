package com.UI;

import java.awt.Toolkit;
import javax.swing.event.ChangeEvent;
import com.graphing.*;
import java.awt.Button;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

/**
 *
 * @author Jonathan Yee
 */
public class InformationFrame extends javax.swing.JFrame {

    /**
     * Creates new form ExerciseFrame
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

    private void displayDFSInfo()
    {
        String info = "Depth First Search\n\n"
                + "Information";
        informationArea.setText(info);
    }
    
    private void displayBFSInfo()
    {
        String info = "Breadth First Search\n\n"
                + "Information";
        informationArea.setText(info);        
    }
    
    private void displayTopologicalInfo()
    {
        String info = "Topological Sort\n\n"
                + "Information";
        informationArea.setText(info);
    }
    
    private void displaySCCInfo()
    {
        String info = "Strongly Connected Components\n\n"
                + "Information";
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
