package controller;

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

    @Override
    public String toString() {
        return "OrderController{" +
                "ordersList=" + this.ordersList +
                '}';
    }
}
