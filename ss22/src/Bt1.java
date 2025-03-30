import java.io.*;
import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một chuỗi văn bản bất kỳ: ");
        String inputText = scanner.nextLine();
        try {
            // Tạo đối tượng FileWriter để ghi file
            FileWriter writer = new FileWriter("output.txt");
            // Ghi chuỗi vào file
            writer.write(inputText);
            // Đóng writer để lưu thay đổi
            writer.close();
            System.out.println("Đã ghi thành công vào file output.txt");

            // 3. Đọc lại nội dung từ file
            FileReader reader = new FileReader("output.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            System.out.println("Nội dung đọc từ file:");
            // Đọc từng dòng và hiển thị
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Đóng reader
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}