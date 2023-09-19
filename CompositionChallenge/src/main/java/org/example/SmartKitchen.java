package org.example;

public class SmartKitchen {

    private Refrigerator iceBox;
    private DishWasher dishWasher;
    private CoffeeMaker coffeeMaker;

    public SmartKitchen() {
        iceBox = new Refrigerator();
        dishWasher = new DishWasher();
        coffeeMaker = new CoffeeMaker();
    }

    public Refrigerator getRefrigerator() {
        return iceBox;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }

    public void addWater() {

        getCoffeeMaker().setHasWorkToDo(true);
    }

    public void pourMilk() {

        iceBox.setHasWorkToDo(true);
    }

    public void loadDishWasher() {

        getDishWasher().setHasWorkToDo(true);
    }

    public void setKitchenState(boolean coffee, boolean milk, boolean dishes) {
        iceBox.setHasWorkToDo(milk);
        dishWasher.setHasWorkToDo(dishes);
        coffeeMaker.setHasWorkToDo(coffee);
    }

    public void doKitchenWork(){

        iceBox.orderFood();
        dishWasher.doDishes();
        coffeeMaker.brewCoffee();
    }


}
