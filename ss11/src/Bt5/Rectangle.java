package Bt5;

public class Rectangle implements Colorable{
    private double width;
    private double length;
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
