package Bt5;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private static final ArrayList<String> products = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showAllProducts();
                case 3 -> findProduct();
                case 4 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nProduct Management System:");
        System.out.println("1. Add Product");
        System.out.println("2. Show All Products");
        System.out.println("3. Find Product");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String product = sc.nextLine();
        products.add(product);
        System.out.println("Product added successfully!");
    }

    private static void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product List:");
            for (String product : products) {
                System.out.println("- " + product);
            }
        }
    }

    private static void findProduct() {
        System.out.print("Enter product name to find: ");
        String name = sc.nextLine();
        for (String product : products) {
            if (product.equalsIgnoreCase(name)) {
                System.out.println("Product found: " + product);
                return;
            }
        }
        System.out.println("Product not found.");
    }
}

