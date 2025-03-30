package Bt8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "products.dat";

        // Tạo danh sách sản phẩm mẫu
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(101, "Laptop Asus", 15000000.0));
        productList.add(new Product(102, "Chuột Logitech", 500000.0));
        productList.add(new Product(103, "Bàn Gaming", 10000000.0));
        // Ghi danh sách sản phẩm vào file nhị phân products.dat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(productList);
            System.out.println("Đã ghi danh sách sản phẩm vào file products.dat");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
            return;
        }

        // Đọc danh sách sản phẩm từ file
        List<Product> readProductList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            readProductList = (List<Product>) ois.readObject();
            System.out.println("Đã đọc danh sách sản phẩm từ file products.dat");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy lớp Product: " + e.getMessage());
            return;
        }

        // Hiển thị danh sách sản phẩm
        if (readProductList == null || readProductList.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng!");
        } else {
            System.out.println("\nDanh sách sản phẩm:");
            System.out.println("+-------+----------------------+------------------+");
            System.out.println("| ID    | Tên                  | Giá              |");
            System.out.println("+-------+----------------------+------------------+");
            for (Product product : readProductList) {
                System.out.println(product);
            }
            System.out.println("+-------+----------------------+------------------+");
        }
    }
}
