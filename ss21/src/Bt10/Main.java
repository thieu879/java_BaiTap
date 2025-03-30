package Bt10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", "Áo thun", 150000));
        products.add(new Product("P002", "Quần jeans", 500000));
        products.add(new Product("P003", "Giày thể thao", 800000));

        ShoppingCart cart = new ShoppingCart();
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Danh sách sản phẩm có sẵn:");
                        for (int i = 0; i < products.size(); i++) {
                            Product p = products.get(i);
                            System.out.printf("%d. %s - %s: %.2f%n",
                                    i + 1, p.getId(), p.getName(), p.getPrice());
                        }
                        break;

                    case 2:
                        System.out.println("Danh sách sản phẩm:");
                        for (int i = 0; i < products.size(); i++) {
                            Product p = products.get(i);
                            System.out.printf("%d. %s - %s%n", i + 1, p.getId(), p.getName());
                        }
                        System.out.print("Nhập số thứ tự sản phẩm: ");
                        int productIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (productIndex < 0 || productIndex >= products.size()) {
                            System.out.println("Sản phẩm không tồn tại!");
                            break;
                        }
                        System.out.print("Nhập số lượng: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        cart.addToCart(products.get(productIndex), quantity);
                        System.out.println("Đã thêm vào giỏ hàng!");
                        break;

                    case 3:
                        cart.displayCart();
                        System.out.print("Nhập mã sản phẩm để xóa: ");
                        String productId = scanner.nextLine();
                        cart.removeFromCart(productId);
                        System.out.println("Đã xóa sản phẩm!");
                        break;

                    case 4:
                        cart.displayCart();
                        break;

                    case 5:
                        cart.checkout();
                        break;

                    case 6:
                        running = false;
                        System.out.println("Cảm ơn bạn đã mua sắm!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("=== HỆ THỐNG MUA SẮM ===");
        System.out.println("1. Xem danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm vào giỏ hàng");
        System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
        System.out.println("4. Xem giỏ hàng");
        System.out.println("5. Thanh toán");
        System.out.println("6. Thoát");
    }
}
