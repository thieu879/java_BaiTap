import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        System.out.print("Nhập cạnh 1: ");
        int n1 = new Scanner(System.in).nextInt();
        System.out.print("Nhập cạnh 2: ");
        int n2 = new Scanner(System.in).nextInt();
        System.out.print("Nhập cạnh 3: ");
        int n3 = new Scanner(System.in).nextInt();
        if (n1+n2>n3 && n1+n3>n2 && n2+n3>n1) {
            if (n1 == n2 && n1 == n3) {
                System.out.println("tam giác đều");
            } else if (n1 == n2 || n1 == n3 || n2 == n3) {
                System.out.println("tam giác cân");
            } else if ((n1*n1)+(n2*n2)==(n3*n3) || (n1*n1)+(n3*n3)==(n2*n2) || (n2*n2)+(n3*n3)==(n1*n1)) {
                System.out.println("Tam giác vuông");
            }else {
                System.out.println("Tam giác thường");
            }
        }else  {
            System.err.println("Ba cạnh không tạo thành tam giác");
        }
    }
}
