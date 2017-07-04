package com.artificial.services.srvc;

import com.artificial.model.User;

/**
 * Created by requi on 04.07.2017.
 */
public interface UserService {
    User get(Integer id);
    void add(User user);
    void update(User user);
    void delete(Integer id);
}
