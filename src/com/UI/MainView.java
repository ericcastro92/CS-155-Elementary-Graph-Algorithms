/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UI;

import com.graphing.GraphTools;
import com.graphing.GraphWrapper;
import com.graphing.*;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Landing view of the application.
 * @author ericcastro
 */
public class MainView extends javax.swing.JFrame {

    //Keeps track of radio buttons
    private ButtonGroup algorithmSelection;

    //Used to monitor the sliders
    private final ChangeListener defaultNodeListener;
    private final ChangeListener topologicalNodeListener;
    private final ChangeListener defaultEdgeListener;
    private final ChangeListener topologicalEdgeListener;
    private boolean isDefault;

    /**
     * Creates new form GraphView
     */
    public MainView() {
        initComponents();

        dfsRadio.setMnemonic(GraphView.DFS);
        bfsRadio.setMnemonic(GraphView.BFS);
        topologicalRadio.setMnemonic(GraphView.TOPOLOGICAL);
        sccRadio.setMnemonic(GraphView.SCC);

        algorithmSelection = new ButtonGroup();
        algorithmSelection.add(bfsRadio);
        algorithmSelection.add(dfsRadio);
        algorithmSelection.add(topologicalRadio);
        algorithmSelection.add(sccRadio);
        dfsRadio.setSelected(true);

        // <editor-fold defaultstate="collapsed" desc="Change Listeners">
        defaultNodeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = nodeSlider.getValue();
                nodeSizeLabel.setText(value + "");

                edgeSlider.setMinimum(value - 1);
                edgeSlider.setMaximum(value * (value - 1));
                edgeSlider.setValue(value - 1);
            }
        };
        defaultEdgeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = edgeSlider.getValue();
                edgeSizeLabel.setText(value + "");
            }
        };

        topologicalNodeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = nodeSlider.getValue();
                nodeSizeLabel.setText(value + "");
            }
        };
        topologicalEdgeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (isDefault) {
                    return;
                }

                int value = edgeSlider.getValue();
                System.out.println("Topological Edge: " + value);
                switch (value) {
                    case 1:
                        edgeSizeLabel.setText("Random");
                        break;
                    case 2:
                        edgeSizeLabel.setText("Max");
                        break;
                    default:
                        break;
                }
            }
        };
        // </editor-fold>

        setSliderDefaults();
        topologicalRadio.addChangeListener((ChangeEvent e) -> {
            if (topologicalRadio.isSelected()) {
                System.out.println("Topological");
                setSliderTopological();
                isDefault = false;
            } else {
                System.out.println("Default");
                setSliderDefaults();
                isDefault = true;
            }
        });
        sccRadio.addChangeListener((ChangeEvent e) -> {
            if (sccRadio.isSelected()) {
                setSliderSCC();
                isDefault = false;
            } else {
                setSliderDefaults();
                isDefault = true;
            }
        });
    }

    /**
     * Resets the sliders to their defaults
     */
    private void setSliderDefaults() {
        nodeSlider.removeChangeListener(topologicalNodeListener);
        edgeSlider.removeChangeListener(topologicalEdgeListener);

        nodeSlider.addChangeListener(defaultNodeListener);
        edgeSlider.addChangeListener(defaultEdgeListener);

        nodeSlider.setMinimum(1);
        nodeSlider.setMaximum(20);
        nodeSlider.setMajorTickSpacing(1);
        nodeSlider.setSnapToTicks(true);
        nodeSlider.setValue(10);

        edgeSlider.setMinimum(9);
        edgeSlider.setMaximum(90);
        nodeSlider.setMajorTickSpacing(1);
        nodeSlider.setSnapToTicks(true);
        edgeSlider.setValue(9);
        edgeSizeLabel.setText("9");
        
        edgeSlider.setEnabled(true);
        nodeSlider.setEnabled(true);
    }

    /**
     * Sets the sliders to be used if Topological Sort is selected
     */
    private void setSliderTopological() {
        nodeSlider.removeChangeListener(defaultNodeListener);
        nodeSlider.addChangeListener(topologicalNodeListener);
        
        edgeSizeLabel.setText("-");
        edgeSlider.setEnabled(false);
    }
    
    /**
     * Sets the sliders to be used if SCC is selected
     */
    private void setSliderSCC()
    {
        nodeSlider.setValue(8);
        edgeSizeLabel.setText("-");
        nodeSlider.setEnabled(false);
        edgeSlider.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nodeSlider = new javax.swing.JSlider();
        nodesLabel = new javax.swing.JLabel();
        algorithmsLabel = new javax.swing.JLabel();
        nodeSizeLabel = new javax.swing.JLabel();
        edgeSlider = new javax.swing.JSlider();
        edgeSizeLabel = new javax.swing.JLabel();
        edgesLabel = new javax.swing.JLabel();
        creditLabel = new javax.swing.JLabel();
        dfsRadio = new javax.swing.JRadioButton();
        bfsRadio = new javax.swing.JRadioButton();
        topologicalRadio = new javax.swing.JRadioButton();
        displayButton = new javax.swing.JButton();
        quizButton = new javax.swing.JButton();
        dfsInfoButton = new javax.swing.JButton();
        bfsInfoButton = new javax.swing.JButton();
        topologicalInfoButton = new javax.swing.JButton();
        sccRadio = new javax.swing.JRadioButton();
        sccInfoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        exerciseButton = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        quitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph Visualizer");

        nodeSlider.setMajorTickSpacing(5);
        nodeSlider.setMaximum(20);
        nodeSlider.setMinimum(1);
        nodeSlider.setMinorTickSpacing(1);
        nodeSlider.setSnapToTicks(true);

        nodesLabel.setText("Nodes:");

        algorithmsLabel.setText("Select Algorithm:");

        nodeSizeLabel.setText("10");

        edgeSlider.setMajorTickSpacing(5);
        edgeSlider.setMaximum(90);
        edgeSlider.setMinimum(9);
        edgeSlider.setMinorTickSpacing(1);
        edgeSlider.setSnapToTicks(true);
        edgeSlider.setToolTipText("");
        edgeSlider.setValue(9);

        edgeSizeLabel.setText("9");

        edgesLabel.setText("Edges:");

        creditLabel.setText("Castro, Yee 2014");

        dfsRadio.setText("Depth First Search");
        dfsRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfsRadioActionPerformed(evt);
            }
        });

        bfsRadio.setText("Breadth First Search");

        topologicalRadio.setText("Topological Sort");

        displayButton.setText("Display");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });

        quizButton.setText("Quiz");
        quizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizButtonActionPerformed(evt);
            }
        });

        dfsInfoButton.setText("?");
        dfsInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfsInfoButtonActionPerformed(evt);
            }
        });

        bfsInfoButton.setText("?");
        bfsInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfsInfoButtonActionPerformed(evt);
            }
        });

        topologicalInfoButton.setText("?");
        topologicalInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topologicalInfoButtonActionPerformed(evt);
            }
        });

        sccRadio.setText("Strongly Connected");

        sccInfoButton.setText("?");
        sccInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sccInfoButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Components");

        exerciseButton.setText("Exercises");
        exerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciseButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitMenuItem);

        mainMenu.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        mainMenu.add(helpMenu);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bfsRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(dfsRadio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dfsInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bfsInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sccRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(topologicalRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(topologicalInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sccInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(algorithmsLabel)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(edgesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edgeSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nodesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nodeSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nodeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(edgeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creditLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quizButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(displayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(exerciseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {displayButton, exerciseButton, quizButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(algorithmsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dfsRadio)
                    .addComponent(dfsInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bfsRadio)
                    .addComponent(bfsInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(topologicalRadio)
                    .addComponent(topologicalInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sccRadio)
                    .addComponent(sccInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nodeSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nodeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nodesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(edgeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edgeSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edgesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quizButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exerciseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(creditLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed

    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        AboutFrame frame = new AboutFrame();
        displayFrame(frame);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /**
     * Display the graph view based on what algorithm is selected
     * @param evt 
     */
    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed

        GraphWrapper wrapper;
        GraphView frame = null;

        switch (algorithmSelection.getSelection().getMnemonic()) {
            case GraphView.DFS:
                wrapper = GraphTools.generateGraph(nodeSlider.getValue(),
                        edgeSlider.getValue());
                frame = new GraphView(wrapper, GraphView.DFS);
                break;
            case GraphView.BFS:
                wrapper = GraphTools.generateGraph(nodeSlider.getValue(),
                        edgeSlider.getValue());
                frame = new GraphView(wrapper, GraphView.BFS);
                break;
            case GraphView.TOPOLOGICAL:
                wrapper = GraphTools.generateTopologicalGraph(nodeSlider.getValue());
                frame = new GraphView(wrapper, GraphView.TOPOLOGICAL);
                break;
            case GraphView.SCC:
                wrapper = GraphTools.generateSCCGraph();
                frame = new GraphView(wrapper, GraphView.SCC);
                break;
            default:
                break;
        }

        displayFrame(frame);
    }//GEN-LAST:event_displayButtonActionPerformed

    private void dfsInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfsInfoButtonActionPerformed
        Frame frame = new InformationFrame(GraphView.DFS);
        displayFrame(frame);
    }//GEN-LAST:event_dfsInfoButtonActionPerformed

    private void dfsRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfsRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dfsRadioActionPerformed

    private void quizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizButtonActionPerformed
        QuizTools qtools = new QuizTools();
        qtools.main();
        QuizFrame frame = new QuizFrame(qtools.quiz);
        
        displayFrame(frame);
    }//GEN-LAST:event_quizButtonActionPerformed

    private void exerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciseButtonActionPerformed
        ExerciseFrame frame = new ExerciseFrame();
        displayFrame(frame);
    }//GEN-LAST:event_exerciseButtonActionPerformed

    private void bfsInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfsInfoButtonActionPerformed
        Frame frame = new InformationFrame(GraphView.BFS);
        displayFrame(frame);
    }//GEN-LAST:event_bfsInfoButtonActionPerformed

    private void topologicalInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topologicalInfoButtonActionPerformed
        Frame frame = new InformationFrame(GraphView.TOPOLOGICAL);
        displayFrame(frame);
    }//GEN-LAST:event_topologicalInfoButtonActionPerformed

    private void sccInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sccInfoButtonActionPerformed
        Frame frame = new InformationFrame(GraphView.SCC);
        displayFrame(frame);
    }//GEN-LAST:event_sccInfoButtonActionPerformed

    /**
     * Display a frame in the middle of the screen.
     * @param frame View to be displayed
     */
    private void displayFrame(Frame frame) {
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth();
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight();

        int x = (screenWidth) / 2;
        int y = (screenHeight) / 2;

        frame.setLocation(x, y);
        frame.setVisible(true);
    }

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
                if ("Macintosh".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainView view = new MainView();
                int x = (Toolkit.getDefaultToolkit().getScreenSize().width - view.getWidth()) / 2;
                int y = (Toolkit.getDefaultToolkit().getScreenSize().height - view.getHeight()) / 2;

                view.setLocation(x, y);
                view.setVisible(true);
                view.setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel algorithmsLabel;
    private javax.swing.JButton bfsInfoButton;
    private javax.swing.JRadioButton bfsRadio;
    private javax.swing.JLabel creditLabel;
    private javax.swing.JButton dfsInfoButton;
    private javax.swing.JRadioButton dfsRadio;
    private javax.swing.JButton displayButton;
    private javax.swing.JLabel edgeSizeLabel;
    private javax.swing.JSlider edgeSlider;
    private javax.swing.JLabel edgesLabel;
    private javax.swing.JButton exerciseButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JLabel nodeSizeLabel;
    private javax.swing.JSlider nodeSlider;
    private javax.swing.JLabel nodesLabel;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JButton quizButton;
    private javax.swing.JButton sccInfoButton;
    private javax.swing.JRadioButton sccRadio;
    private javax.swing.JButton topologicalInfoButton;
    private javax.swing.JRadioButton topologicalRadio;
    // End of variables declaration//GEN-END:variables
}
