package entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private static int countcustomerId = 0;
    private int customerId;
    private String customerName;
    private Optional<String> email;
    public  Customer() {

    }
    public Customer(int customerId, String customerName, Optional<String> email) {
        this.customerId = ++countcustomerId;
        this.customerName = customerName;
        this.email = Optional.ofNullable("Không có");
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập email khách haàng: ");
        String email = scanner.nextLine();
    }
    @Override
    public String toString() {
        return "ID: "+this.customerId+" Tên: " + this.customerName + " email: " + this.email;
    }
}
