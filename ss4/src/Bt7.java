import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        System.out.print("Nhập một số nguyên dương N: ");
        int N = new Scanner(System.in).nextInt();
        System.out.println("Các số Happy từ 1 đến " + N + ":");
        for (int i = 1; i <= N; i++) {
            int num = i;
            int slow = num, fast = num;
            do {
                int sum = 0;
                while (slow > 0) {
                    int digit = slow % 10;
                    sum += digit * digit;
                    slow /= 10;
                }
                slow = sum;
                sum = 0;
                int temp = fast;
                while (temp > 0) {
                    int digit = temp % 10;
                    sum += digit * digit;
                    temp /= 10;
                }
                temp = sum;
                sum = 0;
                while (temp > 0) {
                    int digit = temp % 10;
                    sum += digit * digit;
                    temp /= 10;
                }
                fast = sum;
            } while (slow != fast && fast != 1);
            if (fast == 1) {
                System.out.print(i + " ");
            }
        }
    }
}
