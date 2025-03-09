import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email;
        String password;
        boolean emailValid = false;
        boolean passwordValid = false;
        while (!emailValid) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();

            if (email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.(com|vn|org)$")) {
                emailValid = true;
            } else {
                System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
            }
        }
        while (!passwordValid) {
            System.out.print("Nhập mật khẩu: ");
            password = scanner.nextLine();

            if (password.length() >= 8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*[a-z].*") &&
                    password.matches(".*\\d.*") &&
                    password.matches(".*[@#$%!&*].*")) {
                passwordValid = true;
            } else {
                System.out.println("Mật khẩu không hợp lệ! Vui lòng nhập lại.");
            }
        }
        System.out.println("Email và mật khẩu hợp lệ!");
    }
}
