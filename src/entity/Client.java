package entity;

public class Client extends User {

    private String address;

    public Client(String address) {
        this.address = address;
    }

    public Client() {
    }

    public Client(String userName, String password, Role role, String name, String phone, double rating, int id, String address) {
        super(userName, password, role, name, phone, rating, id);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
