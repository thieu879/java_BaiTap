package Bt9;

public class Airplane extends Vehicle {
    private int altitude;

    public Airplane(String name, int speed, int altitude) {
        super(name, speed);
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println(name + " bay trên không với tốc độ " + speed + " km/h.");
    }

    @Override
    public void sound() {
        System.out.println(name + " phát ra âm thanh: Whoosh!");
    }

    public void showAltitude() {
        System.out.println(name + " đang bay ở độ cao " + altitude + " mét.");
    }
}

