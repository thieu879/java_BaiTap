package business.service.employee;

import business.model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int page) throws SQLException;
    void addEmployee(Employee emp) throws SQLException;
    void updateEmployee(Employee emp) throws SQLException;
    void deleteEmployee(String employeeId) throws SQLException;
    List<Employee> searchEmployeeByName(String name) throws SQLException;
    List<Employee> searchEmployeeByAge(int minAge, int maxAge) throws SQLException;
    List<Employee> sortEmployeeBySalaryDesc() throws SQLException;
    List<Employee> sortEmployeeByNameAsc() throws SQLException;
    List<Object[]> countEmployeeByDepartment() throws SQLException;
    int countTotalEmployees() throws SQLException;
    Object[] departmentWithMostEmployees() throws SQLException;
    Object[] departmentWithHighestSalary() throws SQLException;
}
