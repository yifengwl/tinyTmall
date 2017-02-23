package com.wanglu.tmall.dao;

import com.wanglu.tmall.model.Category;

import java.util.List;

public interface CategoryDao {

    Category findById(int id);
    void saveCategory(Category employee);
    List<Category> findAllCategorys();
    void deleteCategoryByID(int id);

}
