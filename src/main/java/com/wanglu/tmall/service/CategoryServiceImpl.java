package com.wanglu.tmall.service;

import com.wanglu.tmall.dao.CategoryDao;
import com.wanglu.tmall.model.Category;
import com.wanglu.tmall.model.Product;
import com.wanglu.tmall.model.ProductImage;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
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
            for (Product p : c.getProducts()) {
                Hibernate.initialize(p.getProductImages());
                Iterator<ProductImage> imageIterator = p.getProductImages().iterator();
                while(imageIterator.hasNext()){
                    ProductImage pi = imageIterator.next();
                    if(pi.getType().equals("type_single")){
                        p.setFirstProductImage(pi);
                        break;
                    }
                }

            }

            //divided  5 product per list
            Iterator<Product> it = c.getProducts().iterator();
            ArrayList<Product> productsKeeper = new ArrayList<Product>();
            List<ArrayList<Product>> lap = new ArrayList<ArrayList<Product>>();
            int index = 1;
            while (it.hasNext()) {
                if (index % 5 != 0) {
                    productsKeeper.add(it.next());
                }else{
                    lap.add(productsKeeper);
                    productsKeeper = new ArrayList<Product>();
                    productsKeeper.add(it.next());
                }
            }
            lap.add(productsKeeper);
            c.setProductsByRow(lap);

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
