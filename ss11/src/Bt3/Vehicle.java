package Bt3;

public abstract class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    abstract void displayInfo();
    public void start(){
        System.out.println("Vehicle is starting...");
    }
}
