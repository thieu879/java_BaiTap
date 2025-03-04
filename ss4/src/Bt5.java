import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        System.out.print("Nhập số nguyên dương N: ");
        int N = new Scanner(System.in).nextInt();
        boolean hasPerfectNumber = false;
        System.out.println("Các số hoàn hảo nhỏ hơn " + N + " là:");
        for (int num = 1; num <= N; num++) {
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            if (sum == num) {
                System.out.print(num + " ");
                hasPerfectNumber = true;
            }
        }
        if (!hasPerfectNumber) {
            System.out.println("Không có số hoàn hảo nào nhỏ hơn " + N);
        }
    }
}
