package Controller;

import javax.print.Doc;
import javax.swing.table.DefaultTableModel;

import Controller.DoctorViewAppointmentController.CancelListener;
import Controller.DoctorViewAppointmentController.DoctorNameListener;
import Controller.DoctorViewAppointmentController.RecordDescriptionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.DoctorViewAllAppointmentsGUI;
import GUI.DoctorViewAppointmentGUI;
import GUI.DoctorDashboardGUI;
import RMI.AppointmentDTO;
import RMI.AppointmentRMI;
import RMI.DoctorRMI;
import RMI.UtilityItemDTO;

public class DoctorViewAllAppointmentsController {

    DoctorViewAllAppointmentsGUI doctorViewAllAppointmentsGUI;
    Registry registry;
    DoctorRMI doctorRMI;
    AppointmentRMI appointmentRMI;
    JTable jTableAppointmentDetailsViewAppointment;
    DefaultTableModel tableModel;

    public DoctorViewAllAppointmentsController(DoctorViewAllAppointmentsGUI doctorViewAllAppointmentsGUI,
            Registry registry) {
        this.doctorViewAllAppointmentsGUI = doctorViewAllAppointmentsGUI;
        this.registry = registry;
        jTableAppointmentDetailsViewAppointment = doctorViewAllAppointmentsGUI
                .getjTableViewAllAppointmentsDoctorAppointments();
        tableModel = (DefaultTableModel) jTableAppointmentDetailsViewAppointment.getModel();
        try {
            doctorRMI = (DoctorRMI) registry.lookup("Doctor");
            loadTable();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(DoctorViewAllAppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // add event listener
        doctorViewAllAppointmentsGUI.getjButtonBackViewAllDoctorAppointments().addActionListener(new BackListener());
        doctorViewAllAppointmentsGUI.getjButtonViewAppointmentDoctorAppointments()
                .addActionListener(new RecordDescriptionListener());

    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorDashboardGUI doctorDashboardGUI = new DoctorDashboardGUI(doctorViewAllAppointmentsGUI.getDoctor());
            doctorDashboardGUI.setVisible(true);
            doctorViewAllAppointmentsGUI.setVisible(false);
            new DoctorDashboardController(new DoctorDashboardGUI(doctorViewAllAppointmentsGUI.getDoctor()), registry);
        }
    }

    class RecordDescriptionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = jTableAppointmentDetailsViewAppointment.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(doctorViewAllAppointmentsGUI, "Please select an appointment to view",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int appointmentID = (int) jTableAppointmentDetailsViewAppointment.getValueAt(selectedRow, 0);
            try {
                AppointmentDTO appointment = appointmentRMI.getAppointment(appointmentID);

                DoctorViewAppointmentGUI doctorViewAppointmentGUI = new DoctorViewAppointmentGUI(
                        doctorViewAllAppointmentsGUI.getDoctor(), appointment);
                doctorViewAppointmentGUI.setVisible(true);
                new DoctorViewAppointmentController(
                        new DoctorViewAppointmentGUI(doctorViewAllAppointmentsGUI.getDoctor(), appointment),
                        registry);
                doctorViewAllAppointmentsGUI.setVisible(false);
            } catch (RemoteException ex) {
                Logger.getLogger(DoctorViewAllAppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void loadTable() throws RemoteException {
        ArrayList<AppointmentDTO> appointment = doctorRMI.viewDoctorAppointments();

        int columns;
        int rows = 0;

        tableModel.setRowCount(0);

        for (AppointmentDTO appointmentDTO : appointment) {
            columns = 0;
            tableModel.addRow(new Object[] {});
            jTableAppointmentDetailsViewAppointment.setValueAt(appointmentDTO.getID(), rows, columns++);
            jTableAppointmentDetailsViewAppointment.setValueAt(appointmentDTO.getDate(), rows, columns++);
            jTableAppointmentDetailsViewAppointment.setValueAt(appointmentDTO.getPrice(), rows, columns++);
            jTableAppointmentDetailsViewAppointment.setValueAt(appointmentDTO.getAnimalName(), rows, columns++);
            jTableAppointmentDetailsViewAppointment.setValueAt(appointmentDTO.getAnimalType(), rows, columns++);
            jTableAppointmentDetailsViewAppointment.setValueAt(appointmentDTO.getDescription(), rows, columns);
            rows++;
        }
    }

}
