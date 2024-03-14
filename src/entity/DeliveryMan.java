package entity;

public class DeliveryMan extends User {
    private String vehicle;

    private String plate;

    private String document;

    private boolean isActive;


    //Método constructor
    public DeliveryMan(String userName, String password, Role role, String name, String phone, double rating, int id, String vehicle, String plate, String document, boolean isActive) {
        super(userName, password, role, name, phone, rating, id);
        this.vehicle = vehicle;
        this.plate = plate;
        this.document = document;
        this.isActive = isActive;
    }

    //Constructor vacío para trabajar desde aquí
    public DeliveryMan() {
    }

    //Getter and Setter
    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    //toString
    @Override
    public String toString() {
        return "DeliveryMan{" +
                "vehicle='" + vehicle + '\'' +
                ", plate='" + plate + '\'' +
                ", document='" + document + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}