package main.dao;


import main.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {

    }
}
