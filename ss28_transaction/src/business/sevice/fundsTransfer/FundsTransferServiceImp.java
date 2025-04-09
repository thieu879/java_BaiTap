package business.sevice.fundsTransfer;

import business.dao.fundsTransfer.FundsTransferDAO;
import business.dao.fundsTransfer.FundsTransferDAOImp;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class FundsTransferServiceImp implements FundsTransferService {
    private final FundsTransferDAO fundsTransferDAO;

    public FundsTransferServiceImp() {
        fundsTransferDAO = new FundsTransferDAOImp();
    }

    @Override
    public ResultSet getTransactionHistory() {
        return fundsTransferDAO.getTransactionHistory();
    }

    @Override
    public BigDecimal getTransferAmountByDateRange(String startDate, String endDate) {
        return fundsTransferDAO.getTransferAmountByDateRange(startDate, endDate);
    }

    @Override
    public BigDecimal getReceivedAmountByAccount(int accId) {
        return fundsTransferDAO.getReceivedAmountByAccount(accId);
    }

    @Override
    public int getSuccessfulTransactionsByDateRange(String startDate, String endDate) {
        return fundsTransferDAO.getSuccessfulTransactionsByDateRange(startDate, endDate);
    }
}
