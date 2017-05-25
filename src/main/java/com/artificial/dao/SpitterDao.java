package com.artificial.dao;

import com.artificial.model.Spitter;

import java.util.List;

/**
 * Created by lav on 24.08.2016.
 */

public interface SpitterDao {
    public List<Spitter> getRecentSpittles();

    public void addUser(Spitter spitter);

    public int deleteSpitter(int spitterId);

    public int updateSpitter(Spitter spitter);

    public Spitter getSpitterById(int id);





}
