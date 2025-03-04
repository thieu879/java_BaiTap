import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        System.out.print("Nhập số nguyên n từ bàn phím: ");
        int n = new Scanner(System.in).nextInt();
        if (n<0){
            System.out.println("Số nhập vào không hợp lệ");
        }else {
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " * " + i+ " = "  + (n*i));
            }
        }
    }
}
