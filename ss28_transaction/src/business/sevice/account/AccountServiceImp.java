package business.sevice.account;

import business.dao.account.AccountDao;
import business.dao.account.AccountDaoImp;
import business.model.account.Acount;

import java.util.List;

public class AccountServiceImp implements AccountService {
    private final AccountDao accountDao;

    public AccountServiceImp() {
        accountDao = new AccountDaoImp();
    }

    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        return accountDao.fundsTransfer(accSenderId, accSenderName, accReceiverId, accReceiverName, amount);
    }

    @Override
    public List<Acount> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    @Override
    public int createAccount(Acount account) {
        return accountDao.createAccount(account);
    }

    @Override
    public int updateAccount(Acount account) {
        return accountDao.updateAccount(account);
    }

    @Override
    public int deleteAccount(int id) {
        return accountDao.deleteAccount(id);
    }

    @Override
    public Acount getAccountById(int id) {
        return accountDao.getAccountById(id);
    }
}