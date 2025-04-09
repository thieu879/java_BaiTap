package business.dao.account;

import business.config.ConnectionDB;
import business.model.account.Acount;
import business.model.account.AcountStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImp implements AccountDao {
    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call funds_transfer_amount(?,?,?,?,?,?)}");
            callSt.setInt(1, accSenderId);
            callSt.setString(2, accSenderName);
            callSt.setInt(3, accReceiverId);
            callSt.setString(4, accReceiverName);
            callSt.setDouble(5, amount);
            callSt.registerOutParameter(6, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(6);
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
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public List<Acount> getAllAccounts() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Acount> accounts = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call get_all_accounts()}");
            ResultSet rs = callSt.executeQuery();
            conn.commit();
            while (rs.next()) {
                Acount acc = new Acount();
                acc.setId(rs.getInt("acc_id"));
                acc.setName(rs.getString("acc_name"));
                acc.setBalance(rs.getDouble("acc_balance"));
                acc.setStatus(AcountStatus.valueOf(rs.getString("acc_status").toUpperCase()));
                accounts.add(acc);
            }
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
            ConnectionDB.closeConnection(conn, callSt);
        }
        return accounts;
    }

    @Override
    public int createAccount(Acount account) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call create_account(?,?,?,?)}");
            callSt.setString(1, account.getName());
            callSt.setDouble(2, account.getBalance());
            callSt.setString(3, account.getStatus().name());
            callSt.registerOutParameter(4, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(4);
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
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public int updateAccount(Acount account) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call update_account(?,?,?,?)}");
            callSt.setInt(1, account.getId());
            callSt.setString(2, account.getName());
            callSt.setString(3,account.getStatus().name());
            callSt.registerOutParameter(4, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(4);
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
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public int deleteAccount(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call delete_account(?,?)}");
            callSt.setInt(1, id);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(2);
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
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public Acount getAccountById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call get_account_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            conn.commit();
            if (rs.next()) {
                Acount acc = new Acount();
                acc.setId(rs.getInt("acc_id"));
                acc.setName(rs.getString("acc_name"));
                acc.setBalance(rs.getDouble("acc_balance"));
                acc.setStatus(AcountStatus.valueOf(rs.getString("acc_status").toUpperCase()));
                return acc;
            }
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
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }
}