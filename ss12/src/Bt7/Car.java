package Bt7;

public class Car extends Vehicle {
    @Override
    public String move() {
        return "Car moving fast";
    }

    @Override
    public String sound() {
        return "Vroom";
    }
}