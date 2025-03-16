package Bt8;

public class ElectricCar extends Car implements Refuelable{
    public ElectricCar(String model, double price, int year) {
        super(model, price, year);
    }

    @Override
    public String start() {
        return "Xe điện " + toString() + " đã khởi động tiếng ồn";
    }

    @Override
    public String stop() {
        return "xe điện " + toString() + " đã dừng và ngắt kết nối động cơ";
    }

    @Override
    public String refuel() {
        return "xe điện " + toString() + " đang sạc điện...";
    }
}
