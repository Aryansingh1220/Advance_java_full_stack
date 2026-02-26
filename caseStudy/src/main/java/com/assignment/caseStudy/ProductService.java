package com.assignment.caseStudy;

import com.assignment.casestudy.product.entity.Product;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product, Long categoryId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(Long categoryId);

    List<Product> searchProduct(String name);

    void deleteProduct(Long id);
}