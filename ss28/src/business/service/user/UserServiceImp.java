package business.service.user;

import business.dao.user.UserDao;
import business.dao.user.UserDaoImp;

public class UserServiceImp implements UserService {
    private UserDao userDao;

    public UserServiceImp() {
        userDao = new UserDaoImp();
    }

    @Override
    public void insertUser(int id, String name, String email) {
        userDao.insertUser(id, name, email);
    }
}
