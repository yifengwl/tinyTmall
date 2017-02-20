package com.wanglu.tmall.service;

import com.wanglu.tmall.dao.ProductDao;
import com.wanglu.tmall.model.Product;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wanglu on 17/2/20.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Resource(name = "productDao")
    private ProductDao dao;

    public Product getProductById(int id) {
        Product p = dao.findById(id);
        Hibernate.initialize(p.getCategory());
        Hibernate.initialize(p.getProductImages());
        return p;
    }
}
