public class Bt7 {
    private double a;
    private double b;
    private double c;
    public Bt7(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }
    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }
    public double getRoot1() {
        if (!hasRealRoots()) return Double.NaN;
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }
    public double getRoot2() {
        if (!hasRealRoots()) return Double.NaN;
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }
    public void display() {
        if (!hasRealRoots()) {
            System.out.println("Phương trình không có nghiệm thực.");
        } else if (getDiscriminant() == 0) {
            System.out.printf("Phương trình có nghiệm kép: x = %.2f%n", getRoot1());
        } else {
            System.out.printf("Phương trình có hai nghiệm phân biệt: x1 = %.2f, x2 = %.2f%n", getRoot1(), getRoot2());
        }
    }
    public static void main(String[] args) {
        Bt7 equation = new Bt7(1, -3, 2);
        equation.display();
    }
}