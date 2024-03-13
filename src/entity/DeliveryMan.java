package entity;

public class DeliveryMan {
    private String vehicle;

    private String plate;

    private String document;

    private boolean isActive;

    public DeliveryMan(String vehicle, String plate, String document, boolean isActive) {
        this.vehicle = vehicle;
        this.plate = plate;
        this.document = document;
        this.isActive = isActive;
    }

    public DeliveryMan() {
    }

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