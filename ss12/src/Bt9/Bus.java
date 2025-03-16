package Bt9;

public class Bus extends Vehicle {
    private int seats;

    public Bus(String name, int speed, int seats) {
        super(name, speed);
        this.seats = seats;
    }

    @Override
    public void move() {
        System.out.println(name + " di chuyển trên đường với tốc độ " + speed + " km/h.");
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Honk!");
    }

    public void showSeats() {
        System.out.println(name + " có " + seats + " ghế ngồi.");
    }
}

