package Bt9;

public abstract class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public abstract void move();
    public abstract void sound();

    public void move(int time) {
        int distance = speed * time;
        System.out.println(name + " đã di chuyển được " + distance + " km trong " + time + " giờ.");
    }
}

