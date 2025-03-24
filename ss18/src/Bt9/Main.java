package Bt9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        businessProduct manager = new businessProduct();

        do {
            System.out.println("\n=== QUẢN LÝ KHO HÀNG ===");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Cập nhật sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Tính tổng giá trị kho");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manager.addProduct();
                    break;
                case 2:
                    manager.updateProduct();
                    break;
                case 3:
                    manager.deleteProduct();
                    break;
                case 4:
                    manager.getTotalPrice();
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}