package business.service.department;

import business.dao.department.DepartmentDAO;
import business.dao.department.DepartmentDAOImp;
import business.model.departments.Department;

import java.sql.SQLException;
import java.util.List;

public class DepartmentServiceImp implements DepartmentService {
    private DepartmentDAO departmentDAO = new DepartmentDAOImp();

    @Override
    public List<Department> getDepartments(int page) throws SQLException {
        if (page < 1) {
            throw new IllegalArgumentException("Số trang phải lớn hơn 0.");
        }
        return departmentDAO.getDepartments(page, 5);
    }

    @Override
    public void addDepartment(Department dept) throws SQLException {
        if (dept == null) {
            throw new IllegalArgumentException("Phòng ban không được null.");
        }
        dept.validate();
        if (departmentDAO.addDepartment(dept) != 1) {
            throw new SQLException("Không thể thêm phòng ban. Tên phòng ban có thể đã tồn tại.");
        }
    }

    @Override
    public void updateDepartment(Department dept) throws SQLException {
        if (dept == null) {
            throw new IllegalArgumentException("Phòng ban không được null.");
        }
        dept.validate();
        if (departmentDAO.updateDepartment(dept) != 1) {
            throw new SQLException("Không thể cập nhật phòng ban. Phòng ban có thể không tồn tại.");
        }
    }

    @Override
    public void deleteDepartment(int departmentId) throws SQLException {
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Mã phòng ban phải lớn hơn 0.");
        }
        if (departmentDAO.deleteDepartment(departmentId) != 1) {
            throw new SQLException("Không thể xóa phòng ban. Phòng ban có thể không tồn tại hoặc đang có nhân viên.");
        }
    }

    @Override
    public List<Department> searchDepartmentByName(String name) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên phòng ban không được để trống.");
        }
        return departmentDAO.searchDepartmentByName(name);
    }
}
