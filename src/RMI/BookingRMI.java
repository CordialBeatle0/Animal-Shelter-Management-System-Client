package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BookingRMI extends Remote {
    public void createBooking(BookingDTO booking) throws RemoteException;
    
    public void cancelBooking(int bookingID) throws RemoteException;
    
    public BookingDTO viewBooking(int bookingID) throws RemoteException;
    
    public ArrayList<BookingDTO> viewAllBookings() throws RemoteException;
    
}