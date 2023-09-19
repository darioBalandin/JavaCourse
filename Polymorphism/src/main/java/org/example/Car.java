package org.example;

public class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        engine = true;
        wheels = 4;
    }

    public void startEngine() {
        System.out.println(this.getClass().getSimpleName() + "is starting");
    }

    public void accelerate() {
        System.out.println(this.getClass().getSimpleName() +"is accelerating");
    }

    public void brake() {
        System.out.println( this.getClass().getSimpleName() +"is braking");
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
