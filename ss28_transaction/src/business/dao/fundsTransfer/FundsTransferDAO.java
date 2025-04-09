package business.dao.fundsTransfer;

import business.dao.AppDao;

import java.math.BigDecimal;
import java.sql.ResultSet;

public interface FundsTransferDAO extends AppDao {
    ResultSet getTransactionHistory();
    BigDecimal getTransferAmountByDateRange(String startDate, String endDate);
    BigDecimal getReceivedAmountByAccount(int accId);
    int getSuccessfulTransactionsByDateRange(String startDate, String endDate);
}
