package com.artificial.services;

import com.artificial.dao.SpitterDao;
import com.artificial.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by lav on 24.08.2016.
 */

@Transactional
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterDao spitterDao;

    /*@Autowired
    public SpitterServiceImpl(SpitterDao spitterDao) {
        this.spitterDao = spitterDao;
    }*/

    public List<Spitter> getRecentSpittles() {
        return spitterDao.getRecentSpittles();
    }

    public void addUser(Spitter spitter) {
        spitterDao.addUser(spitter);
    }

    public int deleteSpitter(int spitterId) {
        return spitterDao.deleteSpitter(spitterId);
    }

    public int updateSpitter(Spitter spitter){
        return spitterDao.updateSpitter(spitter);
    }

    public Spitter getSpitterById(int id){
        return spitterDao.getSpitterById(id);
    }
}
