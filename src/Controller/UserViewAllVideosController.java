package Controller;

import GUI.UserDashboardGUI;
import GUI.UserViewAllVideosGUI;
import RMI.TrainingDTO;
import RMI.TrainingRMI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserViewAllVideosController {
    private UserViewAllVideosGUI gui;
    private Registry r;
    
    public UserViewAllVideosController(UserViewAllVideosGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        this.gui.getjButtonBackViewAllVideos().addActionListener(new BackButtonAction());
        
        loadVideos();
    }
    
    private void loadVideos() {
        try {
            TrainingRMI trainingRMI = (TrainingRMI) r.lookup("Training");
            ArrayList<TrainingDTO> videos = trainingRMI.viewAllTrainingVideos();
            
            DefaultTableModel model = (DefaultTableModel) gui.getjTableTrainingVideoViewAllVideos().getModel();
            model.setRowCount(0);
            
            for (TrainingDTO video : videos) {
                model.addRow(new Object[]{
                    video.getID(),
                    video.getDescription(),
                    video.getRuntime() + " mins"
                });
            }
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(gui,
                "Error loading training videos: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private class BackButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            UserDashboardGUI dashboardGUI = new UserDashboardGUI(gui.getUserDTO());
            dashboardGUI.setLocationRelativeTo(null);
            dashboardGUI.setVisible(true);
            UserDashboardController dashboardController = new UserDashboardController(dashboardGUI, r);
            gui.dispose();
        }
    }
}