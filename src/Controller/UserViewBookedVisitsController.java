package Controller;

import GUI.UserDashboardGUI;
import GUI.UserViewBookedVisitsGUI;
import RMI.BookingDTO;
import RMI.BookingRMI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserViewBookedVisitsController {
    private UserViewBookedVisitsGUI gui;
    private Registry r;
    
    public UserViewBookedVisitsController(UserViewBookedVisitsGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        // Add action listeners
        this.gui.getjButtonBackUserBookedVisits().addActionListener(new BackButtonAction());
        this.gui.getjButtonCancelBookingUserBooking().addActionListener(new CancelBookingAction());
        
        loadBookings();
    }
    
    private void loadBookings() {
        try {
            BookingRMI bookingRMI = (BookingRMI) r.lookup("Booking");
            ArrayList<BookingDTO> bookings = bookingRMI.viewAllBookings();
            
            DefaultTableModel model = (DefaultTableModel) gui.getjTableUserBookedVisits().getModel();
            model.setRowCount(0);

            for (BookingDTO booking : bookings) {
                if (booking.getVisitorID() == gui.getUser().getID()) {
                    model.addRow(new Object[]{
                        booking.getBookingID(),
                        booking.getBookingDate()
                    });
                }
            }
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(gui, 
                "Error loading bookings: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private class BackButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            UserDashboardGUI dashboardGUI = new UserDashboardGUI(gui.getUser());
            dashboardGUI.setLocationRelativeTo(null);
            dashboardGUI.setVisible(true);
            UserDashboardController dashboardController = new UserDashboardController(dashboardGUI, r);
            gui.dispose();
        }
    }
    
    private class CancelBookingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int selectedRow = gui.getjTableUserBookedVisits().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(gui,
                    "Please select a booking to cancel",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            try {
                int bookingID = (int) gui.getjTableUserBookedVisits().getValueAt(selectedRow, 0);
                
                    BookingRMI bookingRMI = (BookingRMI) r.lookup("Booking");
                    bookingRMI.cancelBooking(bookingID);
                    
                    JOptionPane.showMessageDialog(gui,
                        "Booking cancelled successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                    
                    // Reload the bookings table
                    loadBookings();
                
            } catch (RemoteException | NotBoundException ex) {
                JOptionPane.showMessageDialog(gui,
                    "Error cancelling booking: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}