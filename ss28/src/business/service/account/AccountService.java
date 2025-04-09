package business.service.account;

import business.service.AppService;

public interface AccountService extends AppService {
    void transferMoney(int from_id, int to_id, double amount);
}
