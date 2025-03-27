package business;

import entity.Customer;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBusiness implements IOrderBusiness {
    public static List<Order> orders = new ArrayList<>();
    @Override
    public void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        orders.add(order);
    }

    @Override
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng hàng nào!");
            return;
        }
        orders.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {

    }

    @Override
    public List<Order> getOrderOverdue() {
        return List.of();
    }

    @Override
    public double getTotalRevenue() {
        return IOrderBusiness.super.getTotalRevenue();
    }

    @Override
    public List<Order> getOrderDelivied() {
        return List.of();
    }
}
