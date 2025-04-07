package business.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/StudentManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";
    public static Connection openConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định");
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement callst) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callst != null) {
            try {
                callst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
