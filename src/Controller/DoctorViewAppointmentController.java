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
        doctorAppointmentGUI.getjTextFieldDoctorNameViewAppointment().addActionListener(new DoctorNameListener());
        doctorAppointmentGUI.getjButtonBackViewAppointment().addActionListener(new BackListener());

    }

    class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                appointmentRMI.cancelAppointment();
                loadTable();
            } catch (RemoteException ex) {
                Logger.getLogger(DoctorViewAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class RecordDescriptionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            DoctorRecordAppointmemtDescriptionGUI doctorRecordAppointmemtDescriptionGUI = new DoctorRecordAppointmemtDescriptionGUI();
            DoctorRecordAppointmemtDescriptionController doctorRecordAppointmemtDescriptionController = new DoctorRecordAppointmemtDescriptionController(
                    doctorRecordAppointmemtDescriptionGUI, registry);
            doctorRecordAppointmemtDescriptionGUI.setVisible(true);
            doctorAppointmentGUI.setVisible(false);
        }
    }

    class DoctorNameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String docName = doctorAppointmentGUI.getDoctor().getName();
            doctorAppointmentGUI.getjTextFieldDoctorNameViewAppointment().setEditable(true);
            doctorAppointmentGUI.getjTextFieldDoctorNameViewAppointment().setText(docName);
            doctorAppointmentGUI.getjTextFieldDoctorNameViewAppointment().setEditable(false);
        }
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorDashboardGUI doctorDashboardGUI = new DoctorDashboardGUI(doctorAppointmentGUI.getDoctor());
            doctorDashboardGUI.setVisible(true);
            doctorAppointmentGUI.setVisible(false);
        }
    }

    private void loadTable() throws RemoteException {
        AppointmentDTO appointment = appointmentRMI.viewAppointment();

        int columns = 0;
        int rows = 0;

        tableModel.setRowCount(0);
        tableModel.addRow(new Object[] {});
        jTableAppointmentDetailsViewAppointment.setValueAt(appointment.getID(), rows, columns++);
        jTableAppointmentDetailsViewAppointment.setValueAt(appointment.getDate(), rows, columns++);
        jTableAppointmentDetailsViewAppointment.setValueAt(appointment.getPrice(), rows, columns++);
        jTableAppointmentDetailsViewAppointment.setValueAt(appointment.getAnimalName(), rows, columns++);
        jTableAppointmentDetailsViewAppointment.setValueAt(appointment.getAnimalType(), rows, columns++);
        jTableAppointmentDetailsViewAppointment.setValueAt(appointment.getDescription(), rows, columns);
    }

};
