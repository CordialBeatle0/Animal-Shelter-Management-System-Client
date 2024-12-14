package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.CourierDashboardGUI;
import GUI.LoginGUI;
import GUI.CourierViewRequestsGUI;
import RMI.CourierDTO;
import RMI.RequestRMI;

public class CourierDashboardController {
    CourierDashboardGUI courierDashboard;
    Registry registry;

    public CourierDashboardController(CourierDashboardGUI courierDashboard, Registry registry) {
        this.courierDashboard = courierDashboard;
        this.registry = registry;

        this.courierDashboard.getjButtonLogoutCourierDashboard().addActionListener(new LogoutListener());
        this.courierDashboard.getjButtonViewRequestsCourierDashboard().addActionListener(new ViewRequestListener());
    }

    class LogoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginGUI login = new LoginGUI();
            LoginController loginController = new LoginController(login, registry);
            login.setVisible(true);
            courierDashboard.dispose();
        }
    }

    class ViewRequestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CourierDTO courier = null;
            try {
                RequestRMI requestRMI = (RequestRMI) registry.lookup("Request");
                courier = requestRMI.getAssignedCourier(courierDashboard.getCourier().getID());
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(CourierDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            CourierViewRequestsGUI viewRequests = new CourierViewRequestsGUI(courier);
            CourierViewRequestController viewRequestController = new CourierViewRequestController(viewRequests,
                    registry);
            viewRequests.setVisible(true);
            courierDashboard.dispose();
        }
    }

}
