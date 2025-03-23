package Bt9;
import java.util.*;
class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }

    // Override equals và hashCode dựa trên id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title +
                ", Author: " + author + ", Year: " + year;
    }
}
