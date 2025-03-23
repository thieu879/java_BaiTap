package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice,
                   int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        this.profit = calProfit();
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }
    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }
    public float getProfit() { return profit; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getDescriptions() { return descriptions; }
    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (4 ký tự): ");
            String id = scanner.nextLine().trim();
            if (id.length() == 4 && isProductIdUnique(id, arrProduct)) {
                this.productId = id;
                break;
            }
            System.out.println("Mã sản phẩm phải gồm 4 ký tự và không trùng lặp!");
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm (6-50 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() >= 6 && name.length() <= 50 && isProductNameUnique(name, arrProduct)) {
                this.productName = name;
                break;
            }
            System.out.println("Tên sản phẩm phải từ 6-50 ký tự và không trùng lặp!");
        }

        while (true) {
            System.out.print("Nhập giá nhập (>0): ");
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    this.importPrice = price;
                    break;
                }
                System.out.println("Giá nhập phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        while (true) {
            System.out.print("Nhập giá xuất (> " + (importPrice * 1.2) + "): ");
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price >= importPrice * 1.2) {
                    this.exportPrice = price;
                    break;
                }
                System.out.println("Giá xuất phải lớn hơn ít nhất 20% giá nhập!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        while (true) {
            System.out.print("Nhập số lượng (>0): ");
            try {
                int qty = Integer.parseInt(scanner.nextLine());
                if (qty > 0) {
                    this.quantity = qty;
                    break;
                }
                System.out.println("Số lượng phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine().trim();

        while (true) {
            System.out.print("Nhập trạng thái (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                this.status = Boolean.parseBoolean(input);
                break;
            }
            System.out.println("Vui lòng nhập true hoặc false!");
        }
    }

    public void displayData() {
        String statusStr = status ? "Đang bán" : "Không bán";
        System.out.printf("| %-4s | %-20s | %-10.2f | %-10.2f | %-10.2f | %-5d | %-20s | %-10s |\n",
                productId, productName, importPrice, exportPrice, profit, quantity, descriptions, statusStr);
    }

    public float calProfit() {
        return exportPrice - importPrice;
    }

    private boolean isProductIdUnique(String id, Product[] arrProduct) {
        for (Product p : arrProduct) {
            if (p != null && p.getProductId() != null && p.getProductId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    private boolean isProductNameUnique(String name, Product[] arrProduct) {
        for (Product p : arrProduct) {
            if (p != null && p.getProductName() != null && p.getProductName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}