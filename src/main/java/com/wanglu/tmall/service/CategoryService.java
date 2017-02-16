package com.wanglu.tmall.service;

import com.wanglu.tmall.model.Category;
import com.wanglu.tmall.model.Product;

import java.util.List;

public interface CategoryService {

    Category findById(int id);

    List<Category> findAllCategory();

    List<Product> findByCategoryID(int id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoruByID(int id);

    void categoryProcess();
}