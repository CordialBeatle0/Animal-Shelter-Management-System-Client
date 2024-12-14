package Controller;
import GUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import RMI.SubscriptionRMI;

public class UserDashboardController {
    private UserDashboardGUI gui;
    private Registry r;

    public UserDashboardController(UserDashboardGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;

        gui.getJButtonViewAnimals().addActionListener(new openViewAnimals());
        gui.getBookShelterVisitButton().addActionListener(new openBookShelterVisit());
        gui.getManageAccountButton().addActionListener(new openManageAccount());
        gui.getSubscribeToTrainingButton().addActionListener(new SubscribeToTraining());
        gui.getViewBookingsButton().addActionListener(new openViewBookings());
        gui.getViewShopButton().addActionListener(new openViewShop());
        gui.getViewTrainingVideoButton().addActionListener(new openViewTrainingVideo());
        gui.getjButtonUnSubscribeToTraining().addActionListener(new UnSubscribeToTraining());
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
                UserBookShelterVisitController bookShelterVisitController = new UserBookShelterVisitController(bookShelterVisitGUI, r);
                gui.dispose();
        }
    }

    class openManageAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                ManageAccountGUI manageAccountGUI = new ManageAccountGUI(gui.getUser());
                manageAccountGUI.setVisible(true);
                manageAccountGUI.setLocationRelativeTo(null);
                //call its controller
                gui.dispose();
        }
    }

    class SubscribeToTraining implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            UserPaymentGUI payGUI = new UserPaymentGUI(gui.getUser());
            payGUI.setVisible(true);
            payGUI.setLocationRelativeTo(null);
            UserPaymentController payController = new UserPaymentController(payGUI, r, true);
            gui.dispose();
        }
    }

    class UnSubscribeToTraining implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                SubscriptionRMI subscribeToTraining= (SubscriptionRMI) r.lookup("Subscription");
                subscribeToTraining.endSubscription(gui.getUser());
                JOptionPane.showMessageDialog(null, "You have unsubscribed from training successfully.");
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
            
        }
    }

    class openViewBookings implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            UserViewBookedVisitsGUI viewBookingsGUI = new UserViewBookedVisitsGUI(gui.getUser());
                viewBookingsGUI.setVisible(true);
                viewBookingsGUI.setLocationRelativeTo(null);
                UserViewBookedVisitsController viewBookingsController = new UserViewBookedVisitsController(viewBookingsGUI, r);
                gui.dispose();
        }
    }

    class openViewShop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //TODO: Patrick handle its controller cuz am confused
            UserViewShopGUI viewShopGUI = new UserViewShopGUI(gui.getUser());
                viewShopGUI.setVisible(true);
                viewShopGUI.setLocationRelativeTo(null);
                gui.dispose();
        }
    }

    class openViewTrainingVideo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
               UserViewAllVideosGUI viewTrainingVideoGUI = new UserViewAllVideosGUI(gui.getUser());
                viewTrainingVideoGUI.setVisible(true);
                viewTrainingVideoGUI.setLocationRelativeTo(null);
                UserViewAllVideosController viewTrainingVideoController = new UserViewAllVideosController(viewTrainingVideoGUI, r);
                gui.dispose();
        }
    }
}
