package com.wanglu.tmall.service;

import com.wanglu.tmall.dao.ProductDao;
import com.wanglu.tmall.model.Product;
import com.wanglu.tmall.model.ProductImage;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglu on 17/2/20.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource(name = "productDao")
    private ProductDao dao;

    private void initProduct(Product p) {
        Hibernate.initialize(p.getCategory());
        Hibernate.initialize(p.getProductImages());
        List<ProductImage> listProductSingleImage = new ArrayList<ProductImage>();
        List<ProductImage> listProductDetailImage = new ArrayList<ProductImage>();
        boolean first = true;
        for (ProductImage pi : p.getProductImages()) {
            if (pi.getType().equals("type_single")) {
                if (first) {
                    p.setFirstProductImage(pi);
                    first = false;
                }
                listProductSingleImage.add(pi);
            } else {
                listProductDetailImage.add(pi);
            }
        }
        p.setProductSingleImages(listProductSingleImage);
        p.setProductDetailImages(listProductDetailImage);
    }

    public Product getProductById(int id) {
        Product p = dao.findById(id);
        initProduct(p);
        return p;
    }

    public List<Product> getProductsByKeyword(String keyword) {
        List<Product> lp = dao.findByKeyword(keyword);
        for (Product p : lp) {
            initProduct(p);
        }

        return lp;
    }
}
