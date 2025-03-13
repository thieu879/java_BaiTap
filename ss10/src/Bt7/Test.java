package Bt7;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student(3.5, "SV001", "Nguyễn Văn A");
        GraduateStudent student2 = new GraduateStudent(3.8, "SV002", "Trần Thị B", "AI và Machine Learning", "GS. Nguyễn Văn D");

        Student[] students = {student1, student2};

        for (Student s : students) {
            System.out.println(s.getDetails());
        }
    }
}
