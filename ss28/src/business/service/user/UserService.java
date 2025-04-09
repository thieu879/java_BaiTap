package business.service.user;

import business.service.AppService;

public interface UserService extends AppService {
    void insertUser(int id ,String name, String email);
}
