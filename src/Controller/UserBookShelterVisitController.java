package Controller;

import GUI.UserBookShelterVisitGUI;
import GUI.UserDashboardGUI;
import RMI.BookingDTO;
import RMI.BookingRMI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class UserBookShelterVisitController {
    private UserBookShelterVisitGUI gui;
    private Registry r;
    
    public UserBookShelterVisitController(UserBookShelterVisitGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        // Add action listeners
        this.gui.getjButtonBackBookVisit().addActionListener(new backButtonListener());
        this.gui.getjButtonConfirmBookingBookVisit().addActionListener(new confirmBookingListener());
    }
    
    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserDashboardGUI dashboardGUI = new UserDashboardGUI(gui.getUser());
            dashboardGUI.setVisible(true);
            dashboardGUI.setLocationRelativeTo(null);
            gui.dispose();
        }
    }
    
    class confirmBookingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BookingRMI bookingRMI = (BookingRMI) r.lookup("Booking");
                
                // Get the date components
                String day = gui.getjTextFieldDayBookVisit().getText();
                String month = gui.getjTextFieldMonthBookVisit().getText();
                String year = gui.getjTextFieldYearBookVisit().getText();
                String bookingDate = day + "/" + month + "/" + year;
                
                // Create booking
                BookingDTO booking = new BookingDTO(bookingDate, gui.getUser().getID());
                
                // Submit booking
                bookingRMI.createBooking(booking);

                //print a message to show success
                JOptionPane.showMessageDialog(gui,"Booking created successfully!");

                //clear the fields
                gui.getjTextFieldDayBookVisit().setText("");
                gui.getjTextFieldMonthBookVisit().setText("");
                gui.getjTextFieldYearBookVisit().setText("");
                
                //go to dashboard
                
            } catch (RemoteException ex) {
                System.out.println("Error creating booking: " + ex.getMessage());
            } catch (NotBoundException ex) {
                System.out.println("Error looking up Booking RMI: " + ex.getMessage());
            }
        }
    }
}