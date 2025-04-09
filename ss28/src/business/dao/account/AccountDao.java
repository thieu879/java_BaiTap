package business.dao.account;

import business.dao.AppDao;

public interface AccountDao extends AppDao {
    void transferMoney(int from_id, int to_id, double amount);
}
