package Bt6;

public class MoveablePoint extends Point {
    private double xSpeed;
    private double ySpeed;

    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void move(){
        setX(xSpeed+getX());
        setY(ySpeed+getY());
    }
    public String toString(){
        return "("+getX()+", "+getY()+")";
    }
}
