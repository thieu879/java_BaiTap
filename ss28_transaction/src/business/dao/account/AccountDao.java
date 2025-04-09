package business.dao.account;

import business.dao.AppDao;
import business.model.account.Acount;

import java.util.List;

public interface AccountDao extends AppDao {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
    List<Acount> getAllAccounts();
    int createAccount(Acount account);
    int updateAccount(Acount account);
    int deleteAccount(int id);
    Acount getAccountById(int id);
}
