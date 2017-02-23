package com.wanglu.tmall.dao;

import com.wanglu.tmall.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by wanglu on 17/2/23.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao{

    public User findById(int id) {
        return getByKey(id);
    }

    public void newUser(User user) {
        persist(user);
    }

    public boolean isExist(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        Object o = criteria.uniqueResult();
        return o!=null;
    }

    public User getByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User)criteria.uniqueResult();
    }
}
