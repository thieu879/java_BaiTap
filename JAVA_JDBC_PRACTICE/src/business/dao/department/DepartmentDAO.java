package business.dao.department;

import business.model.departments.Department;
import java.util.List;

public interface DepartmentDAO {
    int addDepartment(Department dept);
    List<Department> getDepartments(int page, int limit);
    int updateDepartment(Department dept);
    int deleteDepartment(int departmentId);
    List<Department> searchDepartmentByName(String name);
}
