import controller.AuthController;
import entity.Account;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        AuthController objAuthController = new AuthController();
        Account userAccount;

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
                        userAccount = objAuthController.logIn();
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Sign up");
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