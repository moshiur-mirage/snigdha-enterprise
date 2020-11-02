package com.moshiur.shop.shop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProduct() {
        List<Product> product = new ArrayList<Product>();
        productRepository.findAll().forEach(product1 -> product.add(product1));
        return product;
    }


    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }


    public void saveOrUpdate(Product Product) {
        productRepository.save(Product);
    }


    public void delete(int id) {
        productRepository.deleteById(id);
    }


    public List<Product> getByModel(String model) {
        return productRepository.findByproductModel(model);
    }
}