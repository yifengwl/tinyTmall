package com.wanglu.tmall.service;

import com.wanglu.tmall.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(int id);
    List<Category> findAllCategory();

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoruByID(int id);
}