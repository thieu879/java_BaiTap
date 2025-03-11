public class Bt6 {
    private double x;
    private double y;
    public Bt6(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double distanceTo(Bt6 p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public void displayPoint() {
        System.out.println("Điểm: (" + this.x + ", " + this.y + ")");
    }

    public static void main(String[] args) {
        Bt6 p1 = new Bt6(3, 4);
        Bt6 p2 = new Bt6(6, 8);
        System.out.println("Điểm p1:");
        p1.displayPoint();
        System.out.println("Điểm p2:");
        p2.displayPoint();
        double distance = p1.distanceTo(p2);
        System.out.printf("Khoảng cách giữa p1 và p2: %.2f%n", distance);
        p1.setX(5);
        p1.setY(7);
        System.out.println("Tọa độ mới của p1:");
        p1.displayPoint();
    }
}