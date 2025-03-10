import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần nén: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                sb.append(input.charAt(i)).append(count);
                count = 1;
            }
        }
        System.out.println("Chuỗi đã nén: " + sb.toString());
    }
}
