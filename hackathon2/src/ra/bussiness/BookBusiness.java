package ra.bussiness;

import ra.entity.Book;
import ra.validate.Validate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookBusiness {
    private List<Book> books = new ArrayList<>();
    private static final int MAX_BOOKS = 100;

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        printHeader();
        books.forEach(Book::displayData);
    }

    public void addNewBooks(Scanner sc) {
        if (books.size() >= MAX_BOOKS) {
            System.out.println("Danh sách đã đầy, không thể thêm mới!");
            return;
        }

        System.out.print("Nhập số lượng sách cần thêm: ");
        int number = Validate.validateInt(sc, "Số lượng sách", 0);
        if (books.size() + number > MAX_BOOKS) {
            System.out.println("Không đủ chỗ để thêm " + number + " sách!");
            return;
        }

        for (int i = 0; i < number; i++) {
            System.out.println("\nNhập thông tin sách thứ " + (i + 1) + ":");
            Book book = new Book();
            book.inputData(sc);
            books.add(book);
        }
        System.out.println("Thêm mới thành công!");
    }

    public void updateBook(Scanner sc) {
        System.out.print("Nhập mã sách cần chỉnh sửa: ");
        String bookId = sc.nextLine().trim();
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Không tìm thấy sách!");
            return;
        }

        System.out.println("Thông tin sách hiện tại:");
        printHeader();
        book.displayData();

        while (true) {
            System.out.println("\nChọn thuộc tính cần sửa:");
            System.out.println("1. Tiêu đề");
            System.out.println("2. Tác giả");
            System.out.println("3. Nhà xuất bản");
            System.out.println("4. Năm xuất bản");
            System.out.println("5. Thể loại");
            System.out.println("6. Giá");
            System.out.println("7. Số lượng");
            System.out.println("0. Hoàn tất chỉnh sửa");
            System.out.print("Lựa chọn của bạn: ");

            int choice = getChoice(sc);
            switch (choice) {
                case 1:
                    System.out.print("Nhập tiêu đề mới: ");
                    book.setBookTitle(Validate.validateString(sc, "Tiêu đề", 100));
                    break;
                case 2:
                    System.out.print("Nhập tác giả mới: ");
                    book.setAuthor(Validate.validateString(sc, "Tác giả", 50));
                    break;
                case 3:
                    System.out.print("Nhập nhà xuất bản mới: ");
                    book.setPublisher(Validate.validateString(sc, "Nhà xuất bản", 100));
                    break;
                case 4:
                    System.out.print("Nhập năm xuất bản mới: ");
                    book.setPublicationYear(Validate.validateInt(sc, "Năm xuất bản", 0));
                    break;
                case 5:
                    System.out.print("Nhập thể loại mới: ");
                    book.setCategory(Validate.validateString(sc, "Thể loại", 100));
                    break;
                case 6:
                    System.out.print("Nhập giá mới: ");
                    book.setPrice(Validate.validateDouble(sc, "Giá", 0));
                    break;
                case 7:
                    System.out.print("Nhập số lượng mới: ");
                    book.setQuantity(Validate.validateInt(sc, "Số lượng", 0));
                    break;
                case 0:
                    System.out.println("Chỉnh sửa thành công!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void deleteBook(Scanner sc) {
        System.out.print("Nhập mã sách cần xóa: ");
        String bookId = sc.nextLine().trim();
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Không tìm thấy sách!");
            return;
        }

        System.out.println("Thông tin sách cần xóa:");
        printHeader();
        book.displayData();

        System.out.print("Bạn có chắc chắn muốn xóa sách này? (Y/N): ");
        String confirm = sc.nextLine().trim().toUpperCase();
        if (confirm.equals("Y")) {
            books.remove(book);
            System.out.println("Xóa sách thành công!");
        } else {
            System.out.println("Đã hủy thao tác xóa!");
        }
    }

    public void searchBooks(Scanner sc) {
        System.out.println("\nChọn tiêu chí tìm kiếm:");
        System.out.println("1. Tìm kiếm theo tiêu đề");
        System.out.println("2. Tìm kiếm theo thể loại");
        System.out.println("3. Tìm kiếm theo khoảng giá");
        System.out.print("Lựa chọn của bạn: ");

        int choice = getChoice(sc);
        List<Book> results = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.print("Nhập tiêu đề cần tìm: ");
                String title = sc.nextLine().trim().toLowerCase();
                results = books.stream()
                        .filter(b -> b.getBookTitle().toLowerCase().contains(title))
                        .toList();
                break;
            case 2:
                System.out.print("Nhập thể loại cần tìm: ");
                String category = sc.nextLine().trim().toLowerCase();
                results = books.stream()
                        .filter(b -> b.getCategory().toLowerCase().contains(category))
                        .toList();
                break;
            case 3:
                System.out.print("Nhập giá tối thiểu: ");
                double minPrice = Validate.validateDouble(sc, "Giá tối thiểu", 0);
                System.out.print("Nhập giá tối đa: ");
                double maxPrice = Validate.validateDouble(sc, "Giá tối đa", minPrice);
                results = books.stream()
                        .filter(b -> b.getPrice() >= minPrice && b.getPrice() <= maxPrice)
                        .toList();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        displaySearchResults(results);
    }

    public void sortBooks(Scanner sc) {
        System.out.println("\nChọn tiêu chí sắp xếp:");
        System.out.println("1. Sắp xếp theo tiêu đề tăng dần");
        System.out.println("2. Sắp xếp theo tiêu đề giảm dần");
        System.out.println("3. Sắp xếp theo giá tăng dần");
        System.out.println("4. Sắp xếp theo giá giảm dần");
        System.out.print("Lựa chọn của bạn: ");

        int choice = getChoice(sc);
        switch (choice) {
            case 1:
                Collections.sort(books, Comparator.comparing(Book::getBookTitle));
                break;
            case 2:
                Collections.sort(books, Comparator.comparing(Book::getBookTitle).reversed());
                break;
            case 3:
                Collections.sort(books, Comparator.comparingDouble(Book::getPrice));
                break;
            case 4:
                Collections.sort(books, Comparator.comparingDouble(Book::getPrice).reversed());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        System.out.println("Danh sách sau khi sắp xếp:");
        displayAllBooks();
    }

    private Book findBookById(String bookId) {
        return books.stream()
                .filter(b -> b.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    private void printHeader() {
        System.out.println("| Mã sách | Tiêu đề             | Tác giả        | Nhà xuất bản         | Năm XB | Thể loại       | Giá       | Số lượng |");
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    private void displaySearchResults(List<Book> results) {
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy kết quả phù hợp!");
            return;
        }
        printHeader();
        results.forEach(Book::displayData);
    }

    private int getChoice(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}