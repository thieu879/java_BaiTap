public class Bt5 {
    private double x;
    private double y;
    public Bt5(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y);
    }
    public Bt5 add(Bt5 v) {
        return new Bt5(this.x + v.x, this.y + v.y);
    }
    public Bt5 subtract(Bt5 v) {
        return new Bt5(this.x - v.x, this.y - v.y);
    }
    public double dotProduct(Bt5 v) {
        return this.x * v.x + this.y * v.y;
    }
    public void displayVector() {
        System.out.println("Vector: (" + x + ", " + y + ")");
    }
    public static void main(String[] args) {
        Bt5 v1 = new Bt5(3, 4);
        Bt5 v2 = new Bt5(1, 2);
        System.out.println("Vector v1:");
        v1.displayVector();
        System.out.println("Vector v2:");
        v2.displayVector();
        System.out.println("Độ dài v1: " + v1.calculateMagnitude());
        System.out.println("Độ dài v2: " + v2.calculateMagnitude());
        Bt5 sum = v1.add(v2);
        Bt5 diff = v1.subtract(v2);
        System.out.println("Tổng v1 + v2:");
        sum.displayVector();
        System.out.println("Hiệu v1 - v2:");
        diff.displayVector();
        System.out.println("Tích vô hướng v1 . v2: " + v1.dotProduct(v2));
    }
}
