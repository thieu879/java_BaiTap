package Bt8;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();

        Car tesla = new ElectricCar("Tesla Model 3", 50000, 2023);
        Car toyota = new GasCar("Toyota Camry", 35000, 2022);

        garage.addCar(tesla);
        garage.addCar(toyota);

        garage.print();
    }
}
