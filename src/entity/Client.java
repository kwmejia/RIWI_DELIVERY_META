package entity;

public class Client extends Account {
    private String address;

    public Client(String address) {
        this.address = address;
    }

    public Client() {
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
                '}';
    }
}
