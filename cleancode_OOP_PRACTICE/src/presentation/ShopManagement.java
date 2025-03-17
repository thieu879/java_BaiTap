package presentation;

import entity.Categories;
import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    private final List<Categories> categories = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        while (true) {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");

            int choice = safeParseInt(scanner.nextLine());
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
            System.out.println("********************CATEGORY MANAGEMENT*********************");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice = safeParseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    categories.forEach(Categories::displayData);
                    break;
                case 2:
                    Categories category = new Categories();
                    category.inputData(scanner);
                    if (isUnique(categories, category.getName(), Categories::getName)) {
                        categories.add(category);
                        System.out.println("Thêm danh mục thành công!");
                    } else {
                        System.out.println("Tên danh mục đã tồn tại!");
                    }
                    break;
                case 6: return;
                default: System.out.println("Lựa chọn không hợp lệ!");
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

            int choice = safeParseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    products.forEach(Product::displayData);
                    break;
                case 2:
                    Product product = new Product();
                    product.inputData(scanner);
                    if (isUnique(products, product.getProductId(), Product::getProductId)) {
                        products.add(product);
                        System.out.println("Thêm sản phẩm thành công!");
                    } else {
                        System.out.println("Mã sản phẩm đã tồn tại!");
                    }
                    break;
                case 10: return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private <T> boolean isUnique(List<T> list, String value, java.util.function.Function<T, String> getter) {
        return list.stream().noneMatch(item -> getter.apply(item).equals(value));
    }

    private int safeParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Giá trị không hợp lệ
        }
    }

    public static void main(String[] args) {
        new ShopManagement().displayMainMenu();
    }
}