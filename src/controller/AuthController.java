package controller;

import entity.Account;
import entity.Role;

public class AuthController {

    public  void logOut(Account loggedAccount){

        loggedAccount.setPassword("");
        loggedAccount.setUserName("");
        loggedAccount.setRole(Role.NULL);
    }

}
