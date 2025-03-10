import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] temp = new int[n];
        int evenIndex = 0, oddIndex = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenIndex++;
            }
        }

        oddIndex = evenIndex;
        evenIndex = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                temp[evenIndex++] = num;
            } else {
                temp[oddIndex++] = num;
            }
        }

        System.arraycopy(temp, 0, arr, 0, n);

        System.out.println("Mảng sau khi sắp xếp: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}