import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        System.out.print("Nhập hệ số a: ");
        double a = new Scanner(System.in).nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = new Scanner(System.in).nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = new Scanner(System.in).nextDouble();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình có vô số nghiệm.");
                } else {
                    System.out.println("Phương trình vô nghiệm.");
                }
            } else {
                double x = -c / b;
                System.out.println("Phương trình có một nghiệm: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phương trình có hai nghiệm phân biệt:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Phương trình có nghiệm kép: x = " + x);
            } else {
                System.out.println("Phương trình vô nghiệm (không có nghiệm thực).");
            }
        }
    }
}
