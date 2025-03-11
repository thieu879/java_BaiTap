public class Bt3 {
    private double length;
    private double width;

    public Bt3() {
        this.length = 1.0;
        this.width = 1.0;
    }
    public  double getArea(){
        return length*width;
    }
    public  double getPerimeter(){
        return 2*(length+width);
    }
    public void display(){
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("diện tích của hình chữ nhật: "+getArea());
        System.out.println("chu vi của hình chữ nhật: "+getPerimeter());
    }
    public static void main(String[] args) {
        Bt3 rec = new Bt3();
        rec.display();
    }
}
