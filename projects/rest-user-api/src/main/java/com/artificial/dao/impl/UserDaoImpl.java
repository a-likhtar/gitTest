package com.artificial.dao.impl;

import com.artificial.dao.srvc.UserDao;
import com.artificial.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by requi on 04.07.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User get(Integer id) {
        Session session = sessionFactory.openSession();
        User user = session.load(User.class, id);

        return user;
    }

    public void add(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        session.close();
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        tx.commit();
        session.close();
    }
}
