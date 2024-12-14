package Controller;
import GUI.*;
import RMI.SubscriptionRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class UserPaymentController {
    
    private UserPaymentGUI gui;
    private Registry r;
    private boolean subscribing;

    public UserPaymentController(UserPaymentGUI gui, Registry r, boolean subscribing) {
        this.gui = gui;
        this.r = r;
        this.subscribing = subscribing;

        //fillinf in the text fields
        gui.getJTextFieldUserName().setText(gui.getUserDTO().getName());
        if(subscribing)
            gui.getJTextFieldOutstandingFees().setText("10");
        else
            //selling stuff;
        

        gui.getJButtonConfirmCashPayment().addActionListener(new confirmPayment());
    }

    class confirmPayment implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String paymentMethod = "";
                if (gui.getJRadioButtonCash().isSelected()) {
                    paymentMethod = "cash";
                } else if (gui.getJRadioButtonVisa().isSelected()) {
                    paymentMethod = "visa";
                }
                

                if (subscribing) {
                    SubscriptionRMI subRMI = (SubscriptionRMI) r.lookup("Subscription");
                    subRMI.subscribeToTraining(gui.getUserDTO(), 10 , paymentMethod);
                } else {
                    // Handle selling payments here
                }
                
                JOptionPane.showMessageDialog(null, "Payment Confirmed");
                gui.dispose();
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error processing payment: " + e.getMessage());
            }
        }
    }

}
