import controller.AuthController;
import entity.Account;
import entity.Client;
import entity.DeliveryMan;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        AuthController objAuthController = new AuthController();
        Client userClient;
        DeliveryMan userDelivery;


        String option;
        int option2 = 0;
        do {

            try {
                option = JOptionPane.showInputDialog(null, """
                        PRINCIPAL MENU
                            1. Login
                            2. Sign up
                            3. Exit
                        """);

                if (option == null) {

                    break;
                } else {

                    option2 = Integer.parseInt(option);
                }

                switch (option2) {
                    case 1:
                        int type = objAuthController.typeUser();
                        if (type == 1) {
                            userClient = objAuthController.logInClient();
                        } else if (type == 2) {
                            userDelivery = objAuthController.logInDelivery();
                        } else {
                            JOptionPane.showMessageDialog(null, "Option not valid");
                        }
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"Sign up");
                        AuthController authController = new AuthController();
                        authController.accountRegister();

                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "leaving");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid option");
            }
        } while (option2 != 3);
    }
}