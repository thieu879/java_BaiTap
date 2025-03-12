package Bt4;

public class Book {
    private String title;
    private String author;
    private int price;
    public Book(String author, int price, String title) {
        this.author = author;
        this.price = price;
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        if (price < 0){
            System.out.println("m đùa t à");
        }else {
            this.price = price;
            System.out.println("Giá sau khi thay đổi:  " + this.price);
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public static void main(String[] args) {
        Book book = new Book("Nguyen Van A", 25, "sách 1");
        System.out.println("Giá ban đầu: " + book.getPrice());
        book.setPrice(200);
    }
}
