package com.UI;

import java.awt.Toolkit;
import javax.swing.event.ChangeEvent;
import com.graphing.*;
import java.awt.Button;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

/**
 * Simple frame that contains exercises for the user to practice with.
 * @author Jonathan Yee
 */
public class ExerciseFrame extends javax.swing.JFrame {

    Exercises ex;

    /**
     * Creates new form ExerciseFrame
     */
    public ExerciseFrame() {
        initComponents();
        setTitle("Exercises");
        ex = new Exercises();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BFSButton = new javax.swing.JButton();
        DFSButton = new javax.swing.JButton();
        TopButton = new javax.swing.JButton();
        SCCButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ExerciseArea = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        BFSButton.setText("Bread-First Search");
        BFSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSButtonActionPerformed(evt);
            }
        });

        DFSButton.setText("Depth-First Search");
        DFSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFSButtonActionPerformed(evt);
            }
        });

        TopButton.setText("Topological Sort");
        TopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopButtonActionPerformed(evt);
            }
        });

        SCCButton.setText("Strongly Connected Components");
        SCCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SCCButtonActionPerformed(evt);
            }
        });

        ExerciseArea.setColumns(20);
        ExerciseArea.setLineWrap(true);
        ExerciseArea.setRows(5);
        jScrollPane1.setViewportView(ExerciseArea);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Exercises");
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
                        .addComponent(BFSButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DFSButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SCCButton)))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BFSButton)
                    .addComponent(DFSButton)
                    .addComponent(TopButton)
                    .addComponent(SCCButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BFSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSButtonActionPerformed
        ExerciseArea.setText(ex.BFSx);
    }//GEN-LAST:event_BFSButtonActionPerformed

    private void DFSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFSButtonActionPerformed
        ExerciseArea.setText(ex.DFSx);
    }//GEN-LAST:event_DFSButtonActionPerformed

    private void TopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopButtonActionPerformed
        ExerciseArea.setText(ex.TSx);
    }//GEN-LAST:event_TopButtonActionPerformed

    private void SCCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SCCButtonActionPerformed
        ExerciseArea.setText(ex.SCCx);
    }//GEN-LAST:event_SCCButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFSButton;
    private javax.swing.JButton DFSButton;
    private javax.swing.JTextArea ExerciseArea;
    private javax.swing.JButton SCCButton;
    private javax.swing.JButton TopButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
