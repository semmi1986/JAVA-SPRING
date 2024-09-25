package main.dao;

import main.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(Long id);
    void updateUser(User user);

    @Transactional
    void deleteUser(Long id);
}
