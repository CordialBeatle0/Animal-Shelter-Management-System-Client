package Controller;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import GUI.ManageAccountGUI;
import RMI.AccountRMI;
import RMI.EmployeeDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   

public class ManagAccountController {

    ManageAccountGUI manageAccountGUI;
    Registry registry;
    AccountRMI accountRMI;

    public ManagAccountController(ManageAccountGUI manageAccountGUI, Registry registry) {
        this.manageAccountGUI = manageAccountGUI;
        this.registry = registry;
        try {
            accountRMI = (AccountRMI) registry.lookup("Account");
            uploadData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        manageAccountGUI.getjButton1UpdateAccount().addActionListener(new updateButtonListener());

    }
    
    private void uploadData() {
        if (manageAccountGUI.getEmployeeDTO().getClass().equals("CaretakerDTO")
                || manageAccountGUI.getEmployeeDTO().getClass().equals("AdminDTO")) {
            manageAccountGUI.getjTextFieldUserName()
                    .setText(manageAccountGUI.getEmployeeDTO().getAccount().getUsername());
            manageAccountGUI.getjTextFieldPassword()
                    .setText(manageAccountGUI.getEmployeeDTO().getAccount().getPassword());

        }
        else if (manageAccountGUI.getUserDTO().getClass().equals("UserDTO")) {
            manageAccountGUI.getjTextFieldUserName().setText(manageAccountGUI.getUserDTO().getUsername());
            manageAccountGUI.getjTextFieldPassword().setText(manageAccountGUI.getUserDTO().getPassword());
        }   
    }

    class updateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)  {
            System.out.println(manageAccountGUI.getEmployeeDTO().getClass().getName());
            if (manageAccountGUI.getEmployeeDTO().getClass().getName().equals("CaretakerDTO")
                    || manageAccountGUI.getEmployeeDTO().getClass().getName().equals("AdminDTO")) {
                try {
                    accountRMI.updateSpecialisedAccount(manageAccountGUI.getEmployeeDTO().getID(),
                            manageAccountGUI.getEmployeeDTO().getAccount().getUsername(),
                            manageAccountGUI.getEmployeeDTO().getAccount().getPassword());
                } catch (RemoteException e1) {
                    e1.printStackTrace();

                }

            }
            else if (manageAccountGUI.getUserDTO().getClass().getName().equals("UserDTO")) {
                try {
                    accountRMI.updateUserAccount(manageAccountGUI.getUserDTO(),
                            manageAccountGUI.getUserDTO().getUsername(),
                              manageAccountGUI.getUserDTO().getPassword());
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }
}
