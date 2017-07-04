package com.artificial.services.impl;

import com.artificial.dao.srvc.UserDao;
import com.artificial.model.User;
import com.artificial.services.srvc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
