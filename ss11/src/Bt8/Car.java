package Bt8;

public abstract class Car {
    private String model;
    private int year;
    private double price;

    public Car(String model, double price, int year) {
        this.model = model;
        this.price = price;
        this.year = year;
    }
    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
    public abstract String start();
    public abstract String stop();
    public String toString() {
        return getModel() + " (năm sản xuất " + getYear() + " ,giá: $" + getPrice() + " )";
    }
    public String refuel(){
        return  getModel();
    }
}
