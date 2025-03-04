import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        int N;
        while (true) {
            System.out.print("Nhập một số nguyên dương N: ");
            N = new Scanner(System.in).nextInt();
            if (N > 0) {
                break;
            }else {
                System.out.println("Số nhập vào không hợp lệ, vui lòng nhập lại.");
            }
        }
        System.out.println("Các số Palindrome từ 1 đến " + N + ":");
        for (int i = 1; i <= N; i++) {
            int num = i, reversed = 0, temp = num;
            while (temp > 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }
            if (num == reversed) {
                System.out.print(num + " ");
            }
        }
    }
}
