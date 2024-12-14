package Controller;

import GUI.AddItemFormGUI;
import GUI.AdminDashboardGUI;
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

public class ViewInventoryController {
    ViewInventoryGUI viewInventoryGUI;
    Registry registry;

    public ViewInventoryController(ViewInventoryGUI viewInventoryGUI, Registry registry) {
        this.viewInventoryGUI = viewInventoryGUI;
        this.registry = registry;

        viewInventoryGUI.getjButtonAdminBack().addActionListener(new ViewInventoryBackBtnAction());
        viewInventoryGUI.getjButtonPurchaseList().addActionListener(new ViewInventoryPurchaseBtnAction());
        viewInventoryGUI.getjButton1AddItem().addActionListener(new ViewInventoryAddItemBtnAction());
        fillTable();
    }

    public void fillTable() {
        try {
            UtilityItemRMI utilityItemRMI = (UtilityItemRMI) registry.lookup("UtilityItem");
            ArrayList<UtilityItemDTO> utilityItemsDTO = utilityItemRMI.viewAllUtilityItems();
            JTable table = viewInventoryGUI.getjTableAdminInventoryItems();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (UtilityItemDTO utilityItemDTO : utilityItemsDTO) {
                Object[] row = { utilityItemDTO.getID(), utilityItemDTO.getName(), utilityItemDTO.getQuantity(),
                        utilityItemDTO.getPrice() };
                model.addRow(row);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ViewInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class ViewInventoryBackBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminDashboardGUI adminDashboardGUI = new AdminDashboardGUI(viewInventoryGUI.getAdminDTO());
            AdminDashboardController adminDashboardController = new AdminDashboardController(adminDashboardGUI,
                    registry);
            adminDashboardGUI.setVisible(true);
            viewInventoryGUI.dispose();
        }
    }

    class ViewInventoryPurchaseBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PurchaseInventoryGUI purchaseInventoryGUI = new PurchaseInventoryGUI(viewInventoryGUI.getAdminDTO());
            PurchaseInventoryController purchaseInventoryController = new PurchaseInventoryController(
                    purchaseInventoryGUI,
                    registry);
            purchaseInventoryGUI.setVisible(true);
            viewInventoryGUI.dispose();
        }
    }

    class ViewInventoryAddItemBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddItemFormGUI addItemFormGUI = new AddItemFormGUI();
            AddItemFormController addItemFormController = new AddItemFormController(addItemFormGUI, registry);
            addItemFormGUI.setVisible(true);
            viewInventoryGUI.dispose();
        }
    }

    class ViewInventoryRemoveItemBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                DefaultTableModel tableModel = (DefaultTableModel) viewInventoryGUI.getjTableAdminInventoryItems()
                        .getModel();
                int selectedRow = viewInventoryGUI.getjTableAdminInventoryItems().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(viewInventoryGUI, "Please select an item to remove");
                    return;
                }

                // Confirm deletion
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this item?",
                        "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }

                UtilityItemRMI utilityItemRMI = (UtilityItemRMI) registry.lookup("UtilityItem");
                utilityItemRMI.removeItem();

                tableModel.removeRow(selectedRow);
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(ViewInventoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
