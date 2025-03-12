package Bt;
import Bt.Book;
import java.util.Scanner;
public class Main {
    private static Book[] books = new Book[100];
    private static int bookCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************************MENU*************************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Tính lợi nhuận của các sách");
            System.out.println("4. Cập nhật sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá");
            System.out.println("9. Thống kê sách theo mỗi tác giả");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    calculateInterests();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    sortBooksByInterest();
                    break;
                case 7:
                    searchByAuthor();
                    break;
                case 8:
                    searchByPriceRange();
                    break;
                case 9:
                    statisticByAuthor();
                    break;
                case 10:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn 1-10");
            }
        }
    }

    private static void listBooks() {
        if (bookCount == 0) {
            System.out.println("Không có sách nào!");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            books[i].displayData();
        }
    }

    private static void addBook() {
        if (bookCount >= books.length) {
            System.out.println("Danh sách sách đã đầy!");
            return;
        }
        Book book = new Book();
        book.inputData(scanner);
        books[bookCount] = book;
        bookCount++;
        System.out.println("Thêm sách thành công!");
    }

    private static void calculateInterests() {
        if (bookCount == 0) {
            System.out.println("Không có sách nào!");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            books[i].calInterest();
            books[i].displayData();
        }
    }

    private static void updateBook() {
        System.out.print("Nhập mã sách để cập nhật: ");
        String id = scanner.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId().equals(id)) {
                books[i].inputData(scanner);
                System.out.println("Cập nhật sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách!");
    }

    private static void deleteBook() {
        System.out.print("Nhập mã sách để xóa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId().equals(id)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("Xóa sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách!");
    }

    private static void sortBooksByInterest() {
        if (bookCount == 0) {
            System.out.println("Không có sách nào!");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            books[i].calInterest();
        }
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = 0; j < bookCount - i - 1; j++) {
                if (books[j].getInterest() > books[j + 1].getInterest()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
        listBooks();
    }

    private static void searchByAuthor() {
        System.out.print("Nhập tên tác giả để tìm: ");
        String author = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getAuthor().toLowerCase().contains(author)) {
                books[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách nào của tác giả này!");
        }
    }

    private static void searchByPriceRange() {
        System.out.print("Nhập giá tối thiểu: ");
        float min = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá tối đa: ");
        float max = Float.parseFloat(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            float price = books[i].getExportPrice();
            if (price >= min && price <= max) {
                books[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách trong khoảng giá này!");
        }
    }

    private static void statisticByAuthor() {
        if (bookCount == 0) {
            System.out.println("Không có sách nào!");
            return;
        }
        String[] authors = new String[bookCount];
        int[] counts = new int[bookCount];
        int uniqueAuthorCount = 0;

        for (int i = 0; i < bookCount; i++) {
            String currentAuthor = books[i].getAuthor();
            boolean authorExists = false;

            for (int j = 0; j < uniqueAuthorCount; j++) {
                if (authors[j].equals(currentAuthor)) {
                    counts[j]++;
                    authorExists = true;
                    break;
                }
            }

            if (!authorExists) {
                authors[uniqueAuthorCount] = currentAuthor;
                counts[uniqueAuthorCount] = 1;
                uniqueAuthorCount++;
            }
        }

        for (int i = 0; i < uniqueAuthorCount; i++) {
            System.out.println("Tác giả: " + authors[i] + " - " + counts[i] + " cuốn sách");
        }
    }
}