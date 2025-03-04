import java.util.Scanner;

public class Bt10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();
        System.out.print("Nhập hệ số d: ");
        double d = scanner.nextDouble();
        if (a == 0) {
                    solveQuadratic(b, c, d);
        } else {
            solveCubic(a, b, c, d);
        }
        scanner.close();
    }
    private static void solveQuadratic(double b, double c, double d) {
        if (b == 0) {
            if (c == 0) {
                System.out.println(d == 0 ? "Phương trình có vô số nghiệm" : "Phương trình vô nghiệm");
            } else {
                System.out.println("Nghiệm của phương trình: x = " + (-d / c));
            }
        } else {
            double delta = c * c - 4 * b * d;
            if (delta > 0) {
                double x1 = (-c + Math.sqrt(delta)) / (2 * b);
                double x2 = (-c - Math.sqrt(delta)) / (2 * b);
                System.out.println("Nghiệm của phương trình: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                System.out.println("Nghiệm kép: x = " + (-c / (2 * b)));
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
    private static void solveCubic(double a, double b, double c, double d) {
        double delta0 = b * b - 3 * a * c;
        double delta1 = 2 * b * b * b - 9 * a * b * c + 27 * a * a * d;
        double discriminant = delta1 * delta1 - 4 * delta0 * delta0 * delta0;

        if (discriminant > 0) {
            double C = Math.cbrt((delta1 + Math.sqrt(discriminant)) / 2);
            double x1 = -1 / (3 * a) * (b + C + delta0 / C);
            System.out.println("Phương trình có một nghiệm thực: x = " + x1);
        } else if (discriminant == 0) {
            double x1 = -b / (3 * a);
            double x2 = -b / (3 * a) + Math.cbrt(d / a);
            System.out.println("Phương trình có nghiệm kép: x1 = " + x1 + ", x2 = " + x2);
        } else {
            double theta = Math.acos(delta1 / (2 * Math.sqrt(delta0 * delta0 * delta0)));
            double x1 = -2 * Math.sqrt(delta0) * Math.cos(theta / 3) / (3 * a) - b / (3 * a);
            double x2 = -2 * Math.sqrt(delta0) * Math.cos((theta + 2 * Math.PI) / 3) / (3 * a) - b / (3 * a);
            double x3 = -2 * Math.sqrt(delta0) * Math.cos((theta + 4 * Math.PI) / 3) / (3 * a) - b / (3 * a);
            System.out.println("Phương trình có ba nghiệm thực: x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
        }
    }
}
