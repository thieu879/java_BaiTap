package Bt3;

public class Car {
    private String make;
    private String model;
    private int year;

    public Car(int year, String model, String make) {
        this.year = year;
        this.model = model;
        this.make = make;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        if (year>2025){
            System.out.print("Năm sản xuất lớn hơn năm hiện tại nên sẽ mặc định là năm hiện tại: ");
            this.year = 2025;
        }else {
            this.year = year;
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car(2023, "Corolla", "Toyota");
        System.out.println(car1.getYear());
        System.out.println(car1.getMake());
        System.out.println(car1.getModel());

        car1.setYear(2027);
        System.out.println(car1.getYear());
    }
}
