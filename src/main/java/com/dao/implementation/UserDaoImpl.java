package com.dao.implementation;

import com.dao.interfaces.UserDao;
import com.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public User get(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(id);
    }

    @Override
    public User getPersonByCredentials(String email) {
        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User where email=:emailUser",User.class)
                .setParameter("emailUser",email);

        return query.uniqueResult();
    }
}
