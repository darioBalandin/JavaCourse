package org.example;

public class CoffeeMaker {

    private boolean hasWorkToDo;

    public void brewCoffee() {
        if (isHasWorkToDo()) {
            System.out.println("Making coffee...");
        }
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }
}
