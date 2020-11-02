package com.moshiur.shop.shop.products;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_model")
    private String productModel;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Product(int product_id, String product_name, String product_model) {
        this.productId = product_id;
        this.productName = product_name;
        this.productModel = product_model;
    }

    public Product() {
    }
}
