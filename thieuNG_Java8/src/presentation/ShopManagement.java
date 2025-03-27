package presentation;

import business.CustomerBusiness;
import business.OrderBusiness;
import entity.Customer;

import java.util.Scanner;

import static java.lang.System.exit;

public class ShopManagement {
    private static CustomerBusiness customers = new CustomerBusiness();
    private static OrderBusiness orders = new OrderBusiness();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**********************SHOP MENU*******************");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("*********************CUSTOMER MENU********************");
                        System.out.println("1. Danh sách khách hàng");
                        System.out.println("2. Thêm mới khách hàng");
                        System.out.println("3. Thoát ");
                        System.out.println("Nhập lựa chọn");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1) {
                            case 1:
                                customers.displayCustomers();
                                break;
                            case 2:
                                customers.addCustomer(scanner);
                                break;
                            case 3:
                                exit(0);
                            default:
                                System.out.println("Nhập lại đi: ");
                                break;
                        }
                    }
                case 2:
                    while (true) {
                        System.out.println("*********************ORDER MENU*********************");
                        System.out.println("1. Danh sách đơn hàng");
                        System.out.println("2. Thêm mới đơn hàng");
                        System.out.println("3. Cập nhật trạng thái đơn hàng");
                        System.out.println("4. Danh sách đơn hàng quá hạn");
                        System.out.println("5. Thống kê số lượng đơn hàng đã giao (Trạng thái true)");
                        System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
                        System.out.println("7. Thoát");
                        System.out.println("Nhập lựa chon: ");
                        int choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1:
                                orders.displayOrders();
                                break;
                            case 2:
                                orders.addOrder(scanner);
                                break;
                            case 3:

                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                exit(0);
                                break;
                            default:
                                System.out.println("Nhập lại đi: ");
                                break;
                        }
                    }
                case 3:
                    exit(0);
                default:
                    System.out.println("Nhập lại đi: ");
                    break;
            }
        } while (true);
    }
}
