package com.artificial.services.srvc;

import com.artificial.model.User;


public interface UserService {
    User get(Integer id);
    void add(User user);
    void update(User user);
    void delete(Integer id);
}
