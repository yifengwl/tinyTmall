package com.wanglu.tmall.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglu on 17/2/16.
 */
@Entity
@Table(name="category")
public class Category {
    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    private List<Product> products;

    @Transient
    private List<ArrayList<Product>> productsByRow ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<ArrayList<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<ArrayList<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }
}
