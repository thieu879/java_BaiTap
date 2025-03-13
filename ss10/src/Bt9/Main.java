package Bt9;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Nguyễn Văn A", "E001", 5000);
        Manager mgr = new Manager("Trần Thị B", "M001", 7000, 2000);
        Developer dev = new Developer("Lê Văn C", "D001", 6000, "Java");

        System.out.println(emp);
        System.out.println(mgr);
        System.out.println(dev);

        emp.increaseSalary(500);
        System.out.println("Sau khi tăng lương:");
        System.out.println(emp);
    }
}