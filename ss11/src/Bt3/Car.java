package Bt3;

public class Car extends Vehicle{

    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.println("Name: "+name+" Speed: "+speed);
    }
}
