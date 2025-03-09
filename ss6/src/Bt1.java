import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        System.out.print("Nhập một chuỗi: ");
        String input = new Scanner(System.in).nextLine();
        String[] words = input.trim().split("\\s+");
        int wordCount = (input.trim().isEmpty()) ? 0 : words.length;
        System.out.println("Số từ trong chuỗi: " + wordCount);
    }
}
