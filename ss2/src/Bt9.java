import java.util.Scanner;
public class Bt9 {
    public static void main(String[] args) {
        System.out.print("Nhập cạnh a: ");
        int a = new Scanner(System.in).nextInt();

        System.out.print("Nhập cạnh b: ");
        int b = new Scanner(System.in).nextInt();

        System.out.print("Nhập cạnh c: ");
        int c = new Scanner(System.in).nextInt();

        // Tính chu vi
        int perimeter = a + b + c;

        // Tính diện tích theo công thức Heron
        double s = perimeter / 2.0;  // Nửa chu vi
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        // Hiển thị kết quả
        System.out.println("\n--- Kết quả ---");
        System.out.println("Chu vi tam giác: " + perimeter);
        System.out.println("Diện tích tam giác: " + area);
    }
}
