/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Shero
 */
public class CaretakerDashboardGUI extends javax.swing.JFrame {

    /**
     * Creates new form CaretakerDashboardGUI
     */
    public CaretakerDashboardGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNameCaretakerDashboard = new javax.swing.JTextField();
        jButtonViewAllVideosCaretakerDashboard = new javax.swing.JButton();
        jButtonViewAllAnimalsCaretakerDashboard = new javax.swing.JButton();
        jButtonRegisterAnimalCaretakerDashboard = new javax.swing.JButton();
        jButtonViewAllBookedVisitsCaretakerDashboard = new javax.swing.JButton();
        jButtonLogoutCaretakerDashboard = new javax.swing.JButton();
        jButtonUpdateAccountCaretakerDashboard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Welcome");

        jTextFieldNameCaretakerDashboard.setEditable(false);
        jTextFieldNameCaretakerDashboard.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButtonViewAllVideosCaretakerDashboard.setText("View All Videos");

        jButtonViewAllAnimalsCaretakerDashboard.setText("View All Animals");
        jButtonViewAllAnimalsCaretakerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewAllAnimalsCaretakerDashboardActionPerformed(evt);
            }
        });

        jButtonRegisterAnimalCaretakerDashboard.setText("Register Animal");
        jButtonRegisterAnimalCaretakerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterAnimalCaretakerDashboardActionPerformed(evt);
            }
        });

        jButtonViewAllBookedVisitsCaretakerDashboard.setText("View All Booked Visits");

        jButtonLogoutCaretakerDashboard.setText("Log out");
        jButtonLogoutCaretakerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutCaretakerDashboardActionPerformed(evt);
            }
        });

        jButtonUpdateAccountCaretakerDashboard.setText("Update Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRegisterAnimalCaretakerDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonViewAllBookedVisitsCaretakerDashboard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonViewAllAnimalsCaretakerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonViewAllVideosCaretakerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNameCaretakerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLogoutCaretakerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonUpdateAccountCaretakerDashboard)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNameCaretakerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonViewAllAnimalsCaretakerDashboard)
                    .addComponent(jButtonRegisterAnimalCaretakerDashboard))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonViewAllBookedVisitsCaretakerDashboard)
                    .addComponent(jButtonViewAllVideosCaretakerDashboard))
                .addGap(18, 18, 18)
                .addComponent(jButtonUpdateAccountCaretakerDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonLogoutCaretakerDashboard)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutCaretakerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutCaretakerDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLogoutCaretakerDashboardActionPerformed

    private void jButtonViewAllAnimalsCaretakerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewAllAnimalsCaretakerDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewAllAnimalsCaretakerDashboardActionPerformed

    private void jButtonRegisterAnimalCaretakerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterAnimalCaretakerDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegisterAnimalCaretakerDashboardActionPerformed

    public JButton getjButtonLogoutCaretakerDashboard() {
        return jButtonLogoutCaretakerDashboard;
    }

    public JButton getjButtonRegisterAnimalCaretakerDashboard() {
        return jButtonRegisterAnimalCaretakerDashboard;
    }

    public JButton getjButtonViewAllAnimalsCaretakerDashboard() {
        return jButtonViewAllAnimalsCaretakerDashboard;
    }

    public JButton getjButtonViewAllBookedVisitsCaretakerDashboard() {
        return jButtonViewAllBookedVisitsCaretakerDashboard;
    }

    public JButton getjButtonViewAllVideosCaretakerDashboard() {
        return jButtonViewAllVideosCaretakerDashboard;
    }

    public JTextField getjTextFieldNameCaretakerDashboard() {
        return jTextFieldNameCaretakerDashboard;
    }

    public JButton getjButtonUpdateAccountCaretakerDashboard() {
        return jButtonUpdateAccountCaretakerDashboard;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaretakerDashboardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaretakerDashboardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaretakerDashboardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaretakerDashboardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaretakerDashboardGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogoutCaretakerDashboard;
    private javax.swing.JButton jButtonRegisterAnimalCaretakerDashboard;
    private javax.swing.JButton jButtonUpdateAccountCaretakerDashboard;
    private javax.swing.JButton jButtonViewAllAnimalsCaretakerDashboard;
    private javax.swing.JButton jButtonViewAllBookedVisitsCaretakerDashboard;
    private javax.swing.JButton jButtonViewAllVideosCaretakerDashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldNameCaretakerDashboard;
    // End of variables declaration//GEN-END:variables
}
