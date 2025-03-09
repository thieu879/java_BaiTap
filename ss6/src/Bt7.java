import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        System.out.println("Nhập danh sách email:");
        String email = scanner.nextLine().trim();
        if (email.matches(regex)) {
            int index = email.indexOf('@');
            String username = email.substring(0, index);
            String domain = email.substring(index + 1);
            System.out.println("Tên người dùng: " + username + ", Tên miền: " + domain);
        } else {
            System.out.println("Email không hợp lệ: " + email);
        }
    }
}