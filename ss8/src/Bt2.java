import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Nhập kích thước mảng (số nguyên dương): ");
        n = scanner.nextInt();

        while (n <= 0) {
            System.out.println("Kích thước không hợp lệ, vui lòng nhập lại.");
            System.out.print("Nhập kích thước mảng (số nguyên dương): ");
            n = scanner.nextInt();
        }
        int[] arr = new int[n];
        System.out.println("Nhập " + n + " số nguyên:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        boolean hasDivisibleBy3 = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0) {
                sum = sum + arr[i];
                hasDivisibleBy3 = true;
            }
        }
        if (hasDivisibleBy3) {
            System.out.println("Tổng các số chia hết cho 3: " + sum);
        } else {
            System.out.println("Không có số chia hết cho 3.");
        }
    }
}
