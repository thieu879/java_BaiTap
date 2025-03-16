package Bt7;

public class Bus extends Vehicle {
    @Override
    public String move() {
        return "Bus moving at medium speed";
    }

    @Override
    public String sound() {
        return "Honk Honk";
    }
}
