package Bt5;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1.2);
        Rectangle rectangle = new Rectangle(1.2, 1.2);
        Square square = new Square(1.2);

        circle.setColor("blue");
        rectangle.setColor("red");
        square.setColor("green");

        System.out.println(circle.getColor());
        System.out.println(rectangle.getColor());
        System.out.println(square.getColor());
    }
}
