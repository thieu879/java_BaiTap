package Bt5;
public class Cylinder extends Circle {
    private double height;
    public double getHeight() {
        return height;
    }
    public void setHeight(double radius, double height) {
        super.setRadius(radius);
        this.height = height;
    }
    public double getVolume(){
        return Math.PI*height*getRadius()*getRadius();
    }
}
