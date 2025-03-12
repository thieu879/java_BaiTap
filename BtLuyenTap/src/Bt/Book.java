package Bt;
import java.util.Scanner;
public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String author;
    private float interest;
    private int year;
    public Book() {
    }
    public Book(String author, String bookId, String bookName, float exportPrice, float importPrice, float interest, String title, int year) {
        this.author = author;
        this.bookId = bookId;
        this.bookName = bookName;
        this.exportPrice = exportPrice;
        this.importPrice = importPrice;
        this.interest = interest;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã sách (5 ký tự, bắt đầu bằng B): ");
            String inputId = scanner.nextLine();
            if (inputId.length() == 5 && inputId.startsWith("B")) {
                this.bookId = inputId;
                break;
            }
            System.out.println("Mã sách không hợp lệ! Phải có 5 ký tự và bắt đầu bằng B");
        }

        while (true) {
            System.out.print("Nhập tên sách (6-100 ký tự): ");
            String inputName = scanner.nextLine();
            if (inputName.length() >= 6 && inputName.length() <= 100) {
                this.bookName = inputName;
                break;
            }
            System.out.println("Tên sách không hợp lệ! Phải từ 6-100 ký tự");
        }

        while (true) {
            System.out.print("Nhập giá nhập (>0): ");
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0) {
                this.importPrice = price;
                break;
            }
            System.out.println("Giá không hợp lệ! Phải lớn hơn 0");
        }

        while (true) {
            System.out.print("Nhập giá bán (> giá nhập + 10%): ");
            float price = Float.parseFloat(scanner.nextLine());
            if (price >= importPrice * 1.1) {
                this.exportPrice = price;
                break;
            }
            System.out.println("Giá bán không hợp lệ! Phải lớn hơn ít nhất 10% giá nhập");
        }

        while (true) {
            System.out.print("Nhập tiêu đề (bắt buộc): ");
            String inputTitle = scanner.nextLine();
            if (!inputTitle.trim().isEmpty()) {
                this.title = inputTitle;
                break;
            }
            System.out.println("Tiêu đề là bắt buộc!");
        }

        while (true) {
            System.out.print("Nhập tác giả (bắt buộc): ");
            String inputAuthor = scanner.nextLine();
            if (!inputAuthor.trim().isEmpty()) {
                this.author = inputAuthor;
                break;
            }
            System.out.println("Tác giả là bắt buộc!");
        }

        while (true) {
            System.out.print("Nhập năm xuất bản (>1970): ");
            int inputYear = Integer.parseInt(scanner.nextLine());
            if (inputYear > 1970) {
                this.year = inputYear;
                break;
            }
            System.out.println("Năm không hợp lệ! Phải sau 1970");
        }
    }

    public void displayData() {
        System.out.printf("Mã sách: %s | Tên: %s | Giá nhập: %.2f | Giá bán: %.2f | " +
                        "Tiêu đề: %s | Tác giả: %s | Lợi nhuận: %.2f | Năm: %d%n",
                bookId, bookName, importPrice, exportPrice, title, author, interest, year);
    }

    public void calInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }
}
