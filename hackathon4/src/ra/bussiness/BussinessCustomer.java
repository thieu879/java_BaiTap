package ra.bussiness;

import ra.entity.Customer;
import java.util.*;

public class BussinessCustomer {
    private static List<Customer> customers = new ArrayList<>();

    public void displayAllData() {
        if (customers.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            customers.forEach(Customer::displayData);
        }
    }

    public void addCustomer(Scanner sc) {
        Customer newCustomer = new Customer();
        newCustomer.inputData(sc);
        customers.add(newCustomer);
        System.out.println("Thêm thành công");
    }

    public void updateCustomer(Scanner sc) {
        System.out.println("Nhập mã khách hàng để sửa thông tin: ");
        String customerId = sc.nextLine();
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customerId)) {
                System.out.println("Cập nhật thông tin khách hàng...");
                c.inputData(sc);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
    }

    public void deleteCustomer(Scanner sc) {
        System.out.println("Nhập mã của khách hàng muốn xoá: ");
        String customerId = sc.nextLine();
        boolean removed = customers.removeIf(c -> c.getCustomerId().equals(customerId));
        if (removed) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy khách hàng!");
        }
    }

    public void searchCustomer(Scanner sc) {
        while (true) {
            System.out.println("1. Tìm kiếm theo tên khách hàng");
            System.out.println("2. Tìm kiếm theo loại khách hàng");
            System.out.println("3. Tìm kiếm theo số điện thoại");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) break;

            System.out.print("Nhập thông tin cần tìm: ");
            String input = sc.nextLine();
            customers.stream()
                    .filter(c -> (choice == 1 && c.getFirstName().equalsIgnoreCase(input)) ||
                            (choice == 2 && c.getCustomerType().equalsIgnoreCase(input)) ||
                            (choice == 3 && c.getPhoneNumber().equals(input)))
                    .forEach(System.out::println);
        }
    }

    public void sortCustomer(Scanner sc) {
        while (true) {
            System.out.println("1. Sắp xếp theo tên (A-Z / Z-A)");
            System.out.println("2. Sắp xếp theo năm sinh (Tăng/Giảm)");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) break;

            if (choice == 1) {
                customers.sort(Comparator.comparing(Customer::getFirstName));
            } else if (choice == 2) {
                customers.sort(Comparator.comparing(Customer::getDateOfBirth));
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }

            displayAllData();
        }
    }
}
