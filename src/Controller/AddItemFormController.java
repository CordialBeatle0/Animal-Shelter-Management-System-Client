package Controller;

import GUI.AddItemFormGUI;
import GUI.ViewISellingItemGUI;
import GUI.ViewInventoryGUI;
import RMI.SellingItemDTO;
import RMI.SellingItemRMI;
import RMI.UtilityItemDTO;
import RMI.UtilityItemRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.View;

public class AddItemFormController {
    AddItemFormGUI addItemFormGUI;
    Registry registry;

    public AddItemFormController(AddItemFormGUI addItemFormGUI, Registry registry) {
        this.addItemFormGUI = addItemFormGUI;
        this.registry = registry;

        addItemFormGUI.getjButton1AddItem().addActionListener(new AddItemBtnAction());
        addItemFormGUI.getjButtonBack().addActionListener(new BackBtnAction());
    }

    class AddItemBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = addItemFormGUI.getjTextFieldItemName().getText();
                String quantity = addItemFormGUI.getjTextFieldItemQuantity().getText();
                String price = addItemFormGUI.getjTextFieldPrice().getText();
                
                SellingItemDTO sellingItemDTO = new SellingItemDTO(name, Integer.parseInt(quantity), "InStock",
                        Float.parseFloat(price));
                SellingItemRMI sellingItemRMI = (SellingItemRMI) registry.lookup("SellingItem");
                sellingItemRMI.addSellingItem(sellingItemDTO);
                
                ViewISellingItemGUI viewInventoryGUI = new ViewISellingItemGUI(addItemFormGUI.getAdminDTO());
                ViewSellingItemController viewInventoryController = new ViewSellingItemController(viewInventoryGUI,
                        registry);
                viewInventoryGUI.setVisible(true);
                addItemFormGUI.dispose();

            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(AddItemFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class BackBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewISellingItemGUI viewInventoryGUI = new ViewISellingItemGUI(addItemFormGUI.getAdminDTO());
            ViewSellingItemController viewInventoryController = new ViewSellingItemController(viewInventoryGUI,
                    registry);
            viewInventoryGUI.setVisible(true);
            addItemFormGUI.dispose();
        }
    }
}
