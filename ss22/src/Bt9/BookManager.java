package Bt9;

import java.io.*;

public class BookManager {
    private Book[] books;
    private int size;
    private static final int MAX_SIZE = 100; // Giới hạn tối đa số sách
    private static final String FILE_NAME = "books.dat";

    public BookManager() {
        books = new Book[MAX_SIZE];
        size = 0;
        loadBooksFromFile();
    }

    public void addBook(Book book) {
        if (size < MAX_SIZE) {
            books[size] = book;
            size++;
            saveBooksToFile();
        } else {
            System.out.println("Danh sách sách đã đầy!");
        }
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == updatedBook.getId()) {
                books[i] = updatedBook;
                saveBooksToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID: " + updatedBook.getId());
    }

    public void deleteBook(int id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == id) {
                // Dịch chuyển các phần tử sau về trước
                for (int j = i; j < size - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[size - 1] = null;
                size--;
                saveBooksToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID: " + id);
    }

    public void displayAllBooks() {
        if (size == 0) {
            System.out.println("Danh sách sách trống!");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(books[i]);
            }
        }
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            // Chỉ ghi số lượng sách thực tế
            oos.writeInt(size);
            for (int i = 0; i < size; i++) {
                oos.writeObject(books[i]);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                size = ois.readInt();
                for (int i = 0; i < size; i++) {
                    books[i] = (Book) ois.readObject();
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Lỗi khi đọc file: " + e.getMessage());
                size = 0;
            }
        }
    }
}
