import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        System.out.print("Nhập kích thước mảng: ");
        int n = new Scanner(System.in).nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Nhập số đi: ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        if (n==0) {
            System.err.println("Kích thước rỗng");
        }else {
            for (int i = 0; i < arr.length - 1; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
