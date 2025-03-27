package business;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerBusiness {
    public static List<Customer> customers = new ArrayList<>();
    public static void addCustomer(Scanner scanner){
        Customer customer = new Customer();
        customer.inputData(scanner);
        customers.add(customer);
        System.out.println("Thêm khách hàng thành công!");
    }
    public static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Không có khách hàng nào!");
            return;
        }
        customers.forEach(System.out::println);
    }
}
