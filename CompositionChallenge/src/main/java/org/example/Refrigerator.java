package org.example;

public class Refrigerator {

    private boolean hasWorkToDo;

    public void orderFood() {

        if (isHasWorkToDo()) {
            System.out.println("Ordering food...");
        }
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
}
