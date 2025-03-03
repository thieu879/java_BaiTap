import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        System.out.print("nhập số thứ nhất:");
        int n1=new Scanner(System.in).nextInt();
        System.out.print("Nhập Ký hiệu phép toán");
        char ch=new Scanner(System.in).next().charAt(0);
        System.out.print("Nhập số thứ 2:");
        int n2=new Scanner(System.in).nextInt();
        switch (ch){
            case '+':
                System.out.println(n1 + n2);
                break;
            case '-':
                System.out.println(n1 - n2);
                break;
            case '*':
                System.out.println(n1 * n2);
                break;
            case '/':
                if (n2 == 0) {
                    System.err.println("Phép toán không hợp lệ");
                }else {
                    System.out.println(n1 / n2);
                }
                break;
            default:
                System.err.println("Phép toán không hợp lệ");
                break;
        }
    }
}
