package com.assignment.caseStudy;

import com.casestudy.product.entity.Product;
import com.casestudy.product.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/{categoryId}")
    public Product create(@RequestBody Product product,
                          @PathVariable Long categoryId) {
        return service.createProduct(product, categoryId);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> byCategory(@PathVariable Long categoryId) {
        return service.getProductsByCategory(categoryId);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return service.searchProduct(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}