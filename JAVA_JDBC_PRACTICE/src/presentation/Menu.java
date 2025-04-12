package presentation;

import Controller.DepartmentController;
import Controller.EmployeeController;
import Controller.UserController;
import business.model.departments.Department;
import business.model.employee.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final UserController userController = new UserController();
    private final DepartmentController departmentController = new DepartmentController();
    private final EmployeeController employeeController = new EmployeeController();

    public void start() {
        while (true) {
            displayLoginMenu();
            int choice = getChoice(1, 2);
            if (choice == 1) {
                if (handleLogin()) {
                    showMainMenu();
                }
            } else {
                System.out.println("Tạm biệt!");
                break;
            }
        }
    }
    private void displayLoginMenu() {
        System.out.println("\n=== Menu Đăng Nhập ===");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Thoát");
        System.out.print("Chọn tùy chọn: ");
    }
    private boolean handleLogin() {
        System.out.print("Tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();
        if (userController.handleLogin(username, password)) {
            System.out.println("Đăng nhập thành công!");
            return true;
        } else {
            System.out.println("Đăng nhập thất bại. Vui lòng thử lại.");
            return false;
        }
    }
    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== Menu Chính ===");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thống kê");
            System.out.println("4. Đăng xuất");
            System.out.print("Chọn tùy chọn: ");
            int choice = getChoice(1, 4);
            switch (choice) {
                case 1:
                    handleDepartmentMenu();
                    break;
                case 2:
                    handleEmployeeMenu();
                    break;
                case 3:
                    handleStatisticsMenu();
                    break;
                case 4:
                    System.out.println("Đã đăng xuất!");
                    return;
            }
        }
    }
    private void handleDepartmentMenu() {
        while (true) {
            System.out.println("\n=== Menu Phòng Ban ===");
            System.out.println("1. Xem danh sách phòng ban");
            System.out.println("2. Thêm phòng ban");
            System.out.println("3. Cập nhật phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Tìm kiếm phòng ban theo tên");
            System.out.println("6. Quay lại");
            System.out.print("Chọn tùy chọn: ");
            int choice = getChoice(1, 6);
            switch (choice) {
                case 1:
                    handleViewDepartments();
                    break;
                case 2:
                    handleAddDepartment();
                    break;
                case 3:
                    handleUpdateDepartment();
                    break;
                case 4:
                    handleDeleteDepartment();
                    break;
                case 5:
                    handleSearchDepartmentByName();
                    break;
                case 6:
                    return;
            }
        }
    }
    private void handleViewDepartments() {
        System.out.print("Nhập số trang: ");
        int page = getPositiveInt();
        List<Department> departments = departmentController.handleGetDepartments(page);
        if (departments.isEmpty()) {
            System.out.println("Không có phòng ban nào hoặc trang không tồn tại.");
        } else {
            System.out.println("\nDanh sách phòng ban:");
            for (Department dept : departments) {
                System.out.printf("ID: %d, Tên: %s, Mô tả: %s, Trạng thái: %s%n",
                        dept.getDepartmentId(), dept.getName(), dept.getDescription(), dept.getStatus());
            }
        }
    }
    private void handleAddDepartment() {
        Department dept = new Department();
        System.out.print("Nhập tên phòng ban: ");
        dept.setName(scanner.nextLine());
        System.out.print("Nhập mô tả: ");
        dept.setDescription(scanner.nextLine());
        dept.setStatus("hoạt động");
        try {
            if (departmentController.handleAddDepartment(dept)) {
                System.out.println("Thêm phòng ban thành công!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void handleUpdateDepartment() {
        System.out.print("Nhập mã phòng ban cần cập nhật: ");
        int departmentId = getPositiveInt();
        Department dept = new Department();
        dept.setDepartmentId(departmentId);
        System.out.print("Nhập tên phòng ban mới: ");
        dept.setName(scanner.nextLine());
        System.out.print("Nhập mô tả mới: ");
        dept.setDescription(scanner.nextLine());
        System.out.print("Nhập trạng thái (hoạt động/ngừng hoạt động): ");
        dept.setStatus(scanner.nextLine());
        try {
            if (departmentController.handleUpdateDepartment(dept)) {
                System.out.println("Cập nhật phòng ban thành công!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void handleDeleteDepartment() {
        System.out.print("Nhập mã phòng ban cần xóa: ");
        int departmentId = getPositiveInt();
        try {
            if (departmentController.handleDeleteDepartment(departmentId)) {
                System.out.println("Xóa phòng ban thành công!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void handleSearchDepartmentByName() {
        System.out.print("Nhập tên phòng ban cần tìm: ");
        String name = scanner.nextLine();
        List<Department> departments = departmentController.handleSearchDepartmentByName(name);
        if (departments.isEmpty()) {
            System.out.println("Không tìm thấy phòng ban nào.");
        } else {
            System.out.println("\nKết quả tìm kiếm:");
            for (Department dept : departments) {
                System.out.printf("ID: %d, Tên: %s, Mô tả: %s, Trạng thái: %s%n",
                        dept.getDepartmentId(), dept.getName(), dept.getDescription(), dept.getStatus());
            }
        }
    }
    private void handleEmployeeMenu() {
        while (true) {
            System.out.println("\n=== Menu Nhân Viên ===");
            System.out.println("1. Xem danh sách nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên");
            System.out.println("6. Tìm kiếm nhân viên theo tuổi");
            System.out.println("7. Sắp xếp nhân viên theo lương (giảm dần)");
            System.out.println("8. Sắp xếp nhân viên theo tên (tăng dần)");
            System.out.println("9. Quay lại");
            System.out.print("Chọn tùy chọn: ");
            int choice = getChoice(1, 9);
            switch (choice) {
                case 1:
                    handleViewEmployees();
                    break;
                case 2:
                    handleAddEmployee();
                    break;
                case 3:
                    handleUpdateEmployee();
                    break;
                case 4:
                    handleDeleteEmployee();
                    break;
                case 5:
                    handleSearchEmployeeByName();
                    break;
                case 6:
                    handleSearchEmployeeByAge();
                    break;
                case 7:
                    handleSortEmployeeBySalary();
                    break;
                case 8:
                    handleSortEmployeeByName();
                    break;
                case 9:
                    return;
            }
        }
    }
    private void handleViewEmployees() {
        System.out.print("Nhập số trang: ");
        int page = getPositiveInt();
        List<Employee> employees = employeeController.handleGetEmployees(page);
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào hoặc trang không tồn tại.");
        } else {
            System.out.println("\nDanh sách nhân viên:");
            for (Employee emp : employees) {
                System.out.printf("Mã: %s, Tên: %s, Email: %s, SĐT: %s, Giới tính: %s, Lương: %.2f, Ngày sinh: %s, Phòng ban: %d%n",
                        emp.getEmployeeId(), emp.getName(), emp.getEmail(), emp.getPhone(),
                        emp.getGender(), emp.getSalary(), emp.getBirthday(), emp.getDepartmentId());
            }
        }
    }
    private void handleAddEmployee() {
        Employee emp = new Employee();
        System.out.print("Nhập mã nhân viên: ");
        emp.setEmployeeId(scanner.nextLine());
        System.out.print("Nhập tên: ");
        emp.setName(scanner.nextLine());
        System.out.print("Nhập email: ");
        emp.setEmail(scanner.nextLine());
        System.out.print("Nhập số điện thoại: ");
        emp.setPhone(scanner.nextLine());
        System.out.print("Nhập giới tính (Nam/Nữ): ");
        emp.setGender(scanner.nextLine());
        System.out.print("Nhập bậc lương (1-10): ");
        emp.setGradeSalary(getIntInRange(1, 10));
        System.out.print("Nhập lương: ");
        emp.setSalary(getPositiveFloat());
        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        emp.setBirthday(getValidDate());
        System.out.print("Nhập địa chỉ: ");
        emp.setAddress(scanner.nextLine());
        emp.setStatus("hoạt động");
        System.out.print("Nhập mã phòng ban: ");
        emp.setDepartmentId(getPositiveInt());
        try {
            if (employeeController.handleAddEmployee(emp)) {
                System.out.println("Thêm nhân viên thành công!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void handleUpdateEmployee() {
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String employeeId = scanner.nextLine();
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        System.out.print("Nhập tên mới: ");
        emp.setName(scanner.nextLine());
        System.out.print("Nhập email mới: ");
        emp.setEmail(scanner.nextLine());
        System.out.print("Nhập số điện thoại mới: ");
        emp.setPhone(scanner.nextLine());
        System.out.print("Nhập giới tính mới (Nam/Nữ): ");
        emp.setGender(scanner.nextLine());
        System.out.print("Nhập bậc lương mới (1-10): ");
        emp.setGradeSalary(getIntInRange(1, 10));
        System.out.print("Nhập lương mới: ");
        emp.setSalary(getPositiveFloat());
        System.out.print("Nhập ngày sinh mới (yyyy-MM-dd): ");
        emp.setBirthday(getValidDate());
        System.out.print("Nhập địa chỉ mới: ");
        emp.setAddress(scanner.nextLine());
        System.out.print("Nhập trạng thái (hoạt động/ngừng hoạt động): ");
        emp.setStatus(scanner.nextLine());
        System.out.print("Nhập mã phòng ban mới: ");
        emp.setDepartmentId(getPositiveInt());
        try {
            if (employeeController.handleUpdateEmployee(emp)) {
                System.out.println("Cập nhật nhân viên thành công!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void handleDeleteEmployee() {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String employeeId = scanner.nextLine();
        try {
            if (employeeController.handleDeleteEmployee(employeeId)) {
                System.out.println("Xóa nhân viên thành công!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void handleSearchEmployeeByName() {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = scanner.nextLine();
        List<Employee> employees = employeeController.handleSearchEmployeeByName(name);
        if (employees.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên nào.");
        } else {
            System.out.println("\nKết quả tìm kiếm:");
            for (Employee emp : employees) {
                System.out.printf("Mã: %s, Tên: %s, Email: %s, SĐT: %s, Giới tính: %s, Lương: %.2f, Ngày sinh: %s, Phòng ban: %d%n",
                        emp.getEmployeeId(), emp.getName(), emp.getEmail(), emp.getPhone(),
                        emp.getGender(), emp.getSalary(), emp.getBirthday(), emp.getDepartmentId());
            }
        }
    }
    private void handleSearchEmployeeByAge() {
        System.out.print("Nhập tuổi tối thiểu: ");
        int minAge = getPositiveInt();
        System.out.print("Nhập tuổi tối đa: ");
        int maxAge = getPositiveInt();
        if (maxAge < minAge) {
            System.out.println("Tuổi tối đa phải lớn hơn hoặc bằng tuổi tối thiểu.");
            return;
        }
        List<Employee> employees = employeeController.handleSearchEmployeeByAge(minAge, maxAge);
        if (employees.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên nào.");
        } else {
            System.out.println("\nKết quả tìm kiếm:");
            for (Employee emp : employees) {
                System.out.printf("Mã: %s, Tên: %s, Email: %s, SĐT: %s, Giới tính: %s, Lương: %.2f, Ngày sinh: %s, Phòng ban: %d%n",
                        emp.getEmployeeId(), emp.getName(), emp.getEmail(), emp.getPhone(),
                        emp.getGender(), emp.getSalary(), emp.getBirthday(), emp.getDepartmentId());
            }
        }
    }
    private void handleSortEmployeeBySalary() {
        List<Employee> employees = employeeController.handleSortEmployeeBySalaryDesc();
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
        } else {
            System.out.println("\nDanh sách nhân viên (sắp xếp theo lương giảm dần):");
            for (Employee emp : employees) {
                System.out.printf("Mã: %s, Tên: %s, Email: %s, SĐT: %s, Giới tính: %s, Lương: %.2f, Ngày sinh: %s, Phòng ban: %d%n",
                        emp.getEmployeeId(), emp.getName(), emp.getEmail(), emp.getPhone(),
                        emp.getGender(), emp.getSalary(), emp.getBirthday(), emp.getDepartmentId());
            }
        }
    }
    private void handleSortEmployeeByName() {
        List<Employee> employees = employeeController.handleSortEmployeeByNameAsc();
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
        } else {
            System.out.println("\nDanh sách nhân viên (sắp xếp theo tên tăng dần):");
            for (Employee emp : employees) {
                System.out.printf("Mã: %s, Tên: %s, Email: %s, SĐT: %s, Giới tính: %s, Lương: %.2f, Ngày sinh: %s, Phòng ban: %d%n",
                        emp.getEmployeeId(), emp.getName(), emp.getEmail(), emp.getPhone(),
                        emp.getGender(), emp.getSalary(), emp.getBirthday(), emp.getDepartmentId());
            }
        }
    }
    private void handleStatisticsMenu() {
        while (true) {
            System.out.println("\n=== Menu Thống Kê ===");
            System.out.println("1. Số lượng nhân viên theo phòng ban");
            System.out.println("2. Tổng số nhân viên");
            System.out.println("3. Phòng ban có nhiều nhân viên nhất");
            System.out.println("4. Phòng ban có lương trung bình cao nhất");
            System.out.println("5. Quay lại");
            System.out.print("Chọn tùy chọn: ");
            int choice = getChoice(1, 5);
            switch (choice) {
                case 1:
                    handleCountEmployeeByDepartment();
                    break;
                case 2:
                    handleCountTotalEmployees();
                    break;
                case 3:
                    handleDepartmentWithMostEmployees();
                    break;
                case 4:
                    handleDepartmentWithHighestSalary();
                    break;
                case 5:
                    return;
            }
        }
    }
    private void handleCountEmployeeByDepartment() {
        List<Object[]> stats = employeeController.handleCountEmployeeByDepartment();
        if (stats.isEmpty()) {
            System.out.println("Không có dữ liệu thống kê.");
        } else {
            System.out.println("\nSố lượng nhân viên theo phòng ban:");
            for (Object[] stat : stats) {
                System.out.printf("Phòng ban: %s, Số nhân viên: %d%n", stat[0], stat[1]);
            }
        }
    }
    private void handleCountTotalEmployees() {
        int total = employeeController.handleCountTotalEmployees();
        System.out.println("\nTổng số nhân viên: " + total);
    }
    private void handleDepartmentWithMostEmployees() {
        Object[] result = employeeController.handleDepartmentWithMostEmployees();
        if (result == null) {
            System.out.println("Không có dữ liệu.");
        } else {
            System.out.printf("\nPhòng ban có nhiều nhân viên nhất: %s (%d nhân viên)%n", result[0], result[1]);
        }
    }
    private void handleDepartmentWithHighestSalary() {
        Object[] result = employeeController.handleDepartmentWithHighestSalary();
        if (result == null) {
            System.out.println("Không có dữ liệu.");
        } else {
            System.out.printf("\nPhòng ban có lương trung bình cao nhất: %s (%.2f)%n", result[0], result[1]);
        }
    }
    private int getChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.printf("Vui lòng chọn từ %d đến %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
            }
        }
    }
    private int getPositiveInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value;
                }
                System.out.print("Vui lòng nhập số lớn hơn 0: ");
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
            }
        }
    }
    private int getIntInRange(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Vui lòng nhập số từ %d đến %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
            }
        }
    }
    private float getPositiveFloat() {
        while (true) {
            try {
                float value = Float.parseFloat(scanner.nextLine());
                if (value > 0) {
                    return value;
                }
                System.out.print("Vui lòng nhập số lớn hơn 0: ");
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
            }
        }
    }
    private LocalDate getValidDate() {
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.print("Vui lòng nhập ngày theo định dạng yyyy-MM-dd: ");
            }
        }
    }
}