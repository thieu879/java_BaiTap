import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        System.out.print("nhập một chuỗi bất kì: ");
        String n = new Scanner(System.in).nextLine();
        StringBuilder sb = new StringBuilder(n);
        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());
    }
}
