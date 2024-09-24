package hiber.dao;

import hiber.exception.EntityNotFoundException;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   public List<User> listUsers() {
      Query<User> query=sessionFactory.getCurrentSession().createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public User findUserBySerialAndModel(int series, String model) {
      try {
         Query<User> query = sessionFactory.getCurrentSession()
                 .createQuery("from User user where user.car.series = :series and user.car.model = :model", User.class)
                 .setParameter("model", model)
                 .setParameter("series", series);
          return query.uniqueResult();
      } catch (Exception e) {
         throw new EntityNotFoundException();
      }
   }
}
