package business.service.account;

import business.dao.account.AccountDao;
import business.dao.account.AccountDaoImp;

public class AccountServiceImp implements AccountService{
    private final AccountDao accountDao;

    public AccountServiceImp() {
        accountDao = new AccountDaoImp();
    }

    @Override
    public void transferMoney(int from_id, int to_id, double amount) {
        accountDao.transferMoney(from_id, to_id, amount);
    }
}
