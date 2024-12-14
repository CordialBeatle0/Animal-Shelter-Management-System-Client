package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.DoctorDashboardGUI;
import GUI.LoginGUI;
import GUI.DoctorViewAllAppointmentsGUI;

public class DoctorDashboardController {
    Registry registry;
    DoctorDashboardGUI doctorDashboard;

    public DoctorDashboardController(DoctorDashboardGUI dashboard, Registry registry) {
        this.registry = registry;
        this.doctorDashboard = dashboard;

        // add event listeners
        doctorDashboard.getjButtonLogoutDoctroDashboard().addActionListener(new LogoutListener());
        doctorDashboard.getjButtonViewMyAppointmentsDoctorDashboard().addActionListener(new ViewAppointmentsListener());

    }

    class LogoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            LoginGUI login = new LoginGUI();
            LoginController loginController = new LoginController(login, registry);
            login.setVisible(true);
            doctorDashboard.dispose();

        }
    }

    class ViewAppointmentsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorViewAllAppointmentsGUI viewAppointments = new DoctorViewAllAppointmentsGUI(
                    doctorDashboard.getDoctor());
            DoctorViewAllAppointmentsController viewAppointmentsController = new DoctorViewAllAppointmentsController(
                    viewAppointments, registry);
            viewAppointments.setVisible(true);
            doctorDashboard.dispose();

        }
    }

}