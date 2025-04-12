package business.service.user;

import business.dao.User.UserDAO;
import business.dao.User.UserDAOImp;

import java.sql.SQLException;

public class UserServiceImp implements UserService {
    private UserDAO userDAO = new UserDAOImp();

    @Override
    public boolean login(String username, String password) throws SQLException {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên đăng nhập và mật khẩu không được để trống.");
        }
        return userDAO.login(username, password) == 1;
    }
}