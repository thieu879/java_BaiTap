package business.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/employs_db";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection openConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Không thể mở kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }
    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng CallableStatement: " + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng Connection: " + e.getMessage());
            }
        }
    }
}