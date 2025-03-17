package entity;

import java.util.Scanner;

public class Product implements IApp {
    private static final int MIN_NAME_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_TITLE_LENGTH = 200;
    private static final String PRODUCT_ID_PATTERN = "[CET]\\d{4}";

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

    public Product(String description, float exportPrice, float importPrice, String name, String productId,
                   int quantity, int status, String title, int categoryId) {
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
        this.productId = inputProductId(scanner);
        this.name = inputString(scanner, "Nhập tên sản phẩm (" + MIN_NAME_LENGTH + "-" + MAX_NAME_LENGTH + " ký tự): ",
                MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        this.importPrice = inputPositiveFloat(scanner, "Nhập giá nhập (>0): ");
        this.exportPrice = inputExportPrice(scanner, this.importPrice);
        scanner.nextLine(); // Clear buffer
        this.title = inputString(scanner, "Nhập tiêu đề (tối đa " + MAX_TITLE_LENGTH + " ký tự): ", 0, MAX_TITLE_LENGTH);
        System.out.print("Nhập mô tả: ");
        this.description = scanner.nextLine();
        this.quantity = inputPositiveInt(scanner, "Nhập số lượng: ");
        this.categoryId = inputPositiveInt(scanner, "Nhập ID danh mục: ");
        this.status = inputStatus(scanner);
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

    private String inputProductId(Scanner scanner) {
        String input;
        do {
            System.out.print("Nhập mã sản phẩm (C/E/T + 4 ký tự): ");
            input = scanner.nextLine();
        } while (!input.matches(PRODUCT_ID_PATTERN));
        return input;
    }

    private String inputString(Scanner scanner, String prompt, int minLength, int maxLength) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.length() < minLength || input.length() > maxLength) {
                System.out.println("Độ dài phải từ " + minLength + " đến " + maxLength + " ký tự!");
            }
        } while (input.length() < minLength || input.length() > maxLength);
        return input;
    }

    private float inputPositiveFloat(Scanner scanner, String prompt) {
        float value;
        do {
            System.out.print(prompt);
            value = Float.parseFloat(scanner.nextLine());
            if (value <= 0) System.out.println("Giá trị phải lớn hơn 0!");
        } while (value <= 0);
        return value;
    }

    private float inputExportPrice(Scanner scanner, float importPrice) {
        float value;
        do {
            System.out.print("Nhập giá xuất (>= " + (INTEREST * importPrice) + "): ");
            value = Float.parseFloat(scanner.nextLine());
            if (value < INTEREST * importPrice) System.out.println("Giá xuất phải lớn hơn hoặc bằng " + (INTEREST * importPrice) + "!");
        } while (value < INTEREST * importPrice);
        return value;
    }

    private int inputPositiveInt(Scanner scanner, String prompt) {
        int value;
        do {
            System.out.print(prompt);
            value = Integer.parseInt(scanner.nextLine());
            if (value < 0) System.out.println("Giá trị phải lớn hơn hoặc bằng 0!");
        } while (value < 0);
        return value;
    }

    private int inputStatus(Scanner scanner) {
        int value;
        do {
            System.out.print("Nhập trạng thái (0: Đang hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
            value = Integer.parseInt(scanner.nextLine());
            if (value < 0 || value > 2) System.out.println("Trạng thái phải từ 0 đến 2!");
        } while (value < 0 || value > 2);
        return value;
    }
}
