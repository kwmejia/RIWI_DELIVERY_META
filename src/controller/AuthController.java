package controller;

import entity.Role;
import entity.Account;
import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {

    // Variable definition
    ArrayList<Account> accountList = new ArrayList<>();
    String userName;
    String password;

    String selectedOption;

    Role role;

    // create method that register the user
    public void accountRegister() {


        boolean flag1;
        String regex = "^(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";

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
                    """);

            // Password validation with a method (regex)
            passwordFlag = validatePassword(password, regex);
            if (!passwordFlag) {
                JOptionPane.showMessageDialog(null, "The password requires: at least 4 characters, 1 uppercase letter, 1 special character. Please try again.");
            }

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
        } while (!passwordFlag);

    }

    // method regex() to validate password requirements
    private boolean validatePassword(String password, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
