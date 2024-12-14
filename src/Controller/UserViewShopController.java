package Controller;

import GUI.UserDashboardGUI;
import GUI.UserPurchaseItemGUI;
import GUI.UserViewShopGUI;
import RMI.SellingItemDTO;
import RMI.SellingItemRMI;
import RMI.UserDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserViewShopController {
    UserViewShopGUI userViewShopGUI;
    Registry registry;
    UserDTO userDTO;
    SellingItemRMI sellingItemRMI;
    DefaultTableModel tableModel;
    
    public UserViewShopController(UserViewShopGUI userViewShopGUI, Registry registry) {
        this.userViewShopGUI = userViewShopGUI;
        this.registry = registry;
        userDTO = userViewShopGUI.getUser();
        tableModel = (DefaultTableModel) userViewShopGUI.getjTableShopItemsUserShop().getModel();
        try {
            sellingItemRMI = (SellingItemRMI) registry.lookup("SellingItem");
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(UserViewShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        userViewShopGUI.getjButtonBackUserShop().addActionListener(new backButton());
        userViewShopGUI.getJButtonBuy().addActionListener(new buyButton());
    }
    
    class backButton implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            backButton();
        }
    }
    
    class buyButton implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            int row = userViewShopGUI.getjTableShopItemsUserShop().getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(userViewShopGUI, "Please select an item to buy");
                return;
            }
            
            int ID = (int) userViewShopGUI.getjTableShopItemsUserShop().getValueAt(row, 0);
            String name = (String) userViewShopGUI.getjTableShopItemsUserShop().getValueAt(row, 1);
            int quantity = (int) userViewShopGUI.getjTableShopItemsUserShop().getValueAt(row, 2);
            float price = (int) userViewShopGUI.getjTableShopItemsUserShop().getValueAt(row, 3);
            
            SellingItemDTO sellingItemDTO = new SellingItemDTO(ID, name, quantity, null, price);
            
            UserPurchaseItemGUI userPurchaseItemGUI = new UserPurchaseItemGUI(userDTO, sellingItemDTO);
            UserPurchaseItemController userPurchaseItemController = new UserPurchaseItemController(userPurchaseItemGUI, registry);
            userPurchaseItemGUI.setVisible(true);
            userViewShopGUI.dispose();
        }
    }
    
    private void loadTable() throws RemoteException {
        ArrayList<SellingItemDTO> shop = sellingItemRMI.viewAllSellingItems();
        
        int columns;
        int row = 0;
        
        tableModel.setRowCount(0);
        
        for (SellingItemDTO sellingItemDTO : shop) {
            columns = 0;
            tableModel.addRow(new Object[]{});
            tableModel.setValueAt(sellingItemDTO.getID(), row, columns++);
            tableModel.setValueAt(sellingItemDTO.getName(), row, columns++);
            tableModel.setValueAt(sellingItemDTO.getQuantity(), row, columns++);
            tableModel.setValueAt(sellingItemDTO.getPrice(), row, columns);
            row++;
        }
    }
    
    private void backButton() {
        UserDashboardGUI userDashboardGUI = new UserDashboardGUI(userDTO);
        userDashboardGUI.setVisible(true);
        UserDashboardController userDashboardController = new UserDashboardController(userDashboardGUI, registry);
        userViewShopGUI.dispose();
    }
}
