package Bt10;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        super("Hình chữ nhật");
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return super.toString() + ", Chiều rộng: " + width + ", Chiều cao: " + height;
    }
}
