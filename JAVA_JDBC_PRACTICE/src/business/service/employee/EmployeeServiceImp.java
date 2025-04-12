package business.service.employee;

import business.dao.department.DepartmentDAO;
import business.dao.department.DepartmentDAOImp;
import business.dao.employee.EmployeeDAO;
import business.dao.employee.EmployeeDAOImp;
import business.model.employee.Employee;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImp();
    private DepartmentDAO departmentDAO = new DepartmentDAOImp();

    @Override
    public List<Employee> getEmployees(int page) throws SQLException {
        if (page < 1) {
            throw new IllegalArgumentException("Số trang phải lớn hơn 0.");
        }
        return employeeDAO.getEmployees(page, 10);
    }

    @Override
    public void addEmployee(Employee emp) throws SQLException {
        if (emp == null) {
            throw new IllegalArgumentException("Nhân viên không được null.");
        }
        emp.validate();
        if (!departmentDAO.getDepartments(1, 100).stream()
                .anyMatch(d -> d.getDepartmentId() == emp.getDepartmentId() && d.getStatus().equals("hoạt động"))) {
            throw new SQLException("Không thể thêm nhân viên vào phòng ban không hoạt động hoặc không tồn tại.");
        }
        int result = employeeDAO.addEmployee(emp);
        if (result != 1) {
            throw new SQLException("Không thể thêm nhân viên. Email hoặc số điện thoại có thể đã tồn tại.");
        }
    }

    @Override
    public void updateEmployee(Employee emp) throws SQLException {
        if (emp == null) {
            throw new IllegalArgumentException("Nhân viên không được null.");
        }
        emp.validate();
        if (!departmentDAO.getDepartments(1, 100).stream()
                .anyMatch(d -> d.getDepartmentId() == emp.getDepartmentId() && d.getStatus().equals("hoạt động"))) {
            throw new SQLException("Không thể cập nhật nhân viên vào phòng ban không hoạt động hoặc không tồn tại.");
        }
        if (employeeDAO.updateEmployee(emp) != 1) {
            throw new SQLException("Không thể cập nhật nhân viên. Nhân viên có thể không tồn tại.");
        }
    }

    @Override
    public void deleteEmployee(String employeeId) throws SQLException {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống.");
        }
        if (employeeDAO.deleteEmployee(employeeId) != 1) {
            throw new SQLException("Không thể xóa nhân viên. Nhân viên có thể không tồn tại.");
        }
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên nhân viên không được để trống.");
        }
        return employeeDAO.searchEmployeeByName(name);
    }

    @Override
    public List<Employee> searchEmployeeByAge(int minAge, int maxAge) throws SQLException {
        if (minAge < 0 || maxAge < minAge) {
            throw new IllegalArgumentException("Tuổi không hợp lệ.");
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusYears(maxAge);
        LocalDate endDate = currentDate.minusYears(minAge);
        return employeeDAO.searchEmployeeByAge(startDate, endDate);
    }

    @Override
    public List<Employee> sortEmployeeBySalaryDesc() throws SQLException {
        return employeeDAO.sortEmployeeBySalaryDesc();
    }

    @Override
    public List<Employee> sortEmployeeByNameAsc() throws SQLException {
        return employeeDAO.sortEmployeeByNameAsc();
    }

    @Override
    public List<Object[]> countEmployeeByDepartment() throws SQLException {
        return employeeDAO.countEmployeeByDepartment();
    }

    @Override
    public int countTotalEmployees() throws SQLException {
        return employeeDAO.countTotalEmployees();
    }

    @Override
    public Object[] departmentWithMostEmployees() throws SQLException {
        return employeeDAO.departmentWithMostEmployees();
    }

    @Override
    public Object[] departmentWithHighestSalary() throws SQLException {
        return employeeDAO.departmentWithHighestSalary();
    }
}
