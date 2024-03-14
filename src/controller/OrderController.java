package controller;

import entity.Order;

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
    public void  listOrder (String userName){
        for(Order orderTemp: this.ordersList){
            if (orderTemp.getClient().getUserName().equalsIgnoreCase(userName)){
                System.out.println(orderTemp.toString());
            }else {
                System.out.println("No se encontró información");
            }
        }
    }


    @Override
    public String toString() {
        return "OrderController{" +
                "ordersList=" + this.ordersList +
                '}';
    }


}
