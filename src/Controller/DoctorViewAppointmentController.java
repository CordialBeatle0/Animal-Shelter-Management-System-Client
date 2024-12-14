package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.DoctorViewAppointmentGUI;
import GUI.DoctorRecordAppointmemtDescriptionGUI;
import GUI.DoctorDashboardGUI;
import java.rmi.registry.Registry;
import RMI.AppointmentRMI;
import RMI.AppointmentDTO;

public class DoctorViewAppointmentController {
    DoctorViewAppointmentGUI doctorAppointmentGUI;
    Registry registry;
    JTable jTableAppointmentDetailsViewAppointment;
    DefaultTableModel tableModel;
    AppointmentRMI appointmentRMI;

    public DoctorViewAppointmentController(DoctorViewAppointmentGUI doctorAppointmentGUI, Registry registry) {
        this.doctorAppointmentGUI = doctorAppointmentGUI;
        this.registry = registry;
        jTableAppointmentDetailsViewAppointment = doctorAppointmentGUI.getjTableAppointmentDetailsViewAppointment();
        tableModel = (DefaultTableModel) jTableAppointmentDetailsViewAppointment.getModel();
        doctorAppointmentGUI.getjTextFieldDoctorNameViewAppointment().setText(doctorAppointmentGUI.getDoctor().getName());
        try {
            appointmentRMI = (AppointmentRMI) registry.lookup("Appointment");
            loadTable();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(DoctorViewAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // add event listener
        doctorAppointmentGUI.getjButtonCancelAppointment().addActionListener(new CancelListener());
        doctorAppointmentGUI.getjButtonRecordDescriptionViewAppointment()
                .addActionListener(new RecordDescriptionListener());
        doctorAppointmentGUI.getjButtonBackViewAppointment().addActionListener(new BackListener());

    }

    class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                appointmentRMI.cancelAppointment(doctorAppointmentGUI.getAppointment().getID());
                DoctorDashboardGUI doctorDashboardGUI = new DoctorDashboardGUI(doctorAppointmentGUI.getDoctor());
                DoctorDashboardController doctorDashboardController = new DoctorDashboardController(doctorDashboardGUI,
                        registry);
                doctorDashboardGUI.setVisible(true);
                doctorAppointmentGUI.dispose();
            } catch (RemoteException ex) {
                Logger.getLogger(DoctorViewAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class RecordDescriptionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            DoctorRecordAppointmemtDescriptionGUI doctorRecordAppointmemtDescriptionGUI =
                    new DoctorRecordAppointmemtDescriptionGUI(doctorAppointmentGUI.getDoctor(), doctorAppointmentGUI.getAppointment());
            doctorRecordAppointmemtDescriptionGUI.setVisible(true);
            DoctorRecordAppointmemtDescriptionController doctorRecordAppointmemtDescriptionController = new DoctorRecordAppointmemtDescriptionController(
                    doctorRecordAppointmemtDescriptionGUI, registry);
            doctorAppointmentGUI.dispose();
        }
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorDashboardGUI doctorDashboardGUI = new DoctorDashboardGUI(doctorAppointmentGUI.getDoctor());
            DoctorDashboardController doctorDashboardController = new DoctorDashboardController(doctorDashboardGUI,
                    registry);
            doctorDashboardGUI.setVisible(true);
            doctorAppointmentGUI.dispose();
        }
    }

    private void loadTable() throws RemoteException {
        AppointmentDTO appointment = appointmentRMI.viewAppointment(doctorAppointmentGUI.getAppointment().getID());

        int columns = 0;

        tableModel.setRowCount(0);
        tableModel.addRow(new Object[] {});
        tableModel.setValueAt(appointment.getID(), 0, columns++);
        tableModel.setValueAt(appointment.getDate(), 0, columns++);
        tableModel.setValueAt(appointment.getPrice(), 0, columns++);
        tableModel.setValueAt(appointment.getAnimalName(), 0, columns++);
        tableModel.setValueAt(appointment.getAnimalType(), 0, columns++);
        tableModel.setValueAt(appointment.getDescription(), 0, columns);
    }
}
