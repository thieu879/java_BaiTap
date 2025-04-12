package business.dao.department;

import business.config.ConnectionDB;
import business.model.departments.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImp implements DepartmentDAO {
    @Override
    public int addDepartment(Department dept) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL addDepartment(?,?,?,?)}");
            callSt.setString(1, dept.getName());
            callSt.setString(2, dept.getDescription());
            callSt.setString(3, dept.getStatus());
            callSt.registerOutParameter(4, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(4);
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm phòng ban, dữ liệu đã được rollback: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi làm việc với cơ sở dữ liệu: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public List<Department> getDepartments(int page, int limit) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> departments = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL getDepartments(?,?)}");
            callSt.setInt(1, page);
            callSt.setInt(2, limit);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Department dept = new Department();
                dept.setDepartmentId(rs.getInt("dpmt_id"));
                dept.setName(rs.getString("dpmt_name"));
                dept.setDescription(rs.getString("dpmt_description"));
                dept.setStatus(rs.getString("dpmt_status"));
                departments.add(dept);
            }
            conn.commit();
            return departments;
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách phòng ban, dữ liệu đã được rollback: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi làm việc với cơ sở dữ liệu: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departments;
    }

    @Override
    public int updateDepartment(Department dept) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL updateDepartment(?,?,?,?,?)}");
            callSt.setInt(1, dept.getDepartmentId());
            callSt.setString(2, dept.getName());
            callSt.setString(3, dept.getDescription());
            callSt.setString(4, dept.getStatus());
            callSt.registerOutParameter(5, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(5);
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật phòng ban, dữ liệu đã được rollback: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi làm việc với cơ sở dữ liệu: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public int deleteDepartment(int departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL deleteDepartment(?,?)}");
            callSt.setInt(1, departmentId);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(2);
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa phòng ban, dữ liệu đã được rollback: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi làm việc với cơ sở dữ liệu: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public List<Department> searchDepartmentByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> departments = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL searchDepartmentByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Department dept = new Department();
                dept.setDepartmentId(rs.getInt("dpmt_id"));
                dept.setName(rs.getString("dpmt_name"));
                dept.setDescription(rs.getString("dpmt_description"));
                dept.setStatus(rs.getString("dpmt_status"));
                departments.add(dept);
            }
            conn.commit();
            return departments;
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm phòng ban, dữ liệu đã được rollback: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi làm việc với cơ sở dữ liệu: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departments;
    }
}
