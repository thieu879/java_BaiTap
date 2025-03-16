package Bt7;

public class Bike extends Vehicle {
    @Override
    public String move() {
        return "Bike moving slow";
    }

    @Override
    public String sound() {
        return "Ring Ring";
    }
}