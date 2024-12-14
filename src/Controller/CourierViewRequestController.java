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

import GUI.CourierDashboardGUI;
import GUI.CourierViewRequestsGUI;
import RMI.AppointmentDTO;
import RMI.CourierDTO;
import RMI.RequestDTO;
import RMI.RequestRMI;

public class CourierViewRequestController {
    CourierViewRequestsGUI viewRequestsGUI;
    Registry registry;
    JTable jTableRequestsViewCourierRequests;
    DefaultTableModel tableModel;
    RequestRMI requestRMI;

    public CourierViewRequestController(CourierViewRequestsGUI viewRequests, Registry registry) {
        this.viewRequestsGUI = viewRequests;
        this.registry = registry;
        jTableRequestsViewCourierRequests = viewRequestsGUI.getjTableViewRequestsCourierRequests();
        tableModel = (DefaultTableModel) jTableRequestsViewCourierRequests.getModel();

        try {
            requestRMI = (RequestRMI) registry.lookup("Request");
            loadTable();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(CourierViewRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // add event listener
        viewRequestsGUI.getjButtonBackViewRequestsCourierRequests().addActionListener(new BackListener());
        viewRequestsGUI.getjButtonFinishRequestViewRequestsCourierRequests()
                .addActionListener(new FinishRequestListener());
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CourierDashboardGUI courierDashboard = new CourierDashboardGUI(viewRequestsGUI.getCourier());
            CourierDashboardController courierDashboardController = new CourierDashboardController(courierDashboard,
                    registry);
            courierDashboard.setVisible(true);
            viewRequestsGUI.dispose();
        }
    }

    class FinishRequestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = jTableRequestsViewCourierRequests.getSelectedRow();
            if (selectedRow == -1) {
                return;
            }

            int requestID = (int) tableModel.getValueAt(selectedRow, 0);

            try {
                RequestDTO request = requestRMI.getRequestByID(requestID);
                requestRMI.deleteRequest(request);
                loadTable();
            } catch (RemoteException ex) {
                Logger.getLogger(CourierViewRequestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadTable() throws RemoteException {
        ArrayList<RequestDTO> requests = requestRMI.viewRequest(viewRequestsGUI.getCourier());

        int columns;
        int rows = 0;

        tableModel.setRowCount(0);

        for (RequestDTO request : requests) {
            columns = 0;
            tableModel.addRow(new Object[] {});
            jTableRequestsViewCourierRequests.setValueAt(request.getID(), rows, columns++);
            jTableRequestsViewCourierRequests.setValueAt(request.getUserName(), rows, columns++);
            jTableRequestsViewCourierRequests.setValueAt(request.getLocation(), rows, columns++);
            jTableRequestsViewCourierRequests.setValueAt(request.getDate(), rows, columns);
            rows++;
        }
    }

}
