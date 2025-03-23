package ra.run;

import ra.entity.Book;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookImp {
    private static Book[] books = new Book[100];
    private static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getChoice(sc);

            switch (choice) {
                case 1:
                    inputBooks(sc);
                    break;
                case 2:
                    calculateAllInterests();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortByExportPrice();
                    break;
                case 5:
                    sortByInterest();
                    break;
                case 6:
                    searchByBookName(sc);
                    break;
                case 7:
                    statisticByYear();
                    break;
                case 8:
                    statisticByAuthor();
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println("\nNhấn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("*********************MENU******************");
        System.out.println("1. Nhập thông tin n sách");
        System.out.println("2. Tính lợi nhuận các sách");
        System.out.println("3. Hiển thị thông tin sách");
        System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
        System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
        System.out.println("6. Tìm sách theo tên sách");
        System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
        System.out.println("8. Thống kê số lượng sách theo tác giả");
        System.out.println("9. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static int getChoice(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void inputBooks(Scanner sc) {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0 || currentIndex + n > books.length) {
                System.out.println("Số lượng không hợp lệ hoặc vượt quá giới hạn!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sách thứ " + (i + 1) + ":");
            books[currentIndex] = new Book();
            books[currentIndex].inputData(sc, books, currentIndex);
            currentIndex++;
        }
        System.out.println("Thêm sách thành công!");
    }

    private static void calculateAllInterests() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            books[i].calculateInterest();
        }
        System.out.println("Đã tính lợi nhuận cho tất cả sách!");
    }

    private static void displayBooks() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        printHeader();
        for (int i = 0; i < currentIndex; i++) {
            books[i].displayData();
        }
    }

    private static void sortByExportPrice() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        Arrays.sort(books, 0, currentIndex, Comparator.comparingDouble(Book::getExportPrice));
        System.out.println("Đã sắp xếp theo giá bán tăng dần!");
        displayBooks();
    }

    private static void sortByInterest() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        Arrays.sort(books, 0, currentIndex,
                Comparator.comparingDouble(Book::getInterest).reversed());
        System.out.println("Đã sắp xếp theo lợi nhuận giảm dần!");
        displayBooks();
    }

    private static void searchByBookName(Scanner sc) {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        System.out.print("Nhập tên sách cần tìm: ");
        String searchName = sc.nextLine().trim();
        boolean found = false;

        printHeader();
        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getBookName().equalsIgnoreCase(searchName)) {
                books[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + searchName);
        }
    }

    private static void statisticByYear() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        Map<Integer, Integer> yearStats = new HashMap<>();
        for (int i = 0; i < currentIndex; i++) {
            yearStats.put(books[i].getYear(),
                    yearStats.getOrDefault(books[i].getYear(), 0) + 1);
        }
        System.out.println("Thống kê số lượng sách theo năm:");
        yearStats.forEach((year, count) ->
                System.out.println("Năm " + year + ": " + count + " sách"));
    }

    private static void statisticByAuthor() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        Map<String, Integer> authorStats = new HashMap<>();
        for (int i = 0; i < currentIndex; i++) {
            authorStats.put(books[i].getAuthor(),
                    authorStats.getOrDefault(books[i].getAuthor(), 0) + 1);
        }
        System.out.println("Thống kê số lượng sách theo tác giả:");
        authorStats.forEach((author, count) ->
                System.out.println("Tác giả " + author + ": " + count + " sách"));
    }

    private static void printHeader() {
        System.out.println("| Mã sách  | Tên  | Giá nhập    | Giá xuất    | Tác giả             | Lợi nhuận   | Năm |");
        System.out.println("---------------------------------------------------------------------------------");
    }
}