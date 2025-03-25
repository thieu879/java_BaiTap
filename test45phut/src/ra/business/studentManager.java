package ra.business;

import ra.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class studentManager {
    private Map<String, Student> student = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    public void addStudent(){
        System.out.println("Nhập mã sinh viên: ");
        String idStudent = scanner.next();
        System.out.println("Nhập tên sinh viên: ");
        String nameStudent = scanner.next();
        System.out.println("Nhập tuổi sinh viên: ");
        int ageStudent = scanner.nextInt();
        System.out.println("Nhập điểm trung bình của sinh viên: ");
        float averageGradeStudent = scanner.nextFloat();
        Student student1 = new Student(ageStudent, averageGradeStudent, idStudent, nameStudent);
        student.put(idStudent, student1);
        System.out.println("Thêm thành công");
    }
    public void displayStudents(){
        for (Map.Entry<String, Student> entry : student.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public void deleteStudent(){
        System.out.println("Nhập id sinh viên muốn xoá: ");
        String idStudent = scanner.next();
        if (!student.containsKey(idStudent)) {
            System.out.println("Không có sinh viên này");
        }
        student.remove(idStudent);
    }
    public void displayAverageGradeStudents(){
        float averageGradeStudent = 0;
        for (Map.Entry<String, Student> entry : student.entrySet()) {
            averageGradeStudent += entry.getValue().getAverageGrade();
        }
        averageGradeStudent = averageGradeStudent / student.size();
        System.out.println("Điểm trung bình là: " + averageGradeStudent);
    }
    public void displayMaxAverage(){
        List<Student> maxAverage = student.values().stream().collect(Collectors.toList());
        float averageMax = 0;
        for (Student student : maxAverage) {
            if (averageMax < student.getAverageGrade()) {
                averageMax = student.getAverageGrade();
            }
        }
        System.out.println("Điểm trung bình lớn nhất là: "+ averageMax);
        for (Map.Entry<String, Student> entry : student.entrySet()) {
            if(averageMax == entry.getValue().getAverageGrade()) {
                System.out.println("Thông tin sinh viên là:  " + entry.getValue());
            }
        }
    }
    public void minAgeStudent(){
        List<Student> minAgeStudent = student.values().stream().collect(Collectors.toList());
        int minAge = 1;
        for (Student student : minAgeStudent) {
            if (student.getAge() < minAge) {
                minAge = student.getAge();
            }
        }
        System.out.println("Số tuổi nhỏ nhất là:  " + minAge);
        for (Map.Entry<String, Student> entry : student.entrySet()) {
            if (minAge == entry.getValue().getAge()) {
                System.out.println("thông tin sinh viên có số tuổi nhỏ nhất là: "+ entry.getValue());
            }
        }
    }
}
