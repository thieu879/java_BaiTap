package Bt9;

public class Car extends Vehicle {
    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void move() {
        System.out.println(name + " di chuyển trên mặt đất với tốc độ " + speed + " km/h.");
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Vroom!");
    }
}

