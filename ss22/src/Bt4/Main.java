package Bt4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Nguyen Van A", 20, 8.5);

        // Ghi đối tượng vào file nhị phân student.dat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file student.dat");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
            return;
        }

        // Đọc lại đối tượng từ file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.dat");
            // Hiển thị thông tin đối tượng vừa đọc
            System.out.println("Thông tin sinh viên đọc được: " + readStudent);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy lớp Student: " + e.getMessage());
        }
    }
}
