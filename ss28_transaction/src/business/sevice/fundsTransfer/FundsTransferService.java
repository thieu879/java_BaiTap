package business.sevice.fundsTransfer;

import java.math.BigDecimal;
import java.sql.ResultSet;

public interface FundsTransferService {
    ResultSet getTransactionHistory();
    BigDecimal getTransferAmountByDateRange(String startDate, String endDate);
    BigDecimal getReceivedAmountByAccount(int accId);
    int getSuccessfulTransactionsByDateRange(String startDate, String endDate);
}

