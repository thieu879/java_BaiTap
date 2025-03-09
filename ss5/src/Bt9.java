import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        System.out.print("Nhập kích thước ma trận n: ");
        int n = new Scanner(System.in).nextInt();
        int [][] arr = new int[n][n];
        System.out.print("nhâp các phần tử của ma trận: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++){
                arr[i][j] = new Scanner(System.in).nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][k];
                arr[i][k] = temp;
            }
        }
        System.out.println("Ma trận sau khi xoay 90 độ:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
