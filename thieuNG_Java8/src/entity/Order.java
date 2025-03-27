package entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Order implements IApp {
    private int countOrderId =  0;
    private int orderId;
    private LocalDate orderDate;
    private Customer customer;
    private double totalAmount;
    private boolean status = false;

    public Order() {}
    public Order(Customer customer, LocalDate orderDate, int orderId, boolean status, double totalAmount) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderId = ++countOrderId;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập ngày đặt hàng: ");
        LocalDate  orderDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println("Nhập vào tổng tiền đơn hàng: ");
        double totalAmount = scanner.nextDouble();

    }
    @Override
    public String toString() {
        return "Mã đơn hàng: " + this.orderId + "Ngày đặt hàng: " + this.orderDate + "Tổng đơn hàng: " + this.totalAmount + "Tên khách hàng: " + this.customer.getCustomerName();
    }
}
