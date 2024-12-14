package Controller;

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

import GUI.ViewISellingItemGUI;
import GUI.AdminDashboardGUI;
import GUI.AddItemFormGUI;

import RMI.SellingItemDTO;
import RMI.SellingItemRMI;
import RMI.AdminDTO;

public class ViewSellingItemController {
    ViewISellingItemGUI viewSellingItemGUI;
    Registry registry;
    JTable jTableAdminPurchaseList;
    DefaultTableModel tableModel;
    SellingItemRMI sellingItemRMI;

    public ViewSellingItemController(ViewISellingItemGUI viewSellingItemGUI, Registry registry) {
        this.viewSellingItemGUI = viewSellingItemGUI;
        this.registry = registry;
        jTableAdminPurchaseList = viewSellingItemGUI.getjTableAdminSellingItems();
        tableModel = (DefaultTableModel) jTableAdminPurchaseList.getModel();
        try {
            sellingItemRMI = (SellingItemRMI) registry.lookup("SellingItem");
            loadTable();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ViewSellingItemController.class.getName()).log(Level.SEVERE, null, ex);
        }

        viewSellingItemGUI.getjButtonAdminBack().addActionListener(new AdminBackBtnAction());
        viewSellingItemGUI.getjButton1AddItem().addActionListener(new AdminAddBtnAction());
        viewSellingItemGUI.getjButton2RemoveItem().addActionListener(new AdminRemoveBtnAction());
    }

    class AdminBackBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminDashboardGUI adminDashboardGUI = new AdminDashboardGUI(viewSellingItemGUI.getAdminDTO());
            AdminDashboardController adminDashboardController = new AdminDashboardController(adminDashboardGUI,
                    registry);
            viewSellingItemGUI.dispose();
            adminDashboardGUI.setVisible(true);
        }
    }

    class AdminAddBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddItemFormGUI addItemFormGUI = new AddItemFormGUI(viewSellingItemGUI.getAdminDTO());
            AddItemFormController addItemFormController = new AddItemFormController(addItemFormGUI, registry);
            viewSellingItemGUI.dispose();
            addItemFormGUI.setVisible(true);
        }
    }

    class AdminRemoveBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int row = jTableAdminPurchaseList.getSelectedRow();
                int ID = (int) jTableAdminPurchaseList.getValueAt(row, 0);

                SellingItemDTO item = sellingItemRMI.viewSellingItem(ID);
                sellingItemRMI.removeSellingItem(item);
                loadTable();
            } catch (RemoteException ex) {
                Logger.getLogger(ViewSellingItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadTable() throws RemoteException {
        ArrayList<SellingItemDTO> items = sellingItemRMI.viewAllSellingItems();

        int columns;
        int rows = 0;

        tableModel.setRowCount(0);

        for (SellingItemDTO item : items) {
            columns = 0;
            tableModel.addRow(new Object[] {});
            jTableAdminPurchaseList.setValueAt(item.getID(), rows, columns++);
            jTableAdminPurchaseList.setValueAt(item.getName(), rows, columns++);
            jTableAdminPurchaseList.setValueAt(item.getQuantity(), rows, columns);
            rows++;
        }
    }
}
