import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi thứ nhất: ");
        String n1 = new Scanner(System.in).nextLine();
        System.out.print("Nhập chuỗi thứ nhất: ");
        String n2 = new Scanner(System.in).nextLine();
        System.out.print("Nhập chuỗi thứ nhất: ");
        String n3 = new Scanner(System.in).nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(n1).append(" ").append(n2).append(" ").append(n3);
        System.out.println(sb.toString().toUpperCase());
    }
}
