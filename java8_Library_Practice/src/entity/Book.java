package entity;

import java.util.Scanner;

public class Book implements IApp {
    private String Id;
    private String Name;
    private String Author;
    private int quantity;

    public Book(String author, String id, String name, int quantity) {
        Author = author;
        Id = id;
        Name = name;
        this.quantity = quantity;
    }
    public Book() {}

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void inputData(Scanner scanner) {


        System.out.println("Nhập tên tác giả: ");
        String author = scanner.next();
        System.out.println("Nhập số lượng sách: ");
        int quantity = scanner.nextInt();
    }
    @Override
    public String toString() {
        return "ID:  " + Id + ", Name: " + Name + ", Author: " + Author + ", Quantity: " + quantity;
    }
}
