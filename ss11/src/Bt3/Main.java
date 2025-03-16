package Bt3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("toyota", 100);
        Bike bike = new Bike("toyote", 100);
        car.start();
        car.displayInfo();
        bike.start();
        bike.displayInfo();
    }
}
