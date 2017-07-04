package com.artificial.dao.srvc;

import com.artificial.model.User;


public interface UserDao {

    User get(Integer id);
    void add(User user);
    void update(User user);
    void delete(Integer id);

}
