package entity;

import java.util.Scanner;

public class Product implements IApp{
    private String productId;
    private String name;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;
    public Product() {}
    public Product(String description, float exportPrice, float importPrice, String name, String productId, int quantity, int status, String title, int categoryId) {
        this.description = description;
        this.exportPrice = exportPrice;
        this.importPrice = importPrice;
        this.name = name;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.title = title;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm (C/E/T + 4 ký tự): ");
        this.productId = scanner.nextLine();
        while (!this.productId.matches("[CET]\\d{4}")) {
            System.out.print("Sai rồi nhập lại đi: ");
            this.productId = scanner.nextLine();
        }

        System.out.print("Nhập tên sản phẩm (10-100 ký tự): ");
        this.name = scanner.nextLine();
        while (this.name.length() < 10 || this.name.length() > 100) {
            System.out.print("dài quá rồi nhập lại đi: ");
            this.name = scanner.nextLine();
        }

        System.out.print("Nhập giá nhập (>0): ");
        this.importPrice = scanner.nextFloat();
        while (this.importPrice <= 0) {
            System.out.print("Sai rồi nhập lại đi: ");
            this.importPrice = scanner.nextFloat();
        }

        System.out.print("Nhập giá xuất (>=Giá nhập khẩu): ");
        this.exportPrice = scanner.nextFloat();
        while (this.exportPrice < INTEREST * this.importPrice) {
            System.out.print("Nhập lỗi rồi nhập lại đi: ");
            this.exportPrice = scanner.nextFloat();
        }
        scanner.nextLine();

        System.out.print("Nhập tiêu đề (Tối đa 200 ký tự): ");
        this.title = scanner.nextLine();
        while (this.title.length() > 200) {
            System.out.print("Tiêu đề dài thớ: ");
            this.title = scanner.nextLine();
        }

        System.out.print("Nhập mô tả: ");
        this.description = scanner.nextLine();

        System.out.print("Nhập số lượng: ");
        this.quantity = scanner.nextInt();

        System.out.print("Nhập ID danh mục: ");
        this.categoryId = scanner.nextInt();

        System.out.print("Nhập trạng thái (0: Đang hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
        this.status = scanner.nextInt();
        while (this.status < 0 || this.status > 2) {
            System.out.print("Nhập sai rồi nhập lại đê: ");
            this.status = scanner.nextInt();
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên: " + name);
        System.out.println("Giá Nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh Mục: " + categoryId);
        System.out.println("Trạng thái: " + (status == 0 ? "Active" : status == 1 ? "Out of stock" : "Inactive"));
    }
}
