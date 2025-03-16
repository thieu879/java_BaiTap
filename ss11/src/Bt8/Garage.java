package Bt8;

public class Garage {
    private Car[] cars;
    private int count;
    public Garage() {
        cars = new Car[10];
        count = 0;
    }
    public void addCar(Car car) {
        if (count < cars.length) {
            cars[count] = car;
            count++;
        }else {
            System.out.println("Đầy rồi!!!");
        }
    }
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i].start());
            System.out.println(cars[i].stop());
            System.out.println(cars[i].refuel());
        }
    }
}
