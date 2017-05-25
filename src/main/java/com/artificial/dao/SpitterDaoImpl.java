package com.artificial.dao;

import com.artificial.model.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lav on 24.08.2016.
 */
@Repository

public class SpitterDaoImpl implements SpitterDao{


    @Autowired
    private SessionFactory sessionFactory;

    /*@Autowired
    public SpitterDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Transactional
    public List<Spitter> getRecentSpittles() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Spitter> spitterList = session.createQuery("from Spitter").list();
        tx.commit();
        session.close();
        return spitterList;
    }

    public void addUser(Spitter spitter) {
        Session session = sessionFactory.openSession();
        session.save(spitter);
        session.close();

    }

    public int updateSpitter(Spitter spitter){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(spitter);
        tx.commit();
        Serializable id = session.getIdentifier(spitter);
        session.close();
        return (Integer) id;
    }

    public Spitter getSpitterById(int id){
        Session session = sessionFactory.openSession();
        Spitter spitter = session.load(Spitter.class, id);
        return spitter;
    }

    public int deleteSpitter(int spitterId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Spitter spitter = session.load(Spitter.class, spitterId);
        session.delete(spitter);
        tx.commit();
        Serializable ids = session.getIdentifier(spitter);
        session.close();
        return (Integer) ids;
    }

}
