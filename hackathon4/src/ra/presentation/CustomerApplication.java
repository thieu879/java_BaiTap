package ra.presentation;

import ra.bussiness.BussinessCustomer;
import ra.entity.Customer;

import java.util.Scanner;

public class CustomerApplication {
    private static BussinessCustomer bussinessCustomer =  new BussinessCustomer();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----------------------------Customer Menu----------------------------");
            System.out.println("1. Hiển thị danh sách các khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát chương trình");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bussinessCustomer.displayAllData();
                    break;
                case 2:
                    bussinessCustomer.addCustomer(scanner);
                    break;
                case 3:
                    bussinessCustomer.updateCustomer(scanner);
                    break;
                case 4:
                    bussinessCustomer.deleteCustomer(scanner);
                    break;
                case 5:
                    bussinessCustomer.searchCustomer(scanner);
                    break;
                case 6:
                    bussinessCustomer.sortCustomer(scanner);
                    break;
                case 0:
                    System.out.println("tạm biệt");
                    return;
                default:
                    System.out.println("Lựa chọn sai rồi nhập lại đi");
                    break;
            }
        }while (true);
    }
}
