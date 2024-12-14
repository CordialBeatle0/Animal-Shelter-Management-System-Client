/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import RMI.DoctorDTO;

/**
 *
 * @author Shero
 */
public class DoctorViewAllAppointmentsGUI extends javax.swing.JFrame {

    private DoctorDTO doctor;

    /**
     * Creates new form ViewDoctorAppointmentsGUI
     */
    public DoctorViewAllAppointmentsGUI() {

        initComponents();

    }

    public DoctorViewAllAppointmentsGUI(DoctorDTO doctor) {
        initComponents();
        setLocationRelativeTo(null);
        this.doctor = doctor;
        jTextFieldDoctorNameViewDoctorAppointment.setText(doctor.getName());
    }

    public JButton getjButtonBackViewAllDoctorAppointments() {
        return jButtonBackViewAllDoctorAppointments;
    }

    public JButton getjButtonViewAppointmentDoctorAppointments() {
        return jButtonViewAppointmentDoctorAppointments;
    }

    public JTable getjTableViewAllAppointmentsDoctorAppointments() {
        return jTableViewAllAppointmentsDoctorAppointments;
    }

    public JTextField getjTextFieldDoctorNameViewDoctorAppointment() {
        return jTextFieldDoctorNameViewDoctorAppointment;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDoctorNameViewDoctorAppointment = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableViewAllAppointmentsDoctorAppointments = new javax.swing.JTable();
        jButtonViewAppointmentDoctorAppointments = new javax.swing.JButton();
        jButtonBackViewAllDoctorAppointments = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldDoctorNameViewDoctorAppointment.setEditable(false);
        jTextFieldDoctorNameViewDoctorAppointment.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTableViewAllAppointmentsDoctorAppointments.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null }
                },
                new String[] {
                        "ID", "Date", "Price", "Animal Name", "Animal Type", "Description"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableViewAllAppointmentsDoctorAppointments);

        jButtonViewAppointmentDoctorAppointments.setText("View Appointment");

        jButtonBackViewAllDoctorAppointments.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(147, 147, 147)
                                                                .addComponent(jTextFieldDoctorNameViewDoctorAppointment,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(158, 158, 158)
                                                                .addComponent(jButtonViewAppointmentDoctorAppointments))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jButtonBackViewAllDoctorAppointments,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 152, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jTextFieldDoctorNameViewDoctorAppointment,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonViewAppointmentDoctorAppointments)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBackViewAllDoctorAppointments)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DoctorViewAllAppointmentsGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorViewAllAppointmentsGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorViewAllAppointmentsGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorViewAllAppointmentsGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorViewAllAppointmentsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackViewAllDoctorAppointments;
    private javax.swing.JButton jButtonViewAppointmentDoctorAppointments;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableViewAllAppointmentsDoctorAppointments;
    private javax.swing.JTextField jTextFieldDoctorNameViewDoctorAppointment;
    // End of variables declaration//GEN-END:variables
}
