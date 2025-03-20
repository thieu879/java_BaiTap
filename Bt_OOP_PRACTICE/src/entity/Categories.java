package entity;

import java.util.Scanner;

public class Categories implements IApp{
    private static int idCounter = 1;
    private int categoryId;
    private String name;
    private int priority;
    private String description;
    private boolean status;
    public Categories() {
        this.categoryId = ++idCounter;
    }
    public Categories(String description, String name, int priority, boolean status) {
        this.categoryId = idCounter++;
        this.description = description;
        this.name = name;
        this.priority = priority;
        this.status = status;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên danh mục (6-50 ký tự): ");
        this.name = scanner.nextLine();
        while (this.name.length() < 6 || this.name.length() > 50) {
            System.out.print("Tên danh mục phải từ 6-50 ký tự, nhập lại: ");
            this.name = scanner.nextLine();
        }

        System.out.print("Nhập độ ưu tiên: ");
        this.priority = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập mô tả (tối đa 255 ký tự): ");
        this.description = scanner.nextLine();
        while (this.description.length() > 255) {
            System.out.print("Mô tả tối đa 255 ký tự, nhập lại: ");
            this.description = scanner.nextLine();
        }

        System.out.print("Nhập trạng thái (true/false): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("ID Danh Mục: " + this.categoryId);
        System.out.println("Tên Danh mục: " + this.name);
        System.out.println("Priority: " + this.priority);
        System.out.println("Description: " + this.description);
        System.out.println("Status: " + (status ? "Active" : "Inactive"));
    }
}
