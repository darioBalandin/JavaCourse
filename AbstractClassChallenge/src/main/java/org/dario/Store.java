package org.dario;

import java.util.ArrayList;

public class Store {

    private static ArrayList<ProductForSale> products = new ArrayList<ProductForSale>();

    public static void main(String[] args) {

        products.add(new ArtObject("ArtObject", 100.0, "A beautiful sculpture"));
        products.add(new ArtObject("ArtObject", 200.0, "A beautiful painting"));

        listProducts();


        System.out.println("\n Order 1");
        var order1= new ArrayList<OrderItem>();


        addItemToOrder(order1,1,2);
        addItemToOrder(order1,0,4);

        printOrder(order1);

    }

    public static void listProducts() {
        System.out.println("listProducts");

        for (var item : products) {
            System.out.println("-".repeat(20));
            ;
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order,int orderIndex,int quantity ){

        order.add(new OrderItem(products.get(orderIndex),quantity));
    }

    public static void printOrder(ArrayList<OrderItem > order){

        double salesTotal=0;
        for(var item:order){

            item.product().printPricedItem(item.quantity());
            salesTotal+= item.product().getSalesPrice(item.quantity());
        }

        System.out.printf("Sales total = $%6.2f %n",salesTotal);


    }
}
