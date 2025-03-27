package business;

import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBusiness implements IOrderBusiness {

    @Override
    public void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        List<Order> orderList = new ArrayList();
        orderList.add(order);
    }

    @Override
    public void displayOrders() {
        Order order = new Order();
        order.toString();
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
