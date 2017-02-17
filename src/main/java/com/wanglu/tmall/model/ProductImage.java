package com.wanglu.tmall.model;

import javax.persistence.*;

/**
 * Created by wanglu on 17/2/17.
 */
@Entity
@Table(name ="productimage")
public class ProductImage {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    private String type;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
}
