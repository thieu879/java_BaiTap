package ra.entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice,
                String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.year = year;
        this.interest = calculateInterest();
    }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }
    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }
    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public float getInterest() { return interest; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public void inputData(Scanner sc, Book[] books, int currentIndex) {
        while (true) {
            System.out.print("Nhập mã sách: ");
            String id = sc.nextLine().trim();
            if (isBookIdUnique(id, books, currentIndex)) {
                this.bookId = id;
                break;
            }
            System.out.println("Mã sách đã tồn tại!");
        }

        while (true) {
            System.out.print("Nhập tên sách (4 ký tự, bắt đầu bằng B): ");
            String name = sc.nextLine().trim();
            if (name.length() == 4 && name.startsWith("B") &&
                    isBookNameUnique(name, books, currentIndex)) {
                this.bookName = name;
                break;
            }
            System.out.println("Tên sách phải 4 ký tự, bắt đầu bằng B và không trùng lặp!");
        }

        while (true) {
            System.out.print("Nhập giá nhập (>0): ");
            try {
                float price = Float.parseFloat(sc.nextLine());
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
            System.out.print("Nhập giá xuất (> " + (importPrice * 1.3) + "): ");
            try {
                float price = Float.parseFloat(sc.nextLine());
                if (price >= importPrice * 1.3) {
                    this.exportPrice = price;
                    break;
                }
                System.out.println("Giá xuất phải lớn hơn ít nhất 30% giá nhập!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        while (true) {
            System.out.print("Nhập tên tác giả (6-50 ký tự): ");
            String authorName = sc.nextLine().trim();
            if (authorName.length() >= 6 && authorName.length() <= 50) {
                this.author = authorName;
                break;
            }
            System.out.println("Tên tác giả phải từ 6-50 ký tự!");
        }

        while (true) {
            System.out.print("Nhập năm xuất bản (>=2000): ");
            try {
                int yearInput = Integer.parseInt(sc.nextLine());
                if (yearInput >= 2000) {
                    this.year = yearInput;
                    break;
                }
                System.out.println("Năm xuất bản phải từ 2000 trở lên!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public void displayData() {
        System.out.printf("| %-8s | %-4s | %-12.2f | %-12.2f | %-20s | %-12.2f | %-4d |\n",
                bookId, bookName, importPrice, exportPrice, author, interest, year);
    }

    public float calculateInterest() {
        return exportPrice - importPrice;
    }

    private boolean isBookIdUnique(String id, Book[] books, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getBookId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBookNameUnique(String name, Book[] books, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getBookName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}