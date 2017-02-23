package com.wanglu.tmall.service;

import com.wanglu.tmall.model.Product;

import java.util.List;

/**
 * Created by wanglu on 17/2/20.
 */
public interface ProductService {
    Product getProductById(int id);
    List<Product> getProductsByKeyword(String keyword);
}
