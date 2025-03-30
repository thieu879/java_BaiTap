import java.io.*;

public class Bt3 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "copy.txt";
        try {
            FileWriter writer = new FileWriter(inputFileName);
            writer.write("Đây là nội dung mẫu trong file input.txt\n");
            writer.write("Dòng thứ hai để kiểm tra\n");
            writer.write("Dòng cuối cùng!");
            writer.close();
            System.out.println("Đã tạo file input.txt thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file input.txt: " + e.getMessage());
            return;
        }
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Đã copy thành công sang file copy.txt!");

        } catch (IOException e) {
            System.out.println("Lỗi khi copy file: " + e.getMessage());
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