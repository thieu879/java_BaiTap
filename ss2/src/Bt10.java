import java.math.BigInteger;
import java.util.Scanner;
public class Bt10 {
    public static void main(String[] args) {
        System.out.print("Nhập số nguyên lớn a: ");
        BigInteger a = new BigInteger(new Scanner(System.in).nextLine());

        System.out.print("Nhập số nguyên lớn b: ");
        BigInteger b = new BigInteger(new Scanner(System.in).nextLine());

        // Thực hiện các phép toán
        BigInteger sum = a.add(b);
        BigInteger difference = a.subtract(b);
        BigInteger product = a.multiply(b);
        BigInteger quotient = a.divide(b);
        BigInteger remainder = a.mod(b);
        BigInteger power = a.pow(10);

        // Hiển thị kết quả
        System.out.println("\n--- Kết quả ---");
        System.out.println("Tổng: " + sum);
        System.out.println("Hiệu: " + difference);
        System.out.println("Tích: " + product);
        System.out.println("Thương: " + quotient);
        System.out.println("Số dư: " + remainder);
        System.out.println("Lũy thừa bậc 10 của a: " + power);
    }
}
