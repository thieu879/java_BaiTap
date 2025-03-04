import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        System.out.print("Nhập Số nguyên dương N: ");
        int n = new Scanner(System.in).nextInt();
        int sum=0;
        if (n<=0){
            System.err.println("Số nhập vào không hợp lệ");
        }else {
            for (int i = 1; i <= n; i++) {
                sum+=i;
            }
            System.out.println(sum);
        }
    }
}
