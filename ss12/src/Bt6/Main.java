package Bt6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee("Nguyễn Văn A", 30, 10000000, 2000000),
                new PartTimeEmployee("Trần Thị B", 25, 50000, 40),
                new Intern("Lê Văn C", 22, 3000000)
        };

        System.out.println("===== Danh sách nhân viên =====");
        for (Employee emp : employees) {
            emp.showInfo();
        }
    }
}
