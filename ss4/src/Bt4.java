import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        int sum = 0;
        while (true) {
            System.out.print("Nhập đi: ");
            int n  = new Scanner(System.in).nextInt();
            if (n==0){
                break;
            }else  {
                sum += n;
            }
        }
        System.out.println(sum);
    }
}
