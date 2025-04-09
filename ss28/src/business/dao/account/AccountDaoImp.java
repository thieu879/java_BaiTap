package business.dao.account;

import business.config.ConnectAccountDB;
import business.config.ConnectUserDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImp implements AccountDao{
    public static void main(String[] args) {
        AccountDaoImp accountDaoImp = new AccountDaoImp();
        accountDaoImp.transferMoney(1,2,100000);
    }
    @Override
    public void transferMoney(int from_id, int to_id, double amount) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectAccountDB.openConnectionAccount();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call transfer_money(?,?,?)}");
            callSt.setInt(1, from_id);
            callSt.setInt(2, to_id);
            callSt.setDouble(3, amount);
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
            ConnectAccountDB.closeConnectionAccount(conn, callSt);
        }
    }
}
