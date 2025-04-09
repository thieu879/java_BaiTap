package business.sevice.account;

import business.model.account.Acount;
import business.sevice.AppService;

import java.util.List;

public interface AccountService extends AppService {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
    List<Acount> getAllAccounts();
    int createAccount(Acount account);
    int updateAccount(Acount account);
    int deleteAccount(int id);
    Acount getAccountById(int id);
}
