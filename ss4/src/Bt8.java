import java.util.Scanner;
public class Bt8 {
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
        System.out.println("Các số Armstrong từ 1 đến " + N + ":");
        for (int i = 1; i <= N; i++) {
            int num = i, sum = 0, digits = 0;
            int temp = num;
            while (temp > 0) {
                temp /= 10;
                digits++;
            }
            temp = num;
            while (temp > 0) {
                int digit = temp % 10;
                int power = 1;

                for (int j = 0; j < digits; j++) {
                    power *= digit;
                }
                sum += power;
                temp /= 10;
            }
            if (sum == num) {
                System.out.print(num + " ");
            }
        }
    }
}
