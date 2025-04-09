package business.dao.user;

import business.config.ConnectUserDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    @Override
    public void insertUser(int id, String name, String email) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectUserDB.openConnectionUser();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call insert_user(?,?,?,?)}");
            callSt.setInt(1, id);
            callSt.setString(2, name);
            callSt.setString(3, email);
            callSt.execute();
            conn.commit();
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra trong quá trình chuyển khoản, dữ liệu đã được rollback");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với db: " + e.getMessage());
        } finally {
            ConnectUserDB.closeConnectionUser(conn, callSt);
        }
    }
}
