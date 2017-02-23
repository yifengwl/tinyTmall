package com.wanglu.tmall.dao;

import com.wanglu.tmall.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wanglu on 17/2/16.
 */
@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer,Product> implements ProductDao{
    public Product findById(int id) {
        return getByKey(id);
    }

    public void saveProduct(Product product) {
           persist(product);
    }

    public List<Product> findAllProducts() {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
    }

    public List<Product> findByKeyword(String keyword) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.like("name", "%"+keyword+"%"));
        return (List<Product>) criteria.list();
    }

    public void deleteProductByID(int id) {

    }

    public List<Product> findByCategoryId(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cid", id));
        return (List<Product>) criteria.list();
    }
}
