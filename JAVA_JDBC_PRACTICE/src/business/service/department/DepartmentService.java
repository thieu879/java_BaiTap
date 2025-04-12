package business.service.department;

import business.model.departments.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments(int page) throws SQLException;
    void addDepartment(Department dept) throws SQLException;
    void updateDepartment(Department dept) throws SQLException;
    void deleteDepartment(int departmentId) throws SQLException;
    List<Department> searchDepartmentByName(String name) throws SQLException;
}
