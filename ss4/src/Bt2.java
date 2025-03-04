import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        System.out.print("Nhập Số nguyên dương N: ");
        int n = new Scanner(System.in).nextInt();
        int count = 0;
        if (n<2){
            System.err.println(n+ " Không phải số nguyên tố");
        }else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n%i==0){
                    count++;
                }
            }
            if (count==0){
                System.out.println(n+" là số nguyên tố");
            }else {
                System.err.println(n+" Không phải số nguyên tố");
            }
        }
    }
}
