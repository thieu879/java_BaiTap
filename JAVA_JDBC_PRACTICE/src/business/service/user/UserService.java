package business.service.user;

import java.sql.SQLException;

public interface UserService {
    boolean login(String username, String password) throws SQLException;
}