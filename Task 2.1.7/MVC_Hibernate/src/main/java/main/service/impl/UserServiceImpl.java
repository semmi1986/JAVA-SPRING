package main.service.impl;

import main.model.User;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)

//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Override
//    public List<User> getAllUsers() {
//        return userDAO.getAllUsers();
//    }
//
//    @Override
//    public void addUser(User user) {
//        userDAO.addUser(user);
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return userDAO.getUserById(id);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userDAO.deleteUser(id);
//    }
//
//    @Override
//    public void updateUser(User user) {
//        userDAO.updateUser(user);
//    }
//}
public class UserServiceImpl {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        Optional<User> foundPerson = userRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(Long id, User updateuser) {
        updateuser.setId(id);
        userRepository.save(updateuser);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}