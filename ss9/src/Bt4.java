public class Bt4 {
    private double radius;

    public Bt4() {
        this.radius = 1.0;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getPerimeter(){
        return 2*Math.PI * radius;
    }
    public void display(){
        System.out.println("bán kính: " + radius);
        System.out.println("diện tích của hình tròn: "+getArea());
        System.out.println("chu vi của hình tròn: "+getPerimeter());
    }
    public static void main(String[] args) {
        Bt4 circle = new Bt4();
        circle.display();
    }
}
