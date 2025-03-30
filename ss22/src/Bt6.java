import java.io.*;

public class Bt6 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "copy.txt";

        // 1. Tạo file input.txt với nội dung mẫu
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFileName))) {
            writer.write("Hello World\n");
            writer.write("Hello java\n");
            writer.write("Hello PTIT");
            System.out.println("Đã tạo file input.txt thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file input.txt: " + e.getMessage());
            return;
        }

        // 2. Đọc file, đảo ngược chuỗi và ghi vào copy.txt
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Đảo ngược từng dòng
                String reversedLine = new StringBuilder(line).reverse().toString();
                writer.write(reversedLine);
                writer.newLine(); // Thêm dòng mới sau mỗi dòng
            }
            System.out.println("Đã sao chép và đảo ngược sang file copy.txt!");

        } catch (IOException e) {
            System.out.println("Lỗi khi xử lý file: " + e.getMessage());
            return;
        }

        // 3. Đọc và hiển thị nội dung file copy.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFileName))) {
            System.out.println("Nội dung của file copy.txt:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file copy.txt: " + e.getMessage());
        }
    }
}