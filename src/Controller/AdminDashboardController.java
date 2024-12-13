package Controller;

import GUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;

public class AdminDashboardController {
    AdminDashboardGUI adminDashboardGUI;
    Registry registry;
    
    public AdminDashboardController(AdminDashboardGUI adminDashboardGUI, Registry registry) {
        this.adminDashboardGUI = adminDashboardGUI;
        this.registry = registry;
        
        adminDashboardGUI.getjButtonAdminManageAccount().addActionListener(new ManageAccountsBtnAction());
        adminDashboardGUI.getjButtonLogout().addActionListener(new LogoutBtnAction());
        adminDashboardGUI.getjButtonViewInventory().addActionListener(new ViewInventoryBtnAction());
        adminDashboardGUI.getjButtonViewSellingItems().addActionListener(new ViewSellingItemsBtnAction());
        adminDashboardGUI.getjButtonAdminViewAllAnimals().addActionListener(new ViewAllAnimalsBtnAction());
        adminDashboardGUI.getjButtonAdminViewAllVolunteeringTasks().addActionListener(new ViewAllVolunteeringTasksBtnAction());
    }
    
    class ViewInventoryBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewInventoryGUI viewInventoryGUI = new ViewInventoryGUI(adminDashboardGUI.getAdminDTO());
            viewInventoryGUI.setVisible(true);
            adminDashboardGUI.dispose();
        }
    }
    
    class ViewSellingItemsBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewISellingItemGUI viewISellingItemGUI = new ViewISellingItemGUI(adminDashboardGUI.getAdminDTO());
            viewISellingItemGUI.setVisible(true);
            adminDashboardGUI.dispose();
        }
    }
    
    class ViewAllAnimalsBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Add code to view all animals
        }
    }
    
    class ViewAllVolunteeringTasksBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminViewAllVolunteeringTasksGUI adminViewAllVolunteeringTasksGUI = new AdminViewAllVolunteeringTasksGUI(adminDashboardGUI.getAdminDTO());
            adminViewAllVolunteeringTasksGUI.setVisible(true);
            adminDashboardGUI.dispose();
        }
    }
    
    class ManageAccountsBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ManageAccountGUI manageAccountGUI = new ManageAccountGUI(adminDashboardGUI.getAdminDTO());
            manageAccountGUI.setVisible(true);
            adminDashboardGUI.dispose();
        }
    }
    
    class LogoutBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
            adminDashboardGUI.dispose();
        }
    }
}

