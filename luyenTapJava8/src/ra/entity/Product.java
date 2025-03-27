package ra.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Product implements IProduct {
    private static int countProductId = 0;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product(String category, LocalDate createdDate, float price, int productId, String productName) {
        this.category = category;
        this.createdDate = LocalDate.now();
        this.price = price;
        this.productId = ++countProductId;
        this.productName = productName;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập ");
    }

    @Override
    public void displayData() {

    }
}
