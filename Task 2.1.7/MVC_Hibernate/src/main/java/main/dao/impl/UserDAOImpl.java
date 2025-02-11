package main.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import main.dao.UserDAO;
import main.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        em.createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }
}