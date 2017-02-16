package com.wanglu.tmall.service;

import com.wanglu.tmall.dao.CategoryDao;
import com.wanglu.tmall.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Resource(name = "categoryDao")
    private CategoryDao dao;

    public Category findById(int id) {
        return dao.findById(id);
    }

    public List<Category> findAllCategory() {
        return dao.findAllCategorys();
    }

    public void saveCategory(Category category) {
        dao.saveCategory(category);
    }

    public void updateCategory(Category category) {
        Category c = dao.findById(category.getId());
        c.setName(category.getName());
    }

    public void deleteCategoruByID(int id) {
        dao.deleteCategoryByID(id);
    }



}
