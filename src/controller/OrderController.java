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


    public void listOrdersByClient(Client client){
        String list = "LIST CLIENT "+ client.getName()+" \n";
        for (Order temp: this.ordersList){
            if (temp.getClient().getId()== client.getId()){
                list+=temp.toString()+"\n";
            }
        }

        JOptionPane.showMessageDialog(null,list);

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
                //Se sumhttps://github.com/kwmejia/RIWI_DELIVERY_META/pull/29a al totalPrice el valor del producto
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
    public void createOrder(Client client) {
        //Se crea la orden
        Order objNewOrder = new Order(OrderController.idOrder,0, StatusOrder.PENDING,client);
        this.selectProduct(objNewOrder);
        OrderController.idOrder++;

        //Se agrega a la lista de ordenes
        this.ordersList.add(objNewOrder);

        JOptionPane.showMessageDialog(null,"Orden agregada correctamente.");
    }

    //Setters and Getters
    public ArrayList<Order> getOrdersList() {
        return this.ordersList;
    }

    public void setOrdersList(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }


    /**
     * <h3>Este es el metodo para listar ordenes</h3>
     *
     * @return como nos retorna un String dentro del for le ponemos void que no retorna nada
     */
    public void  listOrderByUserName (String userName){
        String orderText = "List de Orders \n";
        for(Order orderTemp: this.ordersList){
            if (orderTemp.getClient().getUserName().equalsIgnoreCase(userName)){
                orderText += orderTemp.toString() + "\n";
            }else {
                orderText += "Not found orders";
            }
        }
        JOptionPane.showMessageDialog(null,orderText);
    }


    public  Order getOrderById(int id){
        for (Order temp : this.ordersList){
            if (temp.getId()== id) return  temp;
        }

        return null;
    }

    public void  listOrdersUnasigned (){

        String orderText = "Orders List \n";
        for(Order orderTemp: this.ordersList){
            if (orderTemp.getStatus() == StatusOrder.UNASSIGNED){
                orderText += orderTemp.toString() + "\n";
            }else {
                orderText += "Not found orders";
            }
        }
        JOptionPane.showMessageDialog(null,orderText);
    }

    public int  listOrdersUnasigned (Boolean pasarBool){

        String orderText = "Select order index to accept:\n";
        int index = 0;
        for(Order orderTemp: this.ordersList){
            if (orderTemp.getStatus() == StatusOrder.UNASSIGNED){
                orderText +=  ++index + ": " + " address: " + orderTemp.getClient().getAddress() +" to:"+ orderTemp.getClient().getName() + " price:" + orderTemp.getTotalPrice() + "\n";
            }else {
                index++;
            }
        }
        return Integer.parseInt( JOptionPane.showInputDialog(null,orderText));
    }

    public void orderDeliveryMan(User user) {
        this.listOrderByUserName(user.getUserName());

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id de la orden que quiere finalizar ."));
        Order orderDelete = this.getOrderById(idDelete);
        if (orderDelete != null) {
            user.addOrderHistory(orderDelete);
            orderDelete.getClient().addOrderHistory(orderDelete);
        }

        if (this.ordersList.removeIf(temp -> temp.getId() == idDelete)){
                JOptionPane.showMessageDialog(null,"Fini");
        };

    }


    public void takeOrder(DeliveryMan repartidorAceptar){
        int select = this.listOrdersUnasigned(true);
        if (select>0){
            ArrayList<Order> historialRepartidor =  repartidorAceptar.getHistory();
            this.ordersList.get(select).setStatus(StatusOrder.PENDING);
            this.ordersList.get(select).setDeliveryMan(repartidorAceptar);
            historialRepartidor.add(this.ordersList.get(select));
            JOptionPane.showMessageDialog(null,"The order was assigned to "+repartidorAceptar.getName() + " successfully.");
        }else{
            JOptionPane.showInputDialog(null,"There's no order to take." );
        }


    }

    @Override
    public String toString() {
        return "OrderController{" +
                "ordersList=" + this.ordersList +
                '}';
    }


}
