package controller;

import entity.Order;

import javax.swing.*;
import java.util.ArrayList;

public class OrderController {
    private ArrayList<Order> ordersList;

    public OrderController() {
        this.ordersList = new ArrayList<>();
    }

    public ArrayList<Order> getOrdersList() {
        return this.ordersList;
    }

    public void setOrdersList(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }


    /**
     * <h3>Este es el metodo para listar ordenes</h3>
     *
     * @return como nos retorna un String dentro del for le ponemos void que no retorna nada
     */
    public void  listOrderByUserName (String userName){
        String orderText = "Lista de Ordenes \n";
        for(Order orderTemp: this.ordersList){
            if (orderTemp.getClient().getUserName().equalsIgnoreCase(userName)){
                orderText += orderTemp.toString() + "\n";
            }else {
             JOptionPane.showMessageDialog(null, "No se encontraron ordenes");
            }
        }
        JOptionPane.showMessageDialog(null,orderText);
    }


    @Override
    public String toString() {
        return "OrderController{" +
                "ordersList=" + this.ordersList +
                '}';
    }


}
