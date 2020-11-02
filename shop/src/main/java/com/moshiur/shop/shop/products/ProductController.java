package com.moshiur.shop.shop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/product")
    private List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/product/{pmodel}")
    private List<Product> getByModel(@PathVariable("pmodel") String model) {
        return productService.getByModel(model);
    }


    @GetMapping("/product/{productid}")
    private Product getProduct(@PathVariable("productid") int productid) {
        return productService.getProductById(productid);
    }


    @DeleteMapping("/product/{productid}")
    private void deleteproduct(@PathVariable("productid") int productid) {
        productService.delete(productid);
    }


    @PostMapping("/product")
    private int saveproduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getProductId();
    }


    @PutMapping("/product")
    private Product update(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product;
    }

    @PutMapping("/product/{id}")
    public void saveResource(@RequestBody Product product,
                             @PathVariable("id") int id) {
        Product productToUpdate = productService.getProductById(id);

        productToUpdate.setProductModel(product.getProductModel());
        productToUpdate.setProductName(product.getProductName());
        productService.saveOrUpdate(productToUpdate);
    }
}