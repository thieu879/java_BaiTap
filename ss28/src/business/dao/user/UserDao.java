package business.dao.user;

import business.dao.AppDao;
import business.model.User;

public interface UserDao extends AppDao {
    void insertUser(int id ,String name, String email);
}
