package business.dao.User;

import business.dao.AppDao;

public interface UserDAO extends AppDao {
    int login(String username, String password);
}
