import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên tệp (ví dụ: data.txt): ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        // 3. Kiểm tra sự tồn tại của tệp
        if (file.exists()) {
            System.out.println("Tệp đã tồn tại!");
        } else {
            // 4. Nếu tệp chưa tồn tại, tạo mới
            try {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("Tệp đã được tạo!");
                }
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi tạo tệp: " + e.getMessage());
            }
        }
    }
}