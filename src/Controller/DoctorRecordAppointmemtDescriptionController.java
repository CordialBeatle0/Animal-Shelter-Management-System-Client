package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.Doc;

import GUI.DoctorRecordAppointmemtDescriptionGUI;
import RMI.AppointmentDTO;
import RMI.AppointmentRMI;
import GUI.DoctorViewAppointmentGUI;

public class DoctorRecordAppointmemtDescriptionController {
    DoctorRecordAppointmemtDescriptionGUI doctorRecordAppointmemtDescriptionGUI1;
    Registry registry;
    AppointmentRMI appointmentRMI;

    public DoctorRecordAppointmemtDescriptionController(
            DoctorRecordAppointmemtDescriptionGUI doctorRecordAppointmemtDescriptionGUI, Registry registry) {
        this.doctorRecordAppointmemtDescriptionGUI1 = doctorRecordAppointmemtDescriptionGUI;
        this.registry = registry;
        try {
            appointmentRMI = (AppointmentRMI) registry.lookup("Appointment");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(DoctorRecordAppointmemtDescriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        doctorRecordAppointmemtDescriptionGUI.getjButtonBackAppointmentDescription()
                .addActionListener(new BackListener());
        doctorRecordAppointmemtDescriptionGUI.getjButtonSaveAppointmentDetails().addActionListener(new SaveListener());

    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorViewAppointmentGUI doctorViewAppointmentGUI = new DoctorViewAppointmentGUI(
                    doctorRecordAppointmemtDescriptionGUI1.getDoctor(),
                    doctorRecordAppointmemtDescriptionGUI1.getAppointment());
            doctorViewAppointmentGUI.setVisible(true);
            doctorRecordAppointmemtDescriptionGUI1.setVisible(false);
            new DoctorViewAppointmentController(
                    new DoctorViewAppointmentGUI(doctorRecordAppointmemtDescriptionGUI1.getDoctor(),
                            doctorRecordAppointmemtDescriptionGUI1.getAppointment()),
                    registry);
        }
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int appointmentID = doctorRecordAppointmemtDescriptionGUI1.getAppointment().getID();
                String description = doctorRecordAppointmemtDescriptionGUI1
                        .getjTextAreaDescriptionAppointmentDescription()
                        .getText();

                appointmentRMI.recordAppointmentDetail(appointmentID, description);

                DoctorViewAppointmentGUI doctorViewAppointmentGUI = new DoctorViewAppointmentGUI(
                        doctorRecordAppointmemtDescriptionGUI1.getDoctor(),
                        doctorRecordAppointmemtDescriptionGUI1.getAppointment());

                doctorViewAppointmentGUI.setVisible(true);
                doctorRecordAppointmemtDescriptionGUI1.setVisible(false);
                new DoctorViewAppointmentController(
                        new DoctorViewAppointmentGUI(doctorRecordAppointmemtDescriptionGUI1.getDoctor(),
                                doctorRecordAppointmemtDescriptionGUI1.getAppointment()),
                        registry);
            } catch (RemoteException ex) {
                Logger.getLogger(DoctorRecordAppointmemtDescriptionController.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
        }
    }
}
