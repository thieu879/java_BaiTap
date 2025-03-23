package ra.entity;

import ra.validate.Validate;
import java.util.Scanner;

public class Book implements IApp {
    private String bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;

    private static int counter = 0;

    // Constructors
    public Book() {
        this.bookId = generateBookId();
    }

    public Book(String bookTitle, String author, String publisher, int publicationYear,
                String category, double price, int quantity) {
        this.bookId = generateBookId();
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getBookId() { return bookId; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    private String generateBookId() {
        counter++;
        return String.format("B%05d", counter);
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nhập tiêu đề sách: ");
        this.bookTitle = Validate.validateString(sc, "Tiêu đề sách", 100);
        System.out.print("Nhập tác giả: ");
        this.author = Validate.validateString(sc, "Tác giả", 50);
        System.out.print("Nhập nhà xuất bản: ");
        this.publisher = Validate.validateString(sc, "Nhà xuất bản", 100);
        System.out.print("Nhập năm xuất bản: ");
        this.publicationYear = Validate.validateInt(sc, "Năm xuất bản", 0);
        System.out.print("Nhập thể loại: ");
        this.category = Validate.validateString(sc, "Thể loại", 100);
        System.out.print("Nhập giá sách: ");
        this.price = Validate.validateDouble(sc, "Giá sách", 0);
        System.out.print("Nhập số lượng: ");
        this.quantity = Validate.validateInt(sc, "Số lượng", 0);
    }

    @Override
    public void displayData() {
        System.out.printf("| %-6s | %-20s | %-15s | %-20s | %-4d | %-15s | %-10.2f | %-8d |\n",
                bookId, bookTitle, author, publisher, publicationYear, category, price, quantity);
    }
}