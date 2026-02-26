package com.assignment.caseStudy;

import com.casestudy.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContaining(String name);

    List<Product> findByCategory_CategoryId(Long categoryId);
}