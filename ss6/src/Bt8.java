import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        String input = scanner.nextLine().trim();
        String cleanedNumber = input.replaceAll("[\\s.-]", "");
        if (cleanedNumber.matches("^0\\d{9}$")) {
            cleanedNumber = "+84" + cleanedNumber.substring(1);
        } else if (cleanedNumber.matches("^\\+84\\d{9}$")) {
        } else {
            System.out.println("Số điện thoại không hợp lệ");
            return;
        }
        String formattedNumber = cleanedNumber.substring(0, 3) + " " +
                cleanedNumber.substring(3, 6) + " " +
                cleanedNumber.substring(6, 9) + " " +
                cleanedNumber.substring(9);
        System.out.println("Số điện thoại hợp lệ: " + formattedNumber);
    }
}
