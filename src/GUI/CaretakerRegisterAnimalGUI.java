/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Shero
 */
public class CaretakerRegisterAnimalGUI extends javax.swing.JFrame {

    /**
     * Creates new form RegisterAnimalGUI
     */
    public CaretakerRegisterAnimalGUI() {
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

        buttonGroupAdoptedStatusRegister = new javax.swing.ButtonGroup();
        buttonGroupSponsoredStatusRegister = new javax.swing.ButtonGroup();
        buttonGroupFosteredStatusRegister = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonRegisterAnimalRegisteration = new javax.swing.JButton();
        jButtonBackRegisterAnimal = new javax.swing.JButton();
        jTextFieldAnimalIDRegister = new javax.swing.JTextField();
        jTextFieldAnimalNameRegister = new javax.swing.JTextField();
        jTextFieldAnimalBreedRegister = new javax.swing.JTextField();
        jTextFieldAnimalTypeRegister = new javax.swing.JTextField();
        jTextFieldAnimalAge = new javax.swing.JTextField();
        jTextFieldLastFeedingRegister = new javax.swing.JTextField();
        jRadioButtonTrueAdoptedStatus = new javax.swing.JRadioButton();
        jRadioButtonFalseAdoptedStatus = new javax.swing.JRadioButton();
        jRadioButtonTrueSponsored = new javax.swing.JRadioButton();
        jRadioButtonFalseSponsored = new javax.swing.JRadioButton();
        jRadioButtonTrueFostered = new javax.swing.JRadioButton();
        jRadioButtonFalseFostered = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Register Animal");

        jLabel2.setText("Animal ID");

        jLabel3.setText("Animal Name");

        jLabel4.setText("Animal Type");

        jLabel5.setText("Animal Breed");

        jLabel6.setText("Animal Age");

        jLabel7.setText("Last Feeding Time");

        jLabel8.setText("Adopted Status");

        jLabel9.setText("Sponsored Status");

        jLabel10.setText("Fostered Status");

        jButtonRegisterAnimalRegisteration.setText("Register Animal");
        jButtonRegisterAnimalRegisteration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterAnimalRegisterationActionPerformed(evt);
            }
        });

        jButtonBackRegisterAnimal.setText("Back");

        jTextFieldAnimalIDRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnimalIDRegisterActionPerformed(evt);
            }
        });

        buttonGroupAdoptedStatusRegister.add(jRadioButtonTrueAdoptedStatus);
        jRadioButtonTrueAdoptedStatus.setText("True");

        buttonGroupAdoptedStatusRegister.add(jRadioButtonFalseAdoptedStatus);
        jRadioButtonFalseAdoptedStatus.setText("False");

        buttonGroupSponsoredStatusRegister.add(jRadioButtonTrueSponsored);
        jRadioButtonTrueSponsored.setText("True");

        buttonGroupSponsoredStatusRegister.add(jRadioButtonFalseSponsored);
        jRadioButtonFalseSponsored.setText("False");

        buttonGroupFosteredStatusRegister.add(jRadioButtonTrueFostered);
        jRadioButtonTrueFostered.setText("True");

        buttonGroupFosteredStatusRegister.add(jRadioButtonFalseFostered);
        jRadioButtonFalseFostered.setText("False");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldAnimalNameRegister)
                                .addComponent(jTextFieldAnimalIDRegister)
                                .addComponent(jTextFieldAnimalTypeRegister)
                                .addComponent(jTextFieldAnimalBreedRegister)
                                .addComponent(jTextFieldAnimalAge)
                                .addComponent(jTextFieldLastFeedingRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonTrueAdoptedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButtonTrueSponsored, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButtonTrueFostered, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButtonFalseAdoptedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButtonFalseSponsored, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jRadioButtonFalseFostered, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBackRegisterAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1)))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonRegisterAnimalRegisteration)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAnimalIDRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAnimalNameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAnimalTypeRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldAnimalBreedRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldAnimalAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldLastFeedingRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButtonTrueAdoptedStatus)
                    .addComponent(jRadioButtonFalseAdoptedStatus))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jRadioButtonTrueSponsored)
                    .addComponent(jRadioButtonFalseSponsored))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jRadioButtonTrueFostered)
                    .addComponent(jRadioButtonFalseFostered))
                .addGap(18, 18, 18)
                .addComponent(jButtonRegisterAnimalRegisteration)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButtonBackRegisterAnimal)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegisterAnimalRegisterationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterAnimalRegisterationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegisterAnimalRegisterationActionPerformed

    private void jTextFieldAnimalIDRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnimalIDRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnimalIDRegisterActionPerformed

    public ButtonGroup getButtonGroupAdoptedStatusRegister() {
        return buttonGroupAdoptedStatusRegister;
    }

    public ButtonGroup getButtonGroupFosteredStatusRegister() {
        return buttonGroupFosteredStatusRegister;
    }

    public ButtonGroup getButtonGroupSponsoredStatusRegister() {
        return buttonGroupSponsoredStatusRegister;
    }

    public JButton getjButtonBackRegisterAnimal() {
        return jButtonBackRegisterAnimal;
    }

    public JButton getjButtonRegisterAnimalRegisteration() {
        return jButtonRegisterAnimalRegisteration;
    }

    public JRadioButton getjRadioButtonFalseAdoptedStatus() {
        return jRadioButtonFalseAdoptedStatus;
    }

    public JRadioButton getjRadioButtonFalseFostered() {
        return jRadioButtonFalseFostered;
    }

    public JRadioButton getjRadioButtonFalseSponsored() {
        return jRadioButtonFalseSponsored;
    }

    public JRadioButton getjRadioButtonTrueAdoptedStatus() {
        return jRadioButtonTrueAdoptedStatus;
    }

    public JRadioButton getjRadioButtonTrueFostered() {
        return jRadioButtonTrueFostered;
    }

    public JRadioButton getjRadioButtonTrueSponsored() {
        return jRadioButtonTrueSponsored;
    }

    public JTextField getjTextFieldAnimalAge() {
        return jTextFieldAnimalAge;
    }

    public JTextField getjTextFieldAnimalBreedRegister() {
        return jTextFieldAnimalBreedRegister;
    }

    public JTextField getjTextFieldAnimalIDRegister() {
        return jTextFieldAnimalIDRegister;
    }

    public JTextField getjTextFieldAnimalNameRegister() {
        return jTextFieldAnimalNameRegister;
    }

    public JTextField getjTextFieldAnimalTypeRegister() {
        return jTextFieldAnimalTypeRegister;
    }

    public JTextField getjTextFieldLastFeedingRegister() {
        return jTextFieldLastFeedingRegister;
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
            java.util.logging.Logger.getLogger(CaretakerRegisterAnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaretakerRegisterAnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaretakerRegisterAnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaretakerRegisterAnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaretakerRegisterAnimalGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAdoptedStatusRegister;
    private javax.swing.ButtonGroup buttonGroupFosteredStatusRegister;
    private javax.swing.ButtonGroup buttonGroupSponsoredStatusRegister;
    private javax.swing.JButton jButtonBackRegisterAnimal;
    private javax.swing.JButton jButtonRegisterAnimalRegisteration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButtonFalseAdoptedStatus;
    private javax.swing.JRadioButton jRadioButtonFalseFostered;
    private javax.swing.JRadioButton jRadioButtonFalseSponsored;
    private javax.swing.JRadioButton jRadioButtonTrueAdoptedStatus;
    private javax.swing.JRadioButton jRadioButtonTrueFostered;
    private javax.swing.JRadioButton jRadioButtonTrueSponsored;
    private javax.swing.JTextField jTextFieldAnimalAge;
    private javax.swing.JTextField jTextFieldAnimalBreedRegister;
    private javax.swing.JTextField jTextFieldAnimalIDRegister;
    private javax.swing.JTextField jTextFieldAnimalNameRegister;
    private javax.swing.JTextField jTextFieldAnimalTypeRegister;
    private javax.swing.JTextField jTextFieldLastFeedingRegister;
    // End of variables declaration//GEN-END:variables
}