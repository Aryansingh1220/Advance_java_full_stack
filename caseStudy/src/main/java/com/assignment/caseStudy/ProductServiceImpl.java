package com.assignment.caseStudy;

import com.casestudy.product.entity.Category;
import com.casestudy.product.entity.Product;
import com.casestudy.product.exception.CategoryNotFoundException;
import com.casestudy.product.repository.CategoryRepository;
import com.casestudy.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public ProductServiceImpl(ProductRepository p, CategoryRepository c) {
        this.productRepo = p;
        this.categoryRepo = c;
    }

    public Product createProduct(Product product, Long categoryId) {

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        product.setCategory(category);
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepo.findByCategory_CategoryId(categoryId);
    }

    public List<Product> searchProduct(String name) {
        return productRepo.findByProductNameContaining(name);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}