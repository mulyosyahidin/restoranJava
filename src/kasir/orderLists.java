/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.helperClass;
import models.mysql;

/**
 *
 * @author DELL
 */
public class orderLists extends javax.swing.JFrame {

    private final mysql db;
    private final Statement stm;
    private ResultSet res;

    /**
     * Creates new form daftarPesanan
     *
     * @throws java.sql.SQLException
     */
    public orderLists() throws SQLException {
         initComponents();
         
        this.db = new mysql();
        this.stm = mysql.getConnection().createStatement();
        
        setTitle("DAFTAR ORDER");
        setPreferredSize(new Dimension(500, 800));
        setResizable(false);
        setLocationRelativeTo(null);
        
        this.fillOrderLists();

        pack();
    }

    private void fillOrderLists() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) orderLists.getModel();

        String getOrder = "SELECT * FROM `orders` ORDER BY `orderTime` ASC";
        ResultSet go = this.stm.executeQuery(getOrder);
        if (go.next()) {
            while (go.next()) {
                int ID = go.getInt("orderID");
                String orderNumber = go.getString("orderNumber");
                int jumlah = go.getInt("orderQuantity");
                Double harga = go.getDouble("totalPrice");
                boolean status = go.getBoolean("status");
                String totalHarga = helperClass.formatRupiah(harga);

                model.addRow(new Object[]{ID, orderNumber, jumlah, totalHarga});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JLabel();
        newBtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderLists = new javax.swing.JTable();
        background = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/back.png"))); // NOI18N
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        newBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/new32.png"))); // NOI18N
        newBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBtnMouseClicked(evt);
            }
        });
        getContentPane().add(newBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        orderLists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Order ID", "Jumlah", "Total Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderLists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderListsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderLists);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 460, 340));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/kasir/order list.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 1630, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void orderListsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderListsMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) orderLists.getModel();
            int sel = orderLists.getSelectedRow();
            String ID = model.getValueAt(sel, 0).toString();
            int orderID = Integer.parseInt(ID);
            
            viewOrder v = new viewOrder(orderID);
            v.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(orderLists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_orderListsMouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        try {
            new kasir().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(orderLists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backBtnMouseClicked

    private void newBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBtnMouseClicked
        try {
            new createOrder().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(orderLists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newBtnMouseClicked

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
            java.util.logging.Logger.getLogger(orderLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new orderLists().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(orderLists.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtn;
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel newBtn;
    private javax.swing.JTable orderLists;
    // End of variables declaration//GEN-END:variables
}
