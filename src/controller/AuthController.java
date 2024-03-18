package controller;

import entity.Client;
import entity.DeliveryMan;
import entity.Role;
import entity.Account;


import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import java.util.ArrayList;

public class AuthController {

    // Variable definition
    static ArrayList<Account> accountList = new ArrayList<>();

    //creating two temporary arraylist to implement customer login and delivery login
    ArrayList<Client> clientList = new ArrayList<>();
    ArrayList<DeliveryMan> deliveryList = new ArrayList<>();

    String userName;
    String password;

    String selectedOption;

    Role role;
    static int idCreate = 0;

    // create method that register the user
    public void accountRegister() {

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{4,}$";

        boolean flag1;

        // name validation
        do {
            flag1 = false;
            userName = JOptionPane.showInputDialog("Insert your User Name");
            for (Account accAux : accountList) {
                if (accAux.getUserName().equalsIgnoreCase(userName)) {
                    flag1 = true;
                    JOptionPane.showMessageDialog(null, "This username is already taken, try with another one");
                    break;
                }
            }
        } while (flag1);

        // Password creation
        boolean passwordFlag;
        do {
            password = JOptionPane.showInputDialog(null, """
                    Insert your password. This password requires:
                     - At least 4 characters
                     - 1 uppercase letter
                     - 1 special character
                     - 1 number
                    """);

            // Password validation with a method (regex)
            passwordFlag = validatePassword(password, regex);
            if (!passwordFlag) {
                JOptionPane.showMessageDialog(null, "The password requires: at least 4 characters, 1 uppercase letter, 1 special character and 1 number. Please try again.");
            }
        } while (!passwordFlag);

            // Role selection and validation
            do {
                String[] options = {"Client", "Delivery man"};

                selectedOption = (String) JOptionPane.showInputDialog(
                        null,
                        "Select a role:\n",
                        "Choosing role",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (selectedOption != null) {
                    JOptionPane.showMessageDialog(null, "Selected option: " + selectedOption);
                    if (selectedOption.equals("Client")) {
                        role = Role.CLIENT;

                        User user = createUser(userName, password, role);
                        Client client = createClient(user);
                        this.clientList.add(client);
                    } else {
                        role = Role.DELIVERY_MAN;
                        User user = createUser(userName, password, role);
                        DeliveryMan deliveryMan = createDeliveryMan(user);
                        this.deliveryList.add(deliveryMan);
                    }
                } else {
                    role = Role.DELIVERY_MAN;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No option was selected, try again (required)");
            }
        } while (selectedOption == null);

        // user instance and added to the account list
        Account user = new Account(userName, password, role);
        accountList.add(user);
    }


    public User createUser(String userName, String password, Role role) {
        String name = JOptionPane.showInputDialog("Add your Name");
        String phone = JOptionPane.showInputDialog("Add your Phone number: ");

        User objUser = new User(userName, password, role, name, phone, 0, idCreate);
        idCreate++;
        return objUser;
    }

    public Client createClient(User user){
        String address = JOptionPane.showInputDialog("Add your name vehicle: ");

        return new Client(user.getUserName(), user.getPassword(), user.getRole(), user.getName(), user.getPhone(), user.getRating(), user.getId(), address);
    }

    public DeliveryMan createDeliveryMan(User user){
        String vehicle = JOptionPane.showInputDialog("Add your name vehicle: ");
        String plate = JOptionPane.showInputDialog("Add your plate: ");
        String document = JOptionPane.showInputDialog("Add your plate: ");
        return new DeliveryMan(user.getUserName(), user.getPassword(), user.getRole(), user.getName(), user.getPhone(), user.getRating(), user.getId(), vehicle,plate,document, true);
    }


    // method regex() to validate password requirements
    private boolean validatePassword(String password, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public Client logInClient() {
        String userName = JOptionPane.showInputDialog("Your User Name: ");
        String password = JOptionPane.showInputDialog("Your Password: ");

        Client objAccount = null;
        String message = "";

        for (Client validation : this.clientList) {
            if (validation.getUserName().equalsIgnoreCase(userName)) {
                if (validation.getPassword().equalsIgnoreCase(password)) {
                    objAccount = validation;
                    message = "Login Successfully";
                } else {
                    message = "Invalid Password";
                }
                break;
            } else {
                message = "User not found";
            }
        }
        JOptionPane.showMessageDialog(null, message);
        return objAccount;
    }

    public DeliveryMan logInDelivery() {
        String userName = JOptionPane.showInputDialog("Your User Name: ");
        String password = JOptionPane.showInputDialog("Your Password: ");

        DeliveryMan objAccount = null;
        String message = "";

        for (DeliveryMan validation : this.deliveryList) {
            if (validation.getUserName().equalsIgnoreCase(userName)) {
                if (validation.getPassword().equalsIgnoreCase(password)) {
                    objAccount = validation;
                    message = "Login Successfully";
                } else {
                    message = "Invalid Password";
                }
                break;
            } else {
                message = "User not found";
            }
        }
        JOptionPane.showMessageDialog(null, message);
        return objAccount;
    }

    public int typeUser() {
        int type = 0;
        try {
            type = Integer.parseInt(JOptionPane.showInputDialog("""
                    Choose an user type:
                    1. Client
                    2. Delivery
                    """));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Option Invalidate");
        }
        return type;
    }
}
