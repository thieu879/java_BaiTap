package Bt10;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Thêm sinh viên
        manager.addStudent(new Student(1, "Nguyễn Văn A", "CNTT", 8.5));
        manager.addStudent(new Student(2, "Trần Thị B", "Kinh tế", 7.8));
        manager.addStudent(new Student(3, "Lê Văn C", "CNTT", 9.0));
        manager.addStudent(new Student(4, "Phạm Thị D", "Kế toán", 8.2));

        // Lưu vào file
        manager.saveToFile("students.dat");
        System.out.println("Đã lưu danh sách sinh viên vào file.");

        // Đọc từ file
        StudentManager newManager = new StudentManager();
        newManager.loadFromFile("students.dat");
        System.out.println("\nDanh sách sinh viên sau khi đọc từ file:");
        newManager.displayAll();

        // Tìm sinh viên có GPA cao nhất
        Student topStudent = newManager.findTopStudent();
        System.out.println("\nSinh viên có GPA cao nhất: " + topStudent);

        // Tìm sinh viên theo chuyên ngành
        System.out.println("\nSinh viên ngành CNTT:");
        Student[] cnttStudents = newManager.searchByMajor("CNTT");
        for (int i = 0; i < cnttStudents.length; i++) {
            System.out.println(cnttStudents[i]);
        }

        // Tính GPA trung bình
        double avgGpa = newManager.calculateAverageGpa();
        System.out.println("\nĐiểm GPA trung bình: " + avgGpa);
    }
}