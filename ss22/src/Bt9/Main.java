package Bt9;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();

        // Thêm sách
        Book book1 = new Book(1, "Lập trình Java", "Nguyễn Văn A", "NXB Giáo dục", 150000);
        Book book2 = new Book(2, "Cấu trúc dữ liệu", "Trần Thị B", "NXB Khoa học", 200000);
        manager.addBook(book1);
        manager.addBook(book2);

        System.out.println("Danh sách sách sau khi thêm:");
        manager.displayAllBooks();

        // Cập nhật sách
        Book updatedBook = new Book(1, "Lập trình Java Nâng cao", "Nguyễn Văn A", "NXB Giáo dục", 180000);
        manager.updateBook(updatedBook);

        System.out.println("\nDanh sách sách sau khi cập nhật:");
        manager.displayAllBooks();

        // Xóa sách
        manager.deleteBook(2);

        System.out.println("\nDanh sách sách sau khi xóa:");
        manager.displayAllBooks();
    }
}