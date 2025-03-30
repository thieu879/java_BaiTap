package Bt10;

import java.io.*;

public class StudentManager {
    private Student[] students;
    private int size;
    private static final int MAX_SIZE = 100; // Giới hạn tối đa số sinh viên

    public StudentManager() {
        students = new Student[MAX_SIZE];
        size = 0;
    }

    public void addStudent(Student student) {
        if (size < MAX_SIZE) {
            students[size] = student;
            size++;
        } else {
            System.out.println("Danh sách sinh viên đã đầy!");
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeInt(size); // Ghi số lượng sinh viên
            for (int i = 0; i < size; i++) {
                oos.writeObject(students[i]);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                size = ois.readInt();
                for (int i = 0; i < size; i++) {
                    students[i] = (Student) ois.readObject();
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Lỗi khi đọc file: " + e.getMessage());
                size = 0;
            }
        }
    }

    public Student findTopStudent() {
        if (size == 0) {
            return null;
        }
        Student topStudent = students[0];
        for (int i = 1; i < size; i++) {
            if (students[i].getGpa() > topStudent.getGpa()) {
                topStudent = students[i];
            }
        }
        return topStudent;
    }

    public Student[] searchByMajor(String major) {
        int count = 0;
        // Đếm số sinh viên theo chuyên ngành
        for (int i = 0; i < size; i++) {
            if (students[i].getMajor().equalsIgnoreCase(major)) {
                count++;
            }
        }

        // Tạo mảng kết quả
        Student[] result = new Student[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (students[i].getMajor().equalsIgnoreCase(major)) {
                result[index] = students[i];
                index++;
            }
        }
        return result;
    }

    public double calculateAverageGpa() {
        if (size == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += students[i].getGpa();
        }
        return sum / size;
    }

    // Phương thức phụ để hiển thị danh sách (dùng trong Main)
    public void displayAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }
}