/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UI;

import java.awt.Toolkit;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Augusta Storme
 */
public class QuizFrame extends javax.swing.JFrame 
{
    private int totalscore = 0;
    private int totalQs = 5;
    private int buttonSelection = 0;

    /**
     * Creates new form QuizFrame
     */
    public QuizFrame() 
    {        
        initComponents();
        aButton.addChangeListener((ChangeEvent e) -> {
            if(aButton.isSelected())
            {
                buttonSelection = 1;
                bButton.setSelected(false);
                cButton.setSelected(false);
                dButton.setSelected(false);
            }
        });
        bButton.addChangeListener((ChangeEvent e) -> {
            if(bButton.isSelected())
            {
                buttonSelection = 2;
                aButton.setSelected(false);
                cButton.setSelected(false);
                dButton.setSelected(false);
            }
        });
        cButton.addChangeListener((ChangeEvent e) -> {
            if(cButton.isSelected())
            {
                buttonSelection = 3;
                aButton.setSelected(false);
                bButton.setSelected(false);
                dButton.setSelected(false);
            }
        });
        dButton.addChangeListener((ChangeEvent e) -> {
            if(dButton.isSelected())
            {
                buttonSelection = 4;
                aButton.setSelected(false);
                bButton.setSelected(false);
                cButton.setSelected(false);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        questionBox = new javax.swing.JTextPane();
        aButton = new javax.swing.JRadioButton();
        bButton = new javax.swing.JRadioButton();
        cButton = new javax.swing.JRadioButton();
        dButton = new javax.swing.JRadioButton();
        Submit = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();
        scoreValueLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionBox.setEditable(false);
        jScrollPane1.setViewportView(questionBox);

        aButton.setText("Answer A");

        bButton.setText("Answer B");

        cButton.setText("Answer C");

        dButton.setText("Answer D");

        Submit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Submit.setText("Submit");

        scoreLabel.setText("Score:");

        scoreValueLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dButton)
                            .addComponent(cButton)
                            .addComponent(bButton)
                            .addComponent(aButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(dButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scoreLabel)
                            .addComponent(scoreValueLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Submit)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                QuizFrame view = new QuizFrame();
                //new QuizFrame().setVisible(true);
                int x = (Toolkit.getDefaultToolkit().getScreenSize().width - view.getWidth()) / 2;
                int y = (Toolkit.getDefaultToolkit().getScreenSize().height - view.getHeight()) / 2;

                view.setLocation(x, y);
                view.setVisible(true);
                view.setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Submit;
    private javax.swing.JRadioButton aButton;
    private javax.swing.JRadioButton bButton;
    private javax.swing.JRadioButton cButton;
    private javax.swing.JRadioButton dButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane questionBox;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreValueLabel;
    // End of variables declaration//GEN-END:variables
}