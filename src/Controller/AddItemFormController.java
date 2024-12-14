package Controller;

import GUI.AddItemFormGUI;
import GUI.ViewISellingItemGUI;
import GUI.ViewInventoryGUI;
import RMI.UtilityItemDTO;
import RMI.UtilityItemRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddItemFormController {
    AddItemFormGUI addItemFormGUI;
    Registry registry;

    public AddItemFormController(AddItemFormGUI addItemFormGUI, Registry registry) {
        this.addItemFormGUI = addItemFormGUI;
        this.registry = registry;

        addItemFormGUI.getjButton1AddItem().addActionListener(new AddItemBtnAction());
        addItemFormGUI.getjButton1AddItem().addActionListener(new AddItemBtnAction());
    }

    class AddItemBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = addItemFormGUI.getjTextFieldItemName().getText();
                String quantity = addItemFormGUI.getjTextFieldItemQuantity().getText();
                String price = addItemFormGUI.getjTextFieldPrice().getText();
                String restockThreshold = addItemFormGUI.getjTextFieldRestockThreshold().getText();

                UtilityItemDTO utilityItemDTO = new UtilityItemDTO(name, Float.parseFloat(price),
                        Integer.parseInt(quantity), Integer.parseInt(restockThreshold));
                UtilityItemRMI utilityItemRMI = (UtilityItemRMI) registry.lookup("UtilityItem");
                utilityItemRMI.addItem(utilityItemDTO);

                ViewInventoryGUI viewInventoryGUI = new ViewInventoryGUI(addItemFormGUI.getAdminDTO());
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
