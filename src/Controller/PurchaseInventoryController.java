package Controller;

import GUI.PurchaseInventoryGUI;
import GUI.ViewInventoryGUI;
import RMI.UtilityItemDTO;
import RMI.UtilityItemRMI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseInventoryController {
    PurchaseInventoryGUI purchaseInventoryGUI;
    Registry registry;
    JTable jTableAdminPurchaseList;
    DefaultTableModel tableModel;
    UtilityItemRMI utilityItemRMI;
    
    public PurchaseInventoryController(PurchaseInventoryGUI purchaseInventoryGUI, Registry registry) {
        this.purchaseInventoryGUI = purchaseInventoryGUI;
        this.registry = registry;
        jTableAdminPurchaseList = purchaseInventoryGUI.getjTableAdminPurchaseList();
        tableModel = (DefaultTableModel) jTableAdminPurchaseList.getModel();
        try {
            utilityItemRMI = (UtilityItemRMI) registry.lookup("UtilityItem");
            loadTable();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(PurchaseInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        purchaseInventoryGUI.getjButtonPurchaseItems().addActionListener(new PurchaseItemsBtnAction());
        purchaseInventoryGUI.getjButtonAdminBack().addActionListener(new AdminBackBtnAction());
    }
    
    class PurchaseItemsBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                for (int i = 0; i < jTableAdminPurchaseList.getRowCount(); i++) {
                    if ((boolean) jTableAdminPurchaseList.getValueAt(i, 4)) {
                        int ID = (int) jTableAdminPurchaseList.getValueAt(i, 0);
                        String name = (String) jTableAdminPurchaseList.getValueAt(i, 1);
                        int quantity = (int) jTableAdminPurchaseList.getValueAt(i, 5);
                        UtilityItemDTO item = new UtilityItemDTO(ID, name, quantity);
                        utilityItemRMI.addItem(item);
                    }
                }
                JOptionPane.showMessageDialog(purchaseInventoryGUI, "Items purchased successfully");
                backButton();
            } catch (RemoteException ex) {
                Logger.getLogger(PurchaseInventoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class AdminBackBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            backButton();
        }
    }
    
    private void loadTable() throws RemoteException {
        ArrayList<UtilityItemDTO> items = utilityItemRMI.purchaseInventory();
        
        int columns;
        int rows = 0;
        
        tableModel.setRowCount(0);
        
        for (UtilityItemDTO item : items) {
            columns = 0;
            tableModel.addRow(new Object[]{});
            jTableAdminPurchaseList.setValueAt(item.getID(), rows, columns++);
            jTableAdminPurchaseList.setValueAt(item.getName(), rows, columns++);
            jTableAdminPurchaseList.setValueAt(item.getQuantity(), rows, columns++);
            jTableAdminPurchaseList.setValueAt(item.getRestockThreshold(), rows, columns++);
            jTableAdminPurchaseList.setValueAt(false, rows, columns++);
            jTableAdminPurchaseList.setValueAt(0, rows, columns);
            rows++;
        }
    }
    
    private void backButton() {
        ViewInventoryGUI viewInventoryGUI = new ViewInventoryGUI(purchaseInventoryGUI.getAdminDTO());
        viewInventoryGUI.setVisible(true);
        ViewInventoryController viewInventoryController = new ViewInventoryController(viewInventoryGUI, registry);
        purchaseInventoryGUI.dispose();
    }
}
