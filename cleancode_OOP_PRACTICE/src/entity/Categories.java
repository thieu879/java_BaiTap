package entity;

import java.util.Scanner;

public class Categories implements IApp {
    private static int idCounter = 0;
    private static final int MIN_NAME_LENGTH = 6;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_DESCRIPTION_LENGTH = 255;

    private final int categoryId;
    private String name;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {
        this.categoryId = ++idCounter;
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

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Categories.idCounter = idCounter;
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

    public Categories(String description, String name, int priority, boolean status) {
        this.categoryId = ++idCounter;
        this.description = description;
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    // Getters and Setters (giữ nguyên)

    @Override
    public void inputData(Scanner scanner) {
        this.name = inputString(scanner, "Nhập tên danh mục (" + MIN_NAME_LENGTH + "-" + MAX_NAME_LENGTH + " ký tự): ",
                MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        System.out.print("Nhập độ ưu tiên: ");
        this.priority = Integer.parseInt(scanner.nextLine());
        this.description = inputString(scanner, "Nhập mô tả (tối đa " + MAX_DESCRIPTION_LENGTH + " ký tự): ",
                0, MAX_DESCRIPTION_LENGTH);
        System.out.print("Nhập trạng thái (true/false): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("ID Danh Mục: " + categoryId);
        System.out.println("Tên Danh mục: " + name);
        System.out.println("Priority: " + priority);
        System.out.println("Description: " + description);
        System.out.println("Status: " + (status ? "Active" : "Inactive"));
    }

    private String inputString(Scanner scanner, String prompt, int minLength, int maxLength) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.length() < minLength || input.length() > maxLength) {
                System.out.println("Độ dài phải từ " + minLength + " đến " + maxLength + " ký tự, nhập lại!");
            }
        } while (input.length() < minLength || input.length() > maxLength);
        return input;
    }
}