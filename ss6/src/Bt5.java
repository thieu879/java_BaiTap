import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đoạn văn bản: ");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");
        int count = 0;
        System.out.println("Các từ chứa ký tự đặc biệt:");
        for (String word : words) {
            if (word.matches(".*[^a-zA-Z0-9].*")) {
                System.out.println(word);
                count++;
            }
        }
        System.out.println("Số lượng từ chứa ký tự đặc biệt: " + count);
    }
}
