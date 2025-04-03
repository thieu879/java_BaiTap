package Bt3;

public class Main {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();

        Car car1 = builder
                .setEngine("V6")
                .setSeats(4)
                .setColor("Red")
                .build();

        Car car2 = builder
                .setEngine("V8")
                .setSeats(2)
                .setColor("Black")
                .build();

        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
    }
}
