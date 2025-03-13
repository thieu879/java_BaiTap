package Bt5;

public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Cylinder cylinder = new Cylinder();

        circle.setRadius(10);
        cylinder.setHeight(10,10);

        System.out.println(circle.getArea());
        System.out.println(cylinder.getVolume());
    }
}
