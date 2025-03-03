import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        System.out.print("Nhập số n: ");
        int n  = new Scanner(System.in).nextInt();
        if (n==0) {
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        } else if (n%2==0) {
            System.out.println("Số " + n + " là số chẵn");
        }else {
            System.out.println("Số " + n + " là số lẻ");
        }
    }
}
