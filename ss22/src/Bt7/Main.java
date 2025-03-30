package Bt7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "data.txt";

        // Tạo file data.txt với nội dung như yêu cầu
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("1, AU, Australia\n");
            writer.write("2, CN, China\n");
            writer.write("3, AU, Australia\n");
            writer.write("4, CN, China\n");
            writer.write("5, JP, Japan\n");
            writer.write("6, CN, China\n");
            writer.write("7, JP, Japan\n");
            writer.write("8, TH, Thailand");
            System.out.println("Đã tạo file data.txt thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file data.txt: " + e.getMessage());
            return;
        }

        // Đọc file và lưu vào List<Country>
        List<Country> countryList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Tách các thành phần của dòng bằng dấu phẩy
                String[] parts = line.split(",\\s*");
                if (parts.length == 3) {
                    // Chuyển đổi dữ liệu thành đối tượng Country
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].trim();
                    String name = parts[2].trim();
                    Country country = new Country(id, code, name);
                    countryList.add(country);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Lỗi khi chuyển đổi dữ liệu: " + e.getMessage());
            return;
        }

        //In danh sách Country
        if (countryList.isEmpty()) {
            System.out.println("Danh sách quốc gia rỗng!");
        } else {
            System.out.println("\nDanh sách quốc gia:");
            System.out.println("+-------+----------+-----------------+");
            System.out.println("| ID    | Code     | Name            |");
            System.out.println("+-------+----------+-----------------+");
            for (Country country : countryList) {
                System.out.println(country);
            }
            System.out.println("+-------+----------+-----------------+");
        }
    }
}