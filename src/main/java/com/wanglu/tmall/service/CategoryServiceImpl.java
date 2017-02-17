package com.wanglu.tmall.service;

import com.wanglu.tmall.dao.CategoryDao;
import com.wanglu.tmall.model.Category;
import com.wanglu.tmall.model.Product;
import org.hibernate.Hibernate;
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
        List<Category> l = dao.findAllCategorys();

        for (Category c : l) {
            Hibernate.initialize(c.getProducts());
            for(Product p:c.getProducts()){
                Hibernate.initialize(p.getProductImages());
            }

//            List<ArrayList<Product>> productsByRow = new ArrayList<ArrayList<Product>>();
//            List<Product> products = pdao.findByCategoryId(c.getId());
//
//            int index = 0;
//            for (int i = 0; i < products.size(); ) {
//                ArrayList<Product> tmp = new ArrayList<Product>();
//                for (int j = 0; j < 5 && i < products.size(); j++) {
//                    tmp.add(products.get(i++));
//                }
//                productsByRow.add(tmp);
//
//            }
//            c.setProductsByRow(productsByRow);
//            c.setProducts(products);
        }
        return l;
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

    public void categoryProcess() {

    }
}
