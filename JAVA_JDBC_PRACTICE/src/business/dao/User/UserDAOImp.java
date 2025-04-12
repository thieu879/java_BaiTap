package business.dao.User;



import business.config.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class UserDAOImp implements UserDAO {
    @Override
    public int login(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{CALL logIn(?,?,?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            callSt.registerOutParameter(3, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(3);
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình đăng nhập, dữ liệu đã được rollback: " + e.getMessage());
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
}
