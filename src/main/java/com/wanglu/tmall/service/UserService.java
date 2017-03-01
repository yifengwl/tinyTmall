package com.wanglu.tmall.service;

import com.wanglu.tmall.model.User;

/**
 * Created by wanglu on 17/2/23.
 */
public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    boolean checkUser(User user);

    boolean isUserExist(User user);

}
