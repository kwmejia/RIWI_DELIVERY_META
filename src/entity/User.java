package entity;

import java.util.ArrayList;

public class User extends Account{

    private String name;

    private String phone;

    private ArrayList<Order> history;

    private double rating;

    private int id;

    public User(String userName, String password, Role role, String name, String phone, double rating, int id) {
        super(userName, password, role);
        this.name = name;
        this.phone = phone;
        this.history = new ArrayList<Order>();
        this.rating = rating;
        this.id = id;
    }

    User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Order> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Order> history) {
        this.history = history;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super().toString() + "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", history=" + history +
                ", rating=" + rating +
                ", id=" + id +
                '}';
    }
}


