package Bt10;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        super("Hình tam giác");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculatePerimeter() {
        return a + b + c;
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return super.toString() + ", Cạnh a: " + a + ", Cạnh b: " + b + ", Cạnh c: " + c;
    }
}