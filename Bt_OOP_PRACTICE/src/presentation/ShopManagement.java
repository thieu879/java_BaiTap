package presentation;

import entity.Categories;
import entity.Product;
import java.util.Scanner;

public class ShopManagement {
    private static final int MAX_CATEGORIES = 100;
    private static final int MAX_PRODUCTS = 1000;
    private Categories[] categories = new Categories[MAX_CATEGORIES];
    private Product[] products = new Product[MAX_PRODUCTS];
    private int categoryCount = 0;
    private int productCount = 0;
    private Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        while (true) {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: categoryManagement(); break;
                case 2: productManagement(); break;
                case 3: return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void categoryManagement() {
        while (true) {
            System.out.println("********************CATEGORIE MANAGEMENT*********************");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < categoryCount; i++) {
                        if (categories[i] != null) {
                            categories[i].displayData();
                        }
                    }
                    break;
                case 2:
                    if (categoryCount < MAX_CATEGORIES) {
                        Categories c = new Categories();
                        c.inputData(scanner);
                        // Kiểm tra trùng tên
                        boolean isDuplicate = false;
                        for (int i = 0; i < categoryCount; i++) {
                            if (categories[i].getName().equals(c.getName())) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (!isDuplicate) {
                            categories[categoryCount++] = c;
                            System.out.println("Thêm danh mục thành công!");
                        } else {
                            System.out.println("Tên danh mục đã tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách danh mục đã đầy!");
                    }
                    break;
                case 6: return;
            }
        }
    }

    private void productManagement() {
        while (true) {
            System.out.println("************************PRODUCT MANAGEMENT*******************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < productCount; i++) {
                        if (products[i] != null) {
                            products[i].displayData();
                        }
                    }
                    break;
                case 2:
                    if (productCount < MAX_PRODUCTS) {
                        Product p = new Product();
                        p.inputData(scanner);
                        // Kiểm tra trùng mã sản phẩm
                        boolean isDuplicate = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(p.getProductId())) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (!isDuplicate) {
                            products[productCount++] = p;
                            System.out.println("Thêm sản phẩm thành công!");
                        } else {
                            System.out.println("Mã sản phẩm đã tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách sản phẩm đã đầy!");
                    }
                    break;
                case 10: return;
            }
        }
    }

    public static void main(String[] args) {
        new ShopManagement().displayMainMenu();
    }
}