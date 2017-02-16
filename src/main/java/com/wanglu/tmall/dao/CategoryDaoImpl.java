package com.wanglu.tmall.dao;

import com.wanglu.tmall.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

    public Category findById(int id) {
        return getByKey(id);
    }

    public void saveCategory(Category category) {
        persist(category);
    }

    public void deleteCategoryByID(int id) {
        Query query = getSession().createSQLQuery("delete from category where ssn = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAllCategorys() {
        Criteria criteria = createEntityCriteria();
        return (List<Category>) criteria.list();
    }
}