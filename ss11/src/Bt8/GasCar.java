package Bt8;

public class GasCar extends Car implements Refuelable{
    public GasCar(String model, double price, int year) {
        super(model, price, year);
    }

    @Override
    public String start() {
        return "Xe chạy xăng " + toString() + " đã khởi động với tiếng động cơ.";
    }

    @Override
    public String stop() {
        return "Xe chạy xăng " + toString() + " đã dừng và động cơ tắt.";
    }

    @Override
    public String refuel() {
        return "Xe chạy xăng " + toString() + " đang được đổ xăng...";
    }
}
