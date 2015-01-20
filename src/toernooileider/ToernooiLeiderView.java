/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toernooileider;

import java.awt.*;
import java.sql.Connection;

/**
 *
 * @author jannedevos
 */
public class ToernooiLeiderView extends javax.swing.JFrame {

    Connection conn;

    
    public ToernooiLeiderView() 
    {
        try 
        {
            conn = SimpleDataSource.getConnection();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        initComponents();
        
    }
    
    public void setEvenementID(int evenementID)
    {
        CardLayout cl = (CardLayout) tlPanel.getLayout();
        cl.show(tlPanel, "tafelPanel");
        tafelPanel1.setEvenementID(evenementID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toernooiBut = new javax.swing.JButton();
        tlPanel = new javax.swing.JPanel();
        toernooiPanel1 = new ToernooiPanel(this);
        positiePanel1 = new toernooileider.PositiePanel();
        tafelPanel1 = new TafelPanel(this);
        tafelsbut = new javax.swing.JButton();
        positieBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toernooiBut.setText("Toernooi");
        toernooiBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toernooiButMouseClicked(evt);
            }
        });
        toernooiBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toernooiButActionPerformed(evt);
            }
        });

        tlPanel.setLayout(new java.awt.CardLayout());

        toernooiPanel1.setName("toernooiPanel"); // NOI18N
        tlPanel.add(toernooiPanel1, "toernooiPanel");
        tlPanel.add(positiePanel1, "positiePanel");
        tlPanel.add(tafelPanel1, "tafelPanel");

        tafelsbut.setText("Tafels");
        tafelsbut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tafelsbutMouseClicked(evt);
            }
        });
        tafelsbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tafelsbutActionPerformed(evt);
            }
        });

        positieBut.setText("Positie");
        positieBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positieButMouseClicked(evt);
            }
        });
        positieBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positieButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toernooiBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tafelsbut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(positieBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tafelsbut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toernooiBut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(positieBut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toernooiButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toernooiButActionPerformed
        
    }//GEN-LAST:event_toernooiButActionPerformed

    private void tafelsbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tafelsbutActionPerformed
        
    }//GEN-LAST:event_tafelsbutActionPerformed

    private void positieButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positieButActionPerformed
        CardLayout cl = (CardLayout) tlPanel.getLayout();
        cl.show(tlPanel, "positiePanel");
    }//GEN-LAST:event_positieButActionPerformed

    private void toernooiButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toernooiButMouseClicked
        CardLayout cl = (CardLayout) tlPanel.getLayout();
        cl.show(tlPanel, "toernooiPanel");
    }//GEN-LAST:event_toernooiButMouseClicked

    private void tafelsbutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tafelsbutMouseClicked
        CardLayout cl = (CardLayout) tlPanel.getLayout();
        cl.show(tlPanel, "tafelPanel");
    }//GEN-LAST:event_tafelsbutMouseClicked

    private void positieButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positieButMouseClicked
        CardLayout cl = (CardLayout) tlPanel.getLayout();
        cl.show(tlPanel, "positiePanel");
    }//GEN-LAST:event_positieButMouseClicked

 
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        try {
            SimpleDataSource.closeConnection();
            System.out.println("Connection closed.");
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Could not close connection!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton positieBut;
    private toernooileider.PositiePanel positiePanel1;
    private toernooileider.TafelPanel tafelPanel1;
    private javax.swing.JButton tafelsbut;
    private javax.swing.JPanel tlPanel;
    private javax.swing.JButton toernooiBut;
    private toernooileider.ToernooiPanel toernooiPanel1;
    // End of variables declaration//GEN-END:variables
}