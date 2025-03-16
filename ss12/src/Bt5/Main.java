package Bt5;

public class Main {
    public static void main(String[] args) {
        // Tạo mảng chứa các đối tượng Shape
        Shape[] shapes = new Shape[] {
                new Circle(5),
                new Rectangle(4, 6),
                new Square(3)
        };
        for (Shape shape : shapes) {
            System.out.println("Diện tích: " + shape.area());
        }
    }
}
