package org.dario;

public class ArtObject extends ProductForSale{
    public ArtObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {

        System.out.println("ArtObject: " + type + " " + description + " " + price);

    }
}
