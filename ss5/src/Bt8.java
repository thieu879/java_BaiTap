import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            if (freq[i] == -1) continue;

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    freq[j] = -1;
                }
            }
            freq[i] = count;
        }
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] == 1) {
                uniqueCount++;
            }
        }

        if (uniqueCount == 0) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
        } else {
            System.out.print("Mảng sau khi loại bỏ phần tử trùng lặp: ");
            for (int i = 0; i < n; i++) {
                if (freq[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }
}
