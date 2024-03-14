package entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order{
    private int id;
    private LocalDate date;
    private LocalTime time;
    private double totalPrice;
    private int status;

    private Client client;

    private DeliveryMan deliveryMan;

    private ArrayList<Product> listProducts;


    public Order() {
    }



    public Order(int id, double totalPrice, int status, Client client, DeliveryMan deliveryMan) {
        this.id = id;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.totalPrice = totalPrice;
        this.status = status;
        this.client = client;
        this.deliveryMan = deliveryMan;
        this.listProducts = new ArrayList<>();

    }

    public Order(int id, double totalPrice, int status, Client client) {
        this.id = id;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.totalPrice = totalPrice;
        this.status = status;
        this.client = client;
        this.listProducts = new ArrayList<>();

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", client=" + client +
                ", deliveryMan=" + deliveryMan +
                ", listProducts=" + listProducts +
                '}';
    }
}
