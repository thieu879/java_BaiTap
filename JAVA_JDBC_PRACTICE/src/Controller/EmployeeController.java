package Controller;

import business.model.employee.Employee;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;

import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImp();

    public List<Employee> handleGetEmployees(int page) {
        try {
            return employeeService.getEmployees(page);
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách nhân viên: " + e.getMessage());
            return List.of();
        }
    }
    public boolean handleAddEmployee(Employee emp) {
        try {
            employeeService.addEmployee(emp);
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm nhân viên: " + e.getMessage());
            return false;
        }
    }
    public boolean handleUpdateEmployee(Employee emp) {
        try {
            employeeService.updateEmployee(emp);
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật nhân viên: " + e.getMessage());
            return false;
        }
    }
    public boolean handleDeleteEmployee(String employeeId) {
        try {
            employeeService.deleteEmployee(employeeId);
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa nhân viên: " + e.getMessage());
            return false;
        }
    }
    public List<Employee> handleSearchEmployeeByName(String name) {
        try {
            return employeeService.searchEmployeeByName(name);
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm nhân viên: " + e.getMessage());
            return List.of();
        }
    }
    public List<Employee> handleSearchEmployeeByAge(int minAge, int maxAge) {
        try {
            return employeeService.searchEmployeeByAge(minAge, maxAge);
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm nhân viên theo tuổi: " + e.getMessage());
            return List.of();
        }
    }
    public List<Employee> handleSortEmployeeBySalaryDesc() {
        try {
            return employeeService.sortEmployeeBySalaryDesc();
        } catch (SQLException e) {
            System.out.println("Lỗi khi sắp xếp nhân viên: " + e.getMessage());
            return List.of();
        }
    }
    public List<Employee> handleSortEmployeeByNameAsc() {
        try {
            return employeeService.sortEmployeeByNameAsc();
        } catch (SQLException e) {
            System.out.println("Lỗi khi sắp xếp nhân viên: " + e.getMessage());
            return List.of();
        }
    }
    public List<Object[]> handleCountEmployeeByDepartment() {
        try {
            return employeeService.countEmployeeByDepartment();
        } catch (SQLException e) {
            System.out.println("Lỗi khi thống kê nhân viên: " + e.getMessage());
            return List.of();
        }
    }
    public int handleCountTotalEmployees() {
        try {
            return employeeService.countTotalEmployees();
        } catch (SQLException e) {
            System.out.println("Lỗi khi đếm nhân viên: " + e.getMessage());
            return 0;
        }
    }
    public Object[] handleDepartmentWithMostEmployees() {
        try {
            return employeeService.departmentWithMostEmployees();
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm phòng ban: " + e.getMessage());
            return null;
        }
    }
    public Object[] handleDepartmentWithHighestSalary() {
        try {
            return employeeService.departmentWithHighestSalary();
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm phòng ban: " + e.getMessage());
            return null;
        }
    }
}
