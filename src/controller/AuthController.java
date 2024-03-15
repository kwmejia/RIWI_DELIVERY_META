package controller;

import entity.Account;
import entity.Role;

import javax.swing.*;
import java.util.ArrayList;

public class AuthController {

    //arrayList creado para el metodo log in debe Ser elimada despues de que se suba el register;
    private ArrayList<Account> accountList;

    public void logOut(Account loggedAccount) {

        loggedAccount.setPassword("");
        loggedAccount.setUserName("");
        loggedAccount.setRole(Role.NULL);
    }

    public Account logIn() {
        String userName = JOptionPane.showInputDialog("Your User Name: ");
        String password = JOptionPane.showInputDialog("Your Password: ");

        Account objAccount = null;
        String message = "";

        for (Account validation : this.accountList) {
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
}
