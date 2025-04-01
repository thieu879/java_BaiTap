package ra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer implements IApp {
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;
    private static List<Customer> customers = new ArrayList<>();

    public Customer() {}

    public Customer(String address, String customerId, String customerType, String dateOfBirth, String email, String firstName, boolean gender, String lastName, String phoneNumber) {
        this.address = address;
        this.customerId = customerId;
        this.customerType = customerType;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Customer.customers = customers;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập mã khách hàng: ");
        String id = sc.nextLine();
        if (id.length() < 5 || !id.matches("C\\d+")) {
            System.err.println("Mã khách hàng không hợp lệ");
            return;
        }
        for (Customer customer : customers) {
            if (id.equals(customer.getCustomerId())) {
                System.err.println("Mã khách hàng đã tồn tại");
                return;
            }
        }

        System.out.println("Nhập tên khách hàng: ");
        String firstName = sc.nextLine();
        if (firstName.length() > 50 || firstName.isEmpty()) {
            System.err.println("Tên khách hàng tối đa là 50 ký tự và không được để trống");
            return;
        }

        System.out.println("Nhập họ khách hàng: ");
        String lastName = sc.nextLine();
        if (lastName.length() > 30 || lastName.isEmpty()) {
            System.err.println("Họ khách hàng tối đa là 30 ký tự và không được để trống");
            return;
        }

        System.out.println("Nhập ngày sinh của khách hàng (định dạng dd/MM/yyyy)");
        String dateOfBirth = sc.nextLine();

        System.out.println("Nhập giới tính (true - Nam, false - Nữ)");
        boolean gender = Boolean.parseBoolean(sc.nextLine());

        System.out.println("Nhập địa chỉ khách hàng: ");
        String address = sc.nextLine();
        if (address.length() > 255 || address.isEmpty()) {
            System.err.println("Địa chỉ tối đa là 255 ký tự và không được để trống");
            return;
        }

        System.out.println("Nhập số điện thoại khách hàng: ");
        String phone = sc.nextLine();
        for (Customer customer : customers) {
            if (phone.equals(customer.getPhoneNumber())) {
                System.err.println("Số điện thoại đã tồn tại");
                return;
            }
        }

        System.out.println("Nhập email khách hàng: ");
        String email = sc.nextLine();
        for (Customer customer : customers) {
            if (email.equals(customer.getEmail())) {
                System.err.println("Email đã tồn tại");
                return;
            }
        }

        System.out.println("Nhập loại khách hàng: ");
        String customerType = sc.nextLine();
        if (customerType.isEmpty()) {
            System.err.println("Loại khách hàng không được để trống");
            return;
        }

        customers.add(new Customer(address, id, customerType, dateOfBirth, email, firstName, gender, lastName, phone));
        System.out.println("Thêm khách hàng thành công");
    }

    @Override
    public void displayData() {
        System.out.println("Mã khách hàng: " + customerId +
                ", Tên khách hàng: " + firstName +
                ", Họ khách hàng: " + lastName +
                ", Ngày sinh: " + dateOfBirth +
                ", Giới tính: " + (gender ? "Nam" : "Nữ") +
                ", Địa chỉ: " + address +
                ", Số điện thoại: " + phoneNumber +
                ", Email: " + email +
                ", Loại khách hàng: " + customerType);
    }
}
