package Bt10;

public class Company {
    private Employee[] employees;
    private int count;

    public Company(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
            System.out.println("Thêm nhân viên " + employee.name + " vào công ty.");
        } else {
            System.out.println("Không thể thêm nhân viên mới. Công ty đã đầy!");
        }
    }

    public void startWork() {
        System.out.println("\n--- Nhân viên bắt đầu làm việc ---");
        for (int i = 0; i < count; i++) {
            employees[i].work();
        }
    }

    public void organizeMeeting() {
        System.out.println("\n--- Cuộc họp công ty ---");
        for (int i = 0; i < count; i++) {
            if (employees[i] instanceof AttendMeeting) {
                ((AttendMeeting) employees[i]).attendMeeting();
            }
        }
    }
}
