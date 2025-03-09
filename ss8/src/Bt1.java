import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Nhập kích thước mảng: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Kích thước không hợp lệ, vui lòng nhập lại.");
        }
        int[] arr = new int[n];
        System.out.println("Nhập " + n + " số nguyên:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Giá trị lớn nhất: " + max);
        System.out.println("Giá trị nhỏ nhất: " + min);
    }
}
