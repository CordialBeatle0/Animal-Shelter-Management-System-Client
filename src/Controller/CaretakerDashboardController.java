package Controller;

import java.rmi.registry.Registry;

import javax.swing.text.Caret;

import GUI.CaretakerDashboardGUI;
import GUI.CaretakerRegisterAnimalGUI;
import GUI.EmployeeViewAllAnimalsGUI;
import GUI.EmployeeViewBookedVisitsGUI;
import GUI.EmployeeViewAllVideosGUI;
import GUI.LoginGUI;
import GUI.ManageAccountGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaretakerDashboardController {
    CaretakerDashboardGUI caretakerDashboardGUI;
    Registry registry;

    public CaretakerDashboardController(CaretakerDashboardGUI caretakerDashboardGUI, Registry registry) {
        this.caretakerDashboardGUI = caretakerDashboardGUI;
        this.registry = registry;

        caretakerDashboardGUI.getjButtonLogoutCaretakerDashboard().addActionListener(new LogoutButtonListener());
        caretakerDashboardGUI.getjButtonRegisterAnimalCaretakerDashboard().addActionListener(new RegisterAnimalButtonListener());
        caretakerDashboardGUI.getjButtonViewAllAnimalsCaretakerDashboard().addActionListener(new ViewAllAnimalsButtonListener());
        caretakerDashboardGUI.getjButtonViewAllBookedVisitsCaretakerDashboard().addActionListener(new ViewAllBookedVisitsButtonListener());
        caretakerDashboardGUI.getjButtonViewAllVideosCaretakerDashboard().addActionListener(new ViewAllVideosButtonListener());
    }

    class LogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginGUI loginGUI = new LoginGUI();
            LoginController loginController = new LoginController(loginGUI, registry);
            loginGUI.setVisible(true);
            loginGUI.setLocationRelativeTo(null);
            caretakerDashboardGUI.dispose();
        }
    }


    class RegisterAnimalButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerRegisterAnimalGUI caretakerRegisterAnimalGUI = new CaretakerRegisterAnimalGUI(
                    caretakerDashboardGUI.getCaretakerDTO());
            CaretakerRegisterAnimalController caretakerRegisterAnimalController = new CaretakerRegisterAnimalController(
                    caretakerRegisterAnimalGUI, registry);
            caretakerRegisterAnimalGUI.setVisible(true);
            caretakerRegisterAnimalGUI.setLocationRelativeTo(null);
            caretakerDashboardGUI.dispose();
        }
    }

    class ViewAllAnimalsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewAllAnimalsGUI employeeViewAllAnimalsGUI = new EmployeeViewAllAnimalsGUI(
                    caretakerDashboardGUI.getCaretakerDTO());
            EmployeeViewAllAnimalsController employeeViewAllAnimalsController = new EmployeeViewAllAnimalsController(
                    employeeViewAllAnimalsGUI, registry);
            employeeViewAllAnimalsGUI.setVisible(true);
            employeeViewAllAnimalsGUI.setLocationRelativeTo(null);
            caretakerDashboardGUI.dispose();
        }
    }

    class ViewAllBookedVisitsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewBookedVisitsGUI employeeViewBookedVisitsGUI = new EmployeeViewBookedVisitsGUI(
                    caretakerDashboardGUI.getCaretakerDTO());
            EmployeeViewBookedVisitsController employeeViewBookedVisitsController = new EmployeeViewBookedVisitsController(
                    employeeViewBookedVisitsGUI, registry);
            employeeViewBookedVisitsGUI.setVisible(true);
            employeeViewBookedVisitsGUI.setLocationRelativeTo(null);
            caretakerDashboardGUI.dispose();
        }
    }

    class ViewAllVideosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewAllVideosGUI employeeViewAllVideosGUI = new EmployeeViewAllVideosGUI(
                    caretakerDashboardGUI.getCaretakerDTO());
            EmployeeViewAllVideosController employeeViewAllVideosController = new EmployeeViewAllVideosController(
                    employeeViewAllVideosGUI, registry);
            employeeViewAllVideosGUI.setVisible(true);
            employeeViewAllVideosGUI.setLocationRelativeTo(null);
            caretakerDashboardGUI.dispose();
        }
    }

}
