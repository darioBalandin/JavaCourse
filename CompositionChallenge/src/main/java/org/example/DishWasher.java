package org.example;

public class DishWasher {

    private boolean hasWorkToDo;

    public void doDishes() {

        if (isHasWorkToDo()) {
            System.out.println("Doing dishes...");
        }
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
}
