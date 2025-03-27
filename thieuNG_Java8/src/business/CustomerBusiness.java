package business;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerBusiness {

    public static void addCustomer(Scanner scanner){
        Customer customer = new Customer();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        System.out.println("Thêm khách hàng thành công!");
    }
    public static void displayCustomers(){
        Customer customer = new Customer();
        customer.toString();
    }
}
