import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        System.out.print("Nhập kích thước mảng: ");
        int n = new Scanner(System.in).nextInt();

        if (n <= 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + ": ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        int e = 0, o = 0;
        for (int num : arr) {
            if (num % 2 == 0) e++;
            else o++;
        }
        int[] evenArr = new int[e];
        int[] oddArr = new int[o];
        int evenIndex = 0, oddIndex = 0;
        for (int num : arr) {
            if (num % 2 == 0) evenArr[evenIndex++] = num;
            else oddArr[oddIndex++] = num;
        }
        int index = 0;
        for (int num : evenArr) arr[index++] = num;
        for (int num : oddArr) arr[index++] = num;
        System.out.print("Mảng sau khi sắp xếp: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
