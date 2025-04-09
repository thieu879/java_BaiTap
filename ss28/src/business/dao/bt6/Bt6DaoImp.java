package business.dao.bt6;

import business.config.ConnectOderDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bt6DaoImp implements Bt6Dao {

    @Override
    public void add_department_with_employees(String departmentName, String employeeName) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectOderDB.openConnectionOder();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{call add_department_with_employees(?,?)}");
            callSt.setString(1, departmentName);
            callSt.setString(2, employeeName);

            callSt.execute();
            conn.commit();
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với db: " + e.getMessage());
        } finally {
            ConnectOderDB.closeConnectionOder(conn, callSt);
        }
    }
}
