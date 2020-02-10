/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dapur;

import auth.logOut;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.mysql;
import models.sessionID;

/**
 *
 * @author DELL
 */
public class dapur extends javax.swing.JFrame {
    private mysql db;
    private Statement stm;
    private ResultSet res;

    /**
     * Creates new form dapurHome
     */
    public dapur() {
        initComponents();
    
        setTitle("DAPUR RESTORAN JAVA");
        setPreferredSize(new Dimension(1024, 768));
        setResizable(false);
        setLocationRelativeTo(null);
          
        try {
            this.db = new mysql();
            this.stm = mysql.getConnection().createStatement();
            
            String nama = sessionID.getUserName();
            welcomeMsg.setText("Selamat datang, " + nama);
           
        } catch (SQLException ex) {
            Logger.getLogger(dapur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeMsg = new javax.swing.JLabel();
        menuLink = new javax.swing.JLabel();
        outLink = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kelola Dapur");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomeMsg.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        welcomeMsg.setForeground(new java.awt.Color(255, 255, 255));
        welcomeMsg.setText("Selamat datang, {{dapurName}}");
        getContentPane().add(welcomeMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, -1, -1));

        menuLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/list.png"))); // NOI18N
        menuLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLinkMouseClicked(evt);
            }
        });
        getContentPane().add(menuLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, -1, -1));

        outLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/logout-32.png"))); // NOI18N
        outLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outLinkMouseClicked(evt);
            }
        });
        getContentPane().add(outLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, 30, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/dapur/dapur.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLinkMouseClicked
        try {
            new daftarPesanan().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(dapur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuLinkMouseClicked

    private void outLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outLinkMouseClicked
        new logOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_outLinkMouseClicked

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
            java.util.logging.Logger.getLogger(dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dapur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dapur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel menuLink;
    private javax.swing.JLabel outLink;
    private javax.swing.JLabel welcomeMsg;
    // End of variables declaration//GEN-END:variables
}