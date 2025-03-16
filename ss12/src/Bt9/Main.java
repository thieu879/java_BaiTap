package Bt9;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 80);
        Vehicle bike = new Bike("Xe đạp", 20);
        Vehicle bus = new Bus("Xe buýt", 60, 40);
        Vehicle airplane = new Airplane("Máy bay", 900, 10000);

        car.move();
        car.sound();
        car.move(2);

        bike.move();
        bike.sound();
        bike.move(2);

        bus.move();
        bus.sound();
        bus.move(2);
        ((Bus) bus).showSeats();

        airplane.move();
        airplane.sound();
        airplane.move(2);
        ((Airplane) airplane).showAltitude();
    }
}
