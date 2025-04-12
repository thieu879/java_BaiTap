package business.dao.employee;

import business.config.ConnectionDB;
import business.model.employee.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {
    @Override
    public int addEmployee(Employee emp) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL addEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, emp.getEmployeeId());
            callSt.setString(2, emp.getName());
            callSt.setString(3, emp.getEmail());
            callSt.setString(4, emp.getPhone());
            callSt.setString(5, emp.getGender());
            callSt.setInt(6, emp.getGradeSalary());
            callSt.setFloat(7, emp.getSalary());
            callSt.setDate(8, Date.valueOf(emp.getBirthday()));
            callSt.setString(9, emp.getAddress());
            callSt.setString(10, emp.getStatus());
            callSt.setInt(11, emp.getDepartmentId());
            callSt.registerOutParameter(12, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(12);
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm nhân viên, dữ liệu đã được rollback: " + e.getMessage());
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
    public List<Employee> getEmployees(int page, int limit) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL getEmployees(?,?)}");
            callSt.setInt(1, page);
            callSt.setInt(2, limit);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getString("emp_id"));
                emp.setName(rs.getString("emp_name"));
                emp.setEmail(rs.getString("emp_email"));
                emp.setPhone(rs.getString("emp_phone"));
                emp.setGender(rs.getString("emp_gender"));
                emp.setGradeSalary(rs.getInt("emp_grade_salary"));
                emp.setSalary(rs.getFloat("emp_salary"));
                emp.setBirthday(rs.getDate("emp_birthday").toLocalDate());
                emp.setAddress(rs.getString("emp_address"));
                emp.setStatus(rs.getString("emp_status"));
                emp.setDepartmentId(rs.getInt("dpmt_id"));
                employees.add(emp);
            }
            conn.commit();
            return employees;
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách nhân viên, dữ liệu đã được rollback: " + e.getMessage());
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
        return employees;
    }

    @Override
    public int updateEmployee(Employee emp) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL updateEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, emp.getEmployeeId());
            callSt.setString(2, emp.getName());
            callSt.setString(3, emp.getEmail());
            callSt.setString(4, emp.getPhone());
            callSt.setString(5, emp.getGender());
            callSt.setInt(6, emp.getGradeSalary());
            callSt.setFloat(7, emp.getSalary());
            callSt.setDate(8, Date.valueOf(emp.getBirthday()));
            callSt.setString(9, emp.getAddress());
            callSt.setString(10, emp.getStatus());
            callSt.setInt(11, emp.getDepartmentId());
            callSt.registerOutParameter(12, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(12);
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật nhân viên, dữ liệu đã được rollback: " + e.getMessage());
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
    public int deleteEmployee(String employeeId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL deleteEmployee(?,?)}");
            callSt.setString(1, employeeId);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(2);
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa nhân viên, dữ liệu đã được rollback: " + e.getMessage());
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
    public List<Employee> searchEmployeeByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL searchEmployeeByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getString("emp_id"));
                emp.setName(rs.getString("emp_name"));
                emp.setEmail(rs.getString("emp_email"));
                emp.setPhone(rs.getString("emp_phone"));
                emp.setGender(rs.getString("emp_gender"));
                emp.setGradeSalary(rs.getInt("emp_grade_salary"));
                emp.setSalary(rs.getFloat("emp_salary"));
                emp.setBirthday(rs.getDate("emp_birthday").toLocalDate());
                emp.setAddress(rs.getString("emp_address"));
                emp.setStatus(rs.getString("emp_status"));
                emp.setDepartmentId(rs.getInt("dpmt_id"));
                employees.add(emp);
            }
            conn.commit();
            return employees;
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm nhân viên theo tên, dữ liệu đã được rollback: " + e.getMessage());
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
        return employees;
    }

    @Override
    public List<Employee> searchEmployeeByAge(LocalDate startDate, LocalDate endDate) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL searchEmployeeByAge(?,?)}");
            callSt.setDate(1, Date.valueOf(startDate));
            callSt.setDate(2, Date.valueOf(endDate));
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getString("emp_id"));
                emp.setName(rs.getString("emp_name"));
                emp.setEmail(rs.getString("emp_email"));
                emp.setPhone(rs.getString("emp_phone"));
                emp.setGender(rs.getString("emp_gender"));
                emp.setGradeSalary(rs.getInt("emp_grade_salary"));
                emp.setSalary(rs.getFloat("emp_salary"));
                emp.setBirthday(rs.getDate("emp_birthday").toLocalDate());
                emp.setAddress(rs.getString("emp_address"));
                emp.setStatus(rs.getString("emp_status"));
                emp.setDepartmentId(rs.getInt("dpmt_id"));
                employees.add(emp);
            }
            conn.commit();
            return employees;
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm nhân viên theo tuổi, dữ liệu đã được rollback: " + e.getMessage());
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
        return employees;
    }

    @Override
    public List<Employee> sortEmployeeBySalaryDesc() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL sortEmployeeBySalaryDesc()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getString("emp_id"));
                emp.setName(rs.getString("emp_name"));
                emp.setEmail(rs.getString("emp_email"));
                emp.setPhone(rs.getString("emp_phone"));
                emp.setGender(rs.getString("emp_gender"));
                emp.setGradeSalary(rs.getInt("emp_grade_salary"));
                emp.setSalary(rs.getFloat("emp_salary"));
                emp.setBirthday(rs.getDate("emp_birthday").toLocalDate());
                emp.setAddress(rs.getString("emp_address"));
                emp.setStatus(rs.getString("emp_status"));
                emp.setDepartmentId(rs.getInt("dpmt_id"));
                employees.add(emp);
            }
            conn.commit();
            return employees;
        } catch (SQLException e) {
            System.err.println("Lỗi khi sắp xếp nhân viên theo lương, dữ liệu đã được rollback: " + e.getMessage());
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
        return employees;
    }

    @Override
    public List<Employee> sortEmployeeByNameAsc() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL sortEmployeeByNameAsc()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getString("emp_id"));
                emp.setName(rs.getString("emp_name"));
                emp.setEmail(rs.getString("emp_email"));
                emp.setPhone(rs.getString("emp_phone"));
                emp.setGender(rs.getString("emp_gender"));
                emp.setGradeSalary(rs.getInt("emp_grade_salary"));
                emp.setSalary(rs.getFloat("emp_salary"));
                emp.setBirthday(rs.getDate("emp_birthday").toLocalDate());
                emp.setAddress(rs.getString("emp_address"));
                emp.setStatus(rs.getString("emp_status"));
                emp.setDepartmentId(rs.getInt("dpmt_id"));
                employees.add(emp);
            }
            conn.commit();
            return employees;
        } catch (SQLException e) {
            System.err.println("Lỗi khi sắp xếp nhân viên theo tên, dữ liệu đã được rollback: " + e.getMessage());
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
        return employees;
    }

    @Override
    public List<Object[]> countEmployeeByDepartment() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Object[]> result = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL countEmployeeByDepartment()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                result.add(new Object[]{rs.getString("dpmt_name"), rs.getInt("employee_count")});
            }
            conn.commit();
            return result;
        } catch (SQLException e) {
            System.err.println("Lỗi khi thống kê nhân viên theo phòng ban, dữ liệu đã được rollback: " + e.getMessage());
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
        return result;
    }

    @Override
    public int countTotalEmployees() {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL countTotalEmployees()}");
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("total_employees");
                conn.commit();
                return total;
            }
            conn.commit();
            return 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi đếm tổng số nhân viên, dữ liệu đã được rollback: " + e.getMessage());
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
    public Object[] departmentWithMostEmployees() {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL departmentWithMostEmployees()}");
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                Object[] result = new Object[]{rs.getString("dpmt_name"), rs.getInt("employee_count")};
                conn.commit();
                return result;
            }
            conn.commit();
            return null;
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm phòng ban có nhiều nhân viên nhất, dữ liệu đã được rollback: " + e.getMessage());
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
        return null;
    }

    @Override
    public Object[] departmentWithHighestSalary() {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL departmentWithHighestSalary()}");
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                Object[] result = new Object[]{rs.getString("dpmt_name"), rs.getDouble("average_salary")};
                conn.commit();
                return result;
            }
            conn.commit();
            return null;
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm phòng ban có lương cao nhất, dữ liệu đã được rollback: " + e.getMessage());
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
        return null;
    }
}
