package Bt7;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(),
                new Bike(),
                new Bus()
        };

        for (Vehicle v : vehicles) {
            System.out.println("Move: " + v.move());
            System.out.println("Sound: " + v.sound());
        }
    }
}

