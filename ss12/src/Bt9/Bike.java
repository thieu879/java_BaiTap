package Bt9;

public class Bike extends Vehicle {
    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void move() {
        System.out.println(name + " di chuyển với tốc độ chậm " + speed + " km/h.");
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Ring Ring!");
    }
}

