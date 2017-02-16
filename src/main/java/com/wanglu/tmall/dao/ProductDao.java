package com.wanglu.tmall.dao;



import com.wanglu.tmall.model.Product;

import java.util.List;

/**
 * Created by wanglu on 17/2/16.
 */
public interface ProductDao {
    Product findById(int id);
    void saveProduct(Product product);
    List<Product> findAllProducts();
    List<Product> findByCategoryId(int id);
    void deleteProductByID(int id);

}
