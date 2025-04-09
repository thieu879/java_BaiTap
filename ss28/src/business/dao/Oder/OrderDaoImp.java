package business.dao.Oder;

import business.config.ConnectOderDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderDaoImp implements OderDao {
    public static void main(String[] args) {
        OrderDaoImp dao = new OrderDaoImp();
        dao.createOrderWithDetails("Nguyễn Văn A", "11/02/2005", "bàn,ghế", "1,2");
    }
    @Override
    public void createOrderWithDetails(String customerName, String orderDate, String productName, String quantity) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectOderDB.openConnectionOder();
            conn.setAutoCommit(false);

            // Chuyển đổi orderDate từ String "dd/MM/yyyy" sang java.sql.Date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(orderDate, formatter);
            Date sqlDate = Date.valueOf(localDate);

            callSt = conn.prepareCall("{call create_order_with_details(?,?,?,?)}");
            callSt.setString(1, customerName);
            callSt.setDate(2, sqlDate);
            callSt.setString(3, productName);
            callSt.setString(4, quantity);

            callSt.execute();
            conn.commit();
        }catch(SQLException e){
            System.err.println("Có lỗi xảy ra trong quá trình chuyển khoản, dữ liệu đã được rollback");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với db: " + e.getMessage());
        } finally {
            ConnectOderDB.closeConnectionOder(conn, callSt);
        }
    }
}
