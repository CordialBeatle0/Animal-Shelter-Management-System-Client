package Controller;

import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.rmi.RemoteException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.CaretakerDashboardGUI;
import GUI.EmployeeViewBookedVisitsGUI;
import RMI.BookingRMI;
import RMI.BookingDTO;
import RMI.CaretakerDTO;

public class EmployeeViewBookedVisitsController {
    EmployeeViewBookedVisitsGUI employeeViewBookedVisitsGUI;
    Registry registry;
    BookingRMI bookingRMI;
    JTable jTableBookedVisits;
    DefaultTableModel tableModel;

    public EmployeeViewBookedVisitsController(EmployeeViewBookedVisitsGUI employeeViewBookedVisitsGUI,
            Registry registry) {
        this.employeeViewBookedVisitsGUI = employeeViewBookedVisitsGUI;
        this.registry = registry;
        jTableBookedVisits = employeeViewBookedVisitsGUI.getjTableViewAllBookedVisitsViewBooked();
        tableModel = (DefaultTableModel) jTableBookedVisits.getModel();
        try {
            bookingRMI = (BookingRMI) registry.lookup("Booking");
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeViewBookedVisitsGUI.getjButtonBackViewBookedVisits().addActionListener(new BackViewBookedVisitsButtonListener());
    }

    private void loadTable() throws RemoteException {
        ArrayList<BookingDTO> bookings = bookingRMI.viewAllBookings();
        int columns;
        int rows = 0;
        tableModel.setRowCount(0);

        for (BookingDTO booking : bookings) {
            columns = 0;
            tableModel.addRow(new Object[0]);
            jTableBookedVisits.setValueAt(booking.getBookingID(), rows, columns++);
            jTableBookedVisits.setValueAt(booking.getBookingDate(), rows, columns++);
            jTableBookedVisits.setValueAt(booking.getVisitorID(), rows, columns++);
        }

    }

    class BackViewBookedVisitsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerDashboardGUI caretakerDashboardGUI = new CaretakerDashboardGUI(
                    employeeViewBookedVisitsGUI.getEmployeeDTO());
            CaretakerDashboardController caretakerDashboardController = new CaretakerDashboardController(
                    caretakerDashboardGUI, registry);
            caretakerDashboardGUI.setVisible(true);
            caretakerDashboardGUI.setLocationRelativeTo(null);
            employeeViewBookedVisitsGUI.dispose();

        }
    }

}
