package Controller;

import business.service.user.UserService;
import business.service.user.UserServiceImp;

import java.sql.SQLException;

public class UserController {
    private UserService userService = new UserServiceImp();
    public boolean handleLogin(String username, String password) {
        try {
            return userService.login(username, password);
        } catch (SQLException e) {
            System.out.println("Lỗi đăng nhập: " + e.getMessage());
            return false;
        }
    }
}
