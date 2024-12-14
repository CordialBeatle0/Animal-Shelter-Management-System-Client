package Controller;

import GUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import RMI.SubscriptionRMI;
import RMI.UserRMI;

public class UserDashboardController {
    private UserDashboardGUI gui;
    private Registry r;
    private ArrayList<String> notifications;
    UserRMI userRMI;

    public UserDashboardController(UserDashboardGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        try {
            userRMI = (UserRMI) r.lookup("User");
            loadNotifications();
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }

        gui.getJButtonViewAnimals().addActionListener(new openViewAnimals());
        gui.getBookShelterVisitButton().addActionListener(new openBookShelterVisit());
        gui.getSubscribeToTrainingButton().addActionListener(new SubscribeToTraining());
        gui.getViewBookingsButton().addActionListener(new openViewBookings());
        gui.getViewShopButton().addActionListener(new openViewShop());
        gui.getViewTrainingVideoButton().addActionListener(new openViewTrainingVideo());
        gui.getjButtonUnSubscribeToTraining().addActionListener(new UnSubscribeToTraining());
        gui.getjButtonLogOut().addActionListener(new logoutButton());
        gui.getjButtonViewNextNotification().addActionListener(new viewNotifications());
        
    }

    class openViewAnimals implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            UserViewAllAnimalsGUI viewAnimalsGUI = new UserViewAllAnimalsGUI(gui.getUser());
            viewAnimalsGUI.setVisible(true);
            viewAnimalsGUI.setLocationRelativeTo(null);
            UserViewAllAnimalsController viewAnimalsController = new UserViewAllAnimalsController(viewAnimalsGUI, r);
            gui.dispose();
        }
    }

    class openBookShelterVisit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            UserBookShelterVisitGUI bookShelterVisitGUI = new UserBookShelterVisitGUI(gui.getUser());
            bookShelterVisitGUI.setVisible(true);
            bookShelterVisitGUI.setLocationRelativeTo(null);
            UserBookShelterVisitController bookShelterVisitController = new UserBookShelterVisitController(
                    bookShelterVisitGUI, r);
            gui.dispose();
        }
    }

    class openManageAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            ManageAccountGUI manageAccountGUI = new ManageAccountGUI(gui.getUser());
            manageAccountGUI.setVisible(true);
            manageAccountGUI.setLocationRelativeTo(null);
            // call its controller
            ManagAccountController manageAccountController = new ManagAccountController(manageAccountGUI, r);
            gui.dispose();
        }
    }

    class SubscribeToTraining implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if (gui.getUser().isSubscribed() == true) {
                JOptionPane.showMessageDialog(null, "You are already subscribed to training.");
                return;
            }
            else {
                
                UserPaymentGUI payGUI = new UserPaymentGUI(gui.getUser());
                UserPaymentController payController = new UserPaymentController(payGUI, r, true);
                payGUI.setVisible(true);
                payGUI.setLocationRelativeTo(null);
                gui.dispose();
            }
            
            
        }
    }

    class UnSubscribeToTraining implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                if (gui.getUser().isSubscribed() == false) {
                    JOptionPane.showMessageDialog(null, "You are not subscribed to training.");
                    return;
                }
                else {
                    SubscriptionRMI subscribeToTraining = (SubscriptionRMI) r.lookup("Subscription");
                    subscribeToTraining.endSubscription(gui.getUser());
                    gui.getUser().setSubscribed(false);
                    JOptionPane.showMessageDialog(null, "You have unsubscribed from training successfully.");
                    
                }


            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }

        }
    }

    class openViewBookings implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            UserViewBookedVisitsGUI viewBookingsGUI = new UserViewBookedVisitsGUI(gui.getUser());
            UserViewBookedVisitsController viewBookingsController = new UserViewBookedVisitsController(viewBookingsGUI, r);
            viewBookingsGUI.setVisible(true);
            viewBookingsGUI.setLocationRelativeTo(null);
            gui.dispose();
        }
    }

    class openViewShop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // TODO: Patrick handle its controller cuz am confused
            UserViewShopGUI viewShopGUI = new UserViewShopGUI(gui.getUser());
            viewShopGUI.setVisible(true);
            UserViewShopController viewShopController = new UserViewShopController(viewShopGUI, r);
            viewShopGUI.setLocationRelativeTo(null);
            gui.dispose();
        }
    }

    class openViewTrainingVideo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if (gui.getUser().isSubscribed() == false) {
                JOptionPane.showMessageDialog(null, "You need to subscribe to training to view training videos.");
                return;
            }
            else {
            
                UserViewAllVideosGUI viewTrainingVideoGUI = new UserViewAllVideosGUI(gui.getUser());
                viewTrainingVideoGUI.setVisible(true);
                viewTrainingVideoGUI.setLocationRelativeTo(null);
                UserViewAllVideosController viewTrainingVideoController = new UserViewAllVideosController(
                        viewTrainingVideoGUI, r);
                gui.dispose();

           }
            
        }
    }

    class logoutButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            LoginGUI loginGUI = new LoginGUI();
            LoginController loginController = new LoginController(loginGUI, r);
            loginGUI.setVisible(true);
            loginGUI.setLocationRelativeTo(null);
            gui.dispose();
        }
    }
    
    class viewNotifications implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (notifications.isEmpty()) {
                JOptionPane.showMessageDialog(gui, "You have no notifications.");
                return;
            }
            JOptionPane.showMessageDialog(gui, notifications.get(0));
            
            try {
                userRMI.removeNotification(gui.getUser());
                notifications.remove(0);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    private void loadNotifications() throws RemoteException {
        notifications = userRMI.getNotifications(gui.getUser());
    }
}
