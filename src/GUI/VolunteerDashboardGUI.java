/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import RMI.VolunteerDTO;

import javax.swing.JButton;

/**
 * @author Assar
 */
public class VolunteerDashboardGUI extends javax.swing.JFrame {

    /**
     * Creates new form VolunteerDashboard
     */

    private VolunteerDTO volunteerDTO;

    public VolunteerDashboardGUI() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public VolunteerDashboardGUI(VolunteerDTO volunteerDTO) {
        this.volunteerDTO = volunteerDTO;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonViewAllTasks = new javax.swing.JButton();
        jButtonViewMyTasks = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jButtonVolunteerResigned = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Volunteer Dashboard");

        jButtonViewAllTasks.setText("View All Tasks");
        jButtonViewAllTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewAllTasksActionPerformed(evt);
            }
        });

        jButtonViewMyTasks.setText("View My Tasks");
        jButtonViewMyTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewMyTasksActionPerformed(evt);
            }
        });

        jButtonLogout.setText("Log out");

        jButtonVolunteerResigned.setText("Resign");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVolunteerResigned, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonViewMyTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonViewAllTasks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonViewMyTasks)
                    .addComponent(jButtonViewAllTasks))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogout)
                    .addComponent(jButtonVolunteerResigned))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewAllTasksActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonViewAllTasksActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonViewAllTasksActionPerformed

    private void jButtonViewMyTasksActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonViewMyTasksActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_jButtonViewMyTasksActionPerformed

    public JButton getjButtonLogout() {
        return jButtonLogout;
    }

    public JButton getjButtonViewAllTasks() {
        return jButtonViewAllTasks;
    }

    public JButton getjButtonViewMyTasks() {
        return jButtonViewMyTasks;
    }

    public JButton getjButtonVolunteerResigned() {
        return jButtonVolunteerResigned;
    }

    public VolunteerDTO getVolunteerDTO() {
        return volunteerDTO;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VolunteerDashboardGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VolunteerDashboardGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VolunteerDashboardGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VolunteerDashboardGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VolunteerDashboardGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonViewAllTasks;
    private javax.swing.JButton jButtonViewMyTasks;
    private javax.swing.JButton jButtonVolunteerResigned;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
