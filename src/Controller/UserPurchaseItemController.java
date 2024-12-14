package Controller;

import GUI.UserPurchaseItemGUI;
import GUI.UserViewShopGUI;
import RMI.SellingItemRMI;
import RMI.UserDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserPurchaseItemController {
    UserPurchaseItemGUI userPurchaseItemGUI;
    Registry registry;
    UserDTO userDTO;
    
    UserPurchaseItemController(UserPurchaseItemGUI userPurchaseItemGUI, Registry registry) {
        this.userPurchaseItemGUI = userPurchaseItemGUI;
        this.registry = registry;
        userDTO = userPurchaseItemGUI.getUser();
        
        userPurchaseItemGUI.getjButtonConfirmPaymentUserPurchase().addActionListener(new purchaseButton());
        userPurchaseItemGUI.getjButtonBackUserPurchase().addActionListener(new backButton());
    }
    
    
    class purchaseButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String payment;
                if (userPurchaseItemGUI.getjRadioButtonCashUserPurchase().isSelected()) {
                    payment = "Cash";
                } else if (userPurchaseItemGUI.getjRadioButtonVisaUserPurchase().isSelected()) {
                    payment = "Visa";
                } else {
                    JOptionPane.showMessageDialog(userPurchaseItemGUI, "Please select a payment method");
                    return;
                }
                
                int quantityRequired = Integer.parseInt(userPurchaseItemGUI.
                        getjSpinnerQuantityUserPurechase().getValue().toString());
                
                int userID = userDTO.getID();
                
                SellingItemRMI sellingItemRMI = (SellingItemRMI) registry.lookup("SellingItem");
                sellingItemRMI.buyItem(quantityRequired, userID, payment);
                JOptionPane.showMessageDialog(userPurchaseItemGUI, "Item purchased successfully");
                backButton();
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(UserPurchaseItemController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(userPurchaseItemGUI, ex.getMessage());
            }
        }
    }
    
    class backButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            backButton();
        }
    }
    
    private void backButton() {
        UserViewShopGUI userViewShopGUI = new UserViewShopGUI(userDTO);
        userViewShopGUI.setVisible(true);
        UserViewShopController userViewShopController = new UserViewShopController(userViewShopGUI, registry);
        userPurchaseItemGUI.dispose();
    }
}
