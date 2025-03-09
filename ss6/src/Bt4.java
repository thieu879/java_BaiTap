import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một chuỗi bất kỳ: ");
        String input = scanner.nextLine();
        String replacedString = input.replaceAll("[0-9]", "*");
        System.out.println("Chuỗi sau khi thay thế: " + replacedString);
    }
}
