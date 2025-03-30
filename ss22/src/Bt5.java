import java.io.*;

public class Bt5 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFileName))) {
            writer.write("Văn Lâm\n");
            writer.write("Tiến Linh\n");
            writer.write("Xuân Son\n");
            writer.write("Hoàng Đức\n");
            writer.write("Văn Hậu");
            System.out.println("Đã tạo file input.txt thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file input.txt: " + e.getMessage());
            return;
        }

        // Đọc file và tìm từ dài nhất
        String longestName = "";
        int maxLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Loại bỏ khoảng trắng thừa (nếu có)
                String trimmedLine = line.trim();
                if (trimmedLine.length() > maxLength) {
                    longestName = trimmedLine;
                    maxLength = trimmedLine.length();
                }
            }

            // Hiển thị kết quả
            if (!longestName.isEmpty()) {
                System.out.println("Tên cầu thủ dài nhất: " + longestName);
                System.out.println("Độ dài của tên: " + maxLength);
            } else {
                System.out.println("File rỗng hoặc không có dữ liệu hợp lệ!");
            }

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}