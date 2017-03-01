package com.wanglu.tmall.service;

import com.wanglu.tmall.dao.UserDao;
import com.wanglu.tmall.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wanglu on 17/2/23.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        userDao.newUser(user);
    }

    public void updateUser(User user) {
        User entity = userDao.findById(user.getId());
        if (entity != null) {
            entity.setPassword(user.getPassword());
        }
    }

    public boolean checkUser(User user) {
        User u = userDao.getByUsername(user.getName());
        if (u == null) {
            return false;
        }
        if (u.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean isUserExist(User user) {
        return userDao.isExist(user.getName());
    }

}
