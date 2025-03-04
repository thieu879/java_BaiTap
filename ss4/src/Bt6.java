import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        System.out.print("Nhập số nguyên N: ");
        int n  = new Scanner(System.in).nextInt();
        if (n < 0) {
            n = -n;
        }
        int sum = 0;
        while (true){
            if(n > 0){
                sum += n%10;
                n /= 10;
            }else {
                break;
            }
        }
        System.out.println("Tổng các chữ số là: "  + sum);
    }
}
