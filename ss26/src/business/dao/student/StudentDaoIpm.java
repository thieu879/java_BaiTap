package business.dao.student;

import business.config.ConnectionDB;
import business.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoIpm implements StudentDao {
    @Override
    public int getCountStudentByStatus(boolean status) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_count_student_by_status(?,?)}");
            callst.setBoolean(1, status);
            callst.registerOutParameter(2, Types.INTEGER);
            callst.execute();
            return callst.getInt(2);
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return 0;
    }

    @Override
    public Student findById(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call get_student_by_id(?)}");
            callst.setInt(1, id);
            ResultSet rs = callst.executeQuery();
            student = new Student();
            if (rs.next()) {
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
                student.setStatus(rs.getBoolean(4));
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callst = null;
        List<Student> listStudent = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call find_all_student()}");
            ResultSet rs = callst.executeQuery();
            listStudent = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
                student.setStatus(rs.getBoolean(4));
                listStudent.add(student);
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return listStudent;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call create_student(?,?,?)}");
            callst.setString(1, student.getName());
            callst.setInt(2, student.getAge());
            callst.setBoolean(3, student.isStatus());
            callst.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call update_student(?,?,?,?)}");
            callst.setInt(1, student.getId());
            callst.setString(2, student.getName());
            callst.setInt(3, student.getAge());
            callst.setBoolean(4, student.isStatus());
            callst.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call delete_student(?)}");
            callst.setInt(1, student.getId());
            callst.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return false;
    }
}
