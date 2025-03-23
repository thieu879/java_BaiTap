package Bt9;
import java.util.*;
public class BookCollectionManager {
    private Set<Book> bookCollection;

    public BookCollectionManager() {
        bookCollection = new HashSet<>();
    }
    public boolean addBook(Book book) {
        return bookCollection.add(book);
    }
    public List<Book> filterBooksByYear(int year) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book.getYear() > year) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
    public void sortBooksByTitle(List<Book> books) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
    }

    public static void main(String[] args) {
        BookCollectionManager manager = new BookCollectionManager();

        manager.addBook(new Book("B001", "Java Programming", "John Smith", 2020));
        manager.addBook(new Book("B002", "Python Basics", "Jane Doe", 2018));
        manager.addBook(new Book("B003", "Algorithms", "Alan Turing", 2022));
        manager.addBook(new Book("B004", "Data Structures", "Ada Lovelace", 2019));
        boolean isAdded = manager.addBook(new Book("B001", "Duplicate", "Test", 2023));
        System.out.println("Thêm sách trùng ID: " + (isAdded ? "Thành công" : "Thất bại"));

        int filterYear = 2019;
        List<Book> filteredBooks = manager.filterBooksByYear(filterYear);

        manager.sortBooksByTitle(filteredBooks);

        System.out.println("\nDanh sách sách xuất bản sau năm " + filterYear + ":");
        if (filteredBooks.isEmpty()) {
            System.out.println("Không có sách nào phù hợp.");
        } else {
            for (Book book : filteredBooks) {
                System.out.println(book);
            }
            System.out.println("Tổng số sách: " + filteredBooks.size());
        }
    }
}
