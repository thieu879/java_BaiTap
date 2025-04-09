package business.dao.fundsTransfer;

import business.config.ConnectionDB;
import java.math.BigDecimal;
import java.sql.*;

public class FundsTransferDAOImp implements FundsTransferDAO {
    @Override
    public ResultSet getTransactionHistory() {
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call get_transaction_history()}");
            rs = callSt.executeQuery(); // lưu ResultSet để trả về
            conn.commit();
            return rs; // trả về ResultSet
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra trong quá trình lấy lịch sử giao dịch, dữ liệu đã được rollback");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        } finally {
            // không đóng conn ở đây vì ResultSet cần được sử dụng ngoài hàm
            // ConnectionDB.closeConnection(conn, callSt); // tạm thời bỏ để giữ ResultSet
        }
    }

    @Override
    public BigDecimal getTransferAmountByDateRange(String startDate, String endDate) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call get_transfer_amount_by_date_range(?,?,?)}");
            callSt.setDate(1, Date.valueOf(startDate));
            callSt.setDate(2, Date.valueOf(endDate));
            callSt.registerOutParameter(3, Types.DECIMAL);
            callSt.execute();
            BigDecimal totalAmount = callSt.getBigDecimal(3);
            conn.commit();
            return totalAmount;
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra trong quá trình thống kê số tiền chuyển, dữ liệu đã được rollback");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public BigDecimal getReceivedAmountByAccount(int accId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call get_received_amount_by_account(?,?)}");
            callSt.setInt(1, accId);
            callSt.registerOutParameter(2, Types.DECIMAL);
            callSt.execute();
            BigDecimal totalReceived = callSt.getBigDecimal(2);
            conn.commit();
            return totalReceived;
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra trong quá trình thống kê số tiền nhận, dữ liệu đã được rollback");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public int getSuccessfulTransactionsByDateRange(String startDate, String endDate) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call get_successful_transactions_by_date_range(?,?,?)}");
            callSt.setDate(1, Date.valueOf(startDate));
            callSt.setDate(2, Date.valueOf(endDate));
            callSt.registerOutParameter(3, Types.INTEGER); // sửa từ DECIMAL thành INTEGER
            callSt.execute();
            int transactionCount = callSt.getInt(3);
            conn.commit();
            return transactionCount;
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra trong quá trình thống kê giao dịch thành công, dữ liệu đã được rollback");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return 0;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}