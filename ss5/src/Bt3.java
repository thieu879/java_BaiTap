import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        System.out.print("Nhập kích thước mảng: ");
        int n = new Scanner(System.in).nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Nhập số đi: ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
