package ra.presentation;

import ra.bussiness.BookBusiness;
import java.util.Scanner;

public class BookApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookBusiness bookBusiness = new BookBusiness();

        while (true) {
            displayMenu();
            int choice = getChoice(sc);

            switch (choice) {
                case 1:
                    bookBusiness.displayAllBooks();
                    break;
                case 2:
                    bookBusiness.addNewBooks(sc);
                    break;
                case 3:
                    bookBusiness.updateBook(sc);
                    break;
                case 4:
                    bookBusiness.deleteBook(sc);
                    break;
                case 5:
                    bookBusiness.searchBooks(sc);
                    break;
                case 6:
                    bookBusiness.sortBooks(sc);
                    break;
                case 0:
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
        System.out.println("----------------------------Book Menu----------------------------");
        System.out.println("1. Hiển thị danh sách các cuốn sách");
        System.out.println("2. Thêm mới sách");
        System.out.println("3. Chỉnh sửa thông tin sách");
        System.out.println("4. Xóa sách");
        System.out.println("5. Tìm kiếm sách");
        System.out.println("6. Sắp xếp");
        System.out.println("0. Thoát chương trình");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static int getChoice(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}