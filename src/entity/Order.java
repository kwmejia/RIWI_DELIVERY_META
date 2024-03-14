package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private double totalPrice;
    private int status;


    public Order() {
    }

    public Order(int id, int date, int time, double totalPrice, int status) {
        this.id = id;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.totalPrice = totalPrice;
        this.status = status;
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
                '}';
    }
}
