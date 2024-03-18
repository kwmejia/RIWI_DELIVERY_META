import controller.AuthController;
import controller.OrderController;
import entity.Account;
import entity.Client;
import entity.DeliveryMan;
import entity.Role;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        AuthController objAuthController = new AuthController();
        OrderController objOrderController = new OrderController();
        Client userClient;
        DeliveryMan userDelivery;
        Role roleAuthenticated;


        String option;
        int option2 = 0,option3 =0;
        do {

            try {
                option = JOptionPane.showInputDialog(null, """
                        PRINCIPAL MENU
                            1. Login
                            2. Sign up
                            3. Exit
                        """);

                if (option == null) break;


                option2 = Integer.parseInt(option);


                switch (option2) {
                    case 1:
                        int type = objAuthController.typeUser();
                        if (type == 1) {
                            userClient = objAuthController.logInClient();
                            if (userClient == null) break ;
                            roleAuthenticated = Role.CLIENT;

                            do {

                                String op = JOptionPane.showInputDialog("""
                                           MENU CLIENTS
                                           1. Add Order
                                           2. List Orders
                                           3. Exit
                                       
                                        """);

                                if (op == null) break;
                                option3= Integer.parseInt(op);

                                switch (option3){
                                    case 1: //Add Order
                                        objOrderController.createOrder(userClient);
                                        break;

                                    case 2: //List order
                                        objOrderController.listOrdersByClient(userClient);
                                        break;
                                }

                            }while (option3 !=3);
                        } else if (type == 2) {
                            userDelivery = objAuthController.logInDelivery();
                            if (userDelivery != null) roleAuthenticated = Role.DELIVERY_MAN;

                        } else {
                            JOptionPane.showMessageDialog(null, "Option not valid");
                        }
                        break;
                    case 2:
                        objAuthController.accountRegister();

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