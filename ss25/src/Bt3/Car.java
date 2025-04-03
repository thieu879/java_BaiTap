package Bt3;

public class Car {
    private String engine;
    private int seats;
    private String color;

    Car(String engine, int seats, String color) {
        this.engine = engine;
        this.seats = seats;
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", seats=" + seats + ", color=" + color + "]";
    }
}
