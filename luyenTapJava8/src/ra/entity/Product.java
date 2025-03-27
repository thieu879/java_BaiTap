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
    public  Product() {}
    public Product(String category, LocalDate createdDate, float price, int productId, String productName) {
        this.category = category;
        this.createdDate = LocalDate.now();
        this.price = price;
        this.productId = ++countProductId;
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        float priceProduct = scanner.nextFloat();
        System.out.println("Nhập danh mục sản phẩm: ");
        String categoryProduct = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("Mã: %d | Tên: %s | Giá: %.2f | Danh mục: %s | Ngày tạo: %s%n",
                productId, productName, price, category, createdDate);
    }
}
