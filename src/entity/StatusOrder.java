package entity;

public enum StatusOrder {
    PENDING, //Cuando se esta creando
    DELIVERED, //Ya se entregó la orden
    UNASSIGNED, //Orden solicitada pero sin domiciliario
    CANCELED //Orden cancelada
}
