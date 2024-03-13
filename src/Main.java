import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int option = 0;
        do{

            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(null,"""
                        PRINCIPAL MENU
                            1. Login
                            2. Sign up
                            3. Exit
                        """));

                switch (option){
                    case 1:
                        JOptionPane.showMessageDialog(null,"Login");
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null,"Sign up");
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null,"leaving");
                        break;

                }

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Invalid option");
            }

        }while (option!=3);


    }
}