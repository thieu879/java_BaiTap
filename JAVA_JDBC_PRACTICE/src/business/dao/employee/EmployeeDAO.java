package business.dao.employee;

import business.model.employee.Employee;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeDAO {
    int addEmployee(Employee emp);
    List<Employee> getEmployees(int page, int limit);
    int updateEmployee(Employee emp);
    int deleteEmployee(String employeeId);
    List<Employee> searchEmployeeByName(String name);
    List<Employee> searchEmployeeByAge(LocalDate startDate, LocalDate endDate);
    List<Employee> sortEmployeeBySalaryDesc();
    List<Employee> sortEmployeeByNameAsc();
    List<Object[]> countEmployeeByDepartment();
    int countTotalEmployees();
    Object[] departmentWithMostEmployees();
    Object[] departmentWithHighestSalary();
}
