import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi đi: ");
        String n = new Scanner(System.in).nextLine();

        String[] arr = n.trim().split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
