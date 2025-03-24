package Bt9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class businessProduct {
    private Map<Integer, Product> products = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.println("Nhập ID: ");
        int id = scanner.nextInt();
        if (products.containsKey(id)) {
            System.out.println("Sản phẩm đã tồn tại: ");
        }
        System.out.println("Nhập Tên sản phẩm: ");
        String name = scanner.next();
        System.out.println("Nhập Giá sản phẩm: ");
        double price = scanner.nextDouble();
        System.out.println("Nhập số lượng sản phẩm");
        int quantity = scanner.nextInt();
        Product product = new Product(id, name, price, quantity);
        products.put(id, product);
        System.out.println("Thêm thành công rồi!");
    }

    public void updateProduct() {
        System.out.println("Nhập Id sản phẩm muốn cập nhật: ");
        int id = scanner.nextInt();
        if (!products.containsKey(id)) {
            System.out.println("Sane phẩm không tồn tại!");
        } else {
            Product product = products.get(id);
            System.out.println("1. Cập nhật tên\n");
            System.out.println("2. Cập nhật giá\n");
            System.out.println("3. Cập nhật số lượng\n");
            System.out.println("chọn đi: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập Tên mới: ");
                    String newName = scanner.next();
                    product.setName(newName);
                    break;
                case 2:
                    System.out.println("Nhập giá mới: ");
                    double newPrice = scanner.nextDouble();
                    product.setPrice(newPrice);
                    break;
                case 3:
                    System.out.println("Nhập số lượng mới: ");
                    int newQuantity = scanner.nextInt();
                    product.setQuantity(newQuantity);
                    break;
                default:
                    System.out.println("đùa nhau à!!!");
                    break;
            }
            System.out.println("thành công rồi đấy");
        }
    }
    public void deleteProduct() {
        System.out.println("Nhập id cần xoá: ");
        int id = scanner.nextInt();
        if (products.containsKey(id)) {
            products.remove(id);
        }else{
            System.out.println("Đùa nhau à!!!");
        }
    }
    public void getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products.values()) {
            double total = product.getPrice() * product.getQuantity();
            totalPrice += total;
        }
        System.out.println("Tổng giá trị kho là: " +  totalPrice);
    }
}
