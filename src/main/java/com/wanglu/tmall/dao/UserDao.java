package com.wanglu.tmall.dao;

import com.wanglu.tmall.model.User;

/**
 * Created by wanglu on 17/2/23.
 */
public interface UserDao {
    User findById(int id);

    void newUser(User user);

    boolean isExist(String username);

    User getByUsername(String username);
}
