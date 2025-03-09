import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        String specialChars = "!@#$%^&*()-+=";
        int length = 0;
        for (char c : password.toCharArray()) {
            length++;
        }
        if (length < 8) {
            System.out.println("Mật khẩu không hợp lệ.");
        } else {
            for (int i = 0; i < length; i++) {
                char c = password.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    hasUpper = true;
                }
                if (c >= 'a' && c <= 'z') {
                    hasLower = true;
                }
                if (c >= '0' && c <= '9') {
                    hasDigit = true;
                }
                for (int j = 0; j < specialChars.length(); j++) {
                    if (c == specialChars.charAt(j)) {
                        hasSpecial = true;
                        break;
                    }
                }
            }
            if (hasUpper && hasLower && hasDigit && hasSpecial) {
                System.out.println("Mật khẩu hợp lệ.");
            } else {
                System.out.println("Mật khẩu không hợp lệ.");
            }
        }
    }
}
