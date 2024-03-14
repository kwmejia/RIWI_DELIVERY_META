package controller;

import entity.*;

import javax.swing.*;
import java.util.ArrayList;

public class OrderController {
    //Variable
    static int idOrder = 0;

    private ArrayList<Order> ordersList;

    private  ArrayList<Product> listGeneralProduct;
    private String strListProducts;



    //Constructors
    public OrderController() {
        this.ordersList = new ArrayList<>();
        this.listGeneralProduct = new ArrayList<>();

        //Agregar productos generales
        listGeneralProduct.add(new Product(1,"Pizza",32000));
        listGeneralProduct.add(new Product(2,"Perro",12000));
        listGeneralProduct.add(new Product(3,"Hamburguesa",30000));
        listGeneralProduct.add(new Product(4,"Lasagna",25000));
    }


    //Methods

    //Retorna un string con una lista de productos y sus indices
    public String listProducts(){
        String strListProducts = "";
        for (int i = 0; i < this.listGeneralProduct.size(); i++) {
            strListProducts += (i+1) + this.listGeneralProduct.get(i).toString() + "\n";
        };
        return strListProducts;
    }

    //Pedir al usuario cuales productos quiere agregar
    public void selectProduct(Order order){
        try {
            //El usuario selecciona el producto que desea agregar
            String strListProducts = listProducts();
            int indexProductAdd = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el producto a agregar\n" +
                    strListProducts));

            //Se obtiene el producto a agregar
            Product productAdd = this.listGeneralProduct.get(indexProductAdd - 1);

            //Se obtiene la lista de productos que tiene la orden
            ArrayList<Product> productsOrder = order.getListProducts();

            if(productsOrder.add(productAdd)){
                //Se suma al totalPrice el valor del producto
                order.setTotalPrice(order.getTotalPrice() + productAdd.getPrice());

                //Se guarda la lista de productos
                order.setListProducts(productsOrder);

                JOptionPane.showMessageDialog(null, "Producto agregado correctamente!!");
            }else {
                JOptionPane.showMessageDialog(null, "Error al agregar producto");
                selectProduct(order);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Opcion invalida, producto no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Se crear la orden con todos los datos y agregarla a la lista de ordenes
    public void createOrder(Client client, DeliveryMan deliveryMan) {
        //Se crea la orden
        Order objNewOrder = new Order(OrderController.idOrder,0, StatusOrder.PENDING,client, deliveryMan);
        OrderController.idOrder++;

        //Se agrega a la lista de ordenes
        this.ordersList.add(objNewOrder);
    }

    //Setters and Getters
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
