package Controller;

import business.model.departments.Department;
import business.service.department.DepartmentService;
import business.service.department.DepartmentServiceImp;

import java.sql.SQLException;
import java.util.List;

public class DepartmentController {
    private DepartmentService departmentService = new DepartmentServiceImp();
    public List<Department> handleGetDepartments(int page) {
        try {
            return departmentService.getDepartments(page);
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách phòng ban: " + e.getMessage());
            return List.of();
        }
    }
    public boolean handleAddDepartment(Department dept) {
        try {
            departmentService.addDepartment(dept);
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm phòng ban: " + e.getMessage());
            return false;
        }
    }
    public boolean handleUpdateDepartment(Department dept) {
        try {
            departmentService.updateDepartment(dept);
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật phòng ban: " + e.getMessage());
            return false;
        }
    }
    public boolean handleDeleteDepartment(int departmentId) {
        try {
            departmentService.deleteDepartment(departmentId);
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa phòng ban: " + e.getMessage());
            return false;
        }
    }
    public List<Department> handleSearchDepartmentByName(String name) {
        try {
            return departmentService.searchDepartmentByName(name);
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm phòng ban: " + e.getMessage());
            return List.of();
        }
    }
}
