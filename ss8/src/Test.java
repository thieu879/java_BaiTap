import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập email :");
        String email = sc.nextLine();
        System.out.println("Nhạp password :");
        String password = sc.nextLine();
        String checkemail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        boolean check_email = email.matches(checkemail);
        boolean check1_pass = password.matches(password);
        if(check_email && check1_pass) {
            System.out.println("Email và mật khẩu hợp lệ");
        }
        else if (!check_email && !check1_pass) {
            System.out.println("Email và mật khẩu không hợp lệ, vui lòng thử lại");
        }
        else if (!check_email && check1_pass) {
            System.out.println("Email không hợp lệ, vui lòng thử lại");
        }
        else {
            System.out.println("Mật khẩu không hợp lệ, vui lòng thử lại");
        }
    }
}